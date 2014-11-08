package de.nak.stundenplandb.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import de.nak.stundenplandb.dao.AppointmentDAO;
import de.nak.stundenplandb.dao.RoomDAO;
import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.ERoomType;
import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Room;

/**
 * Implementation des RoomService
 * 
 * @author Lars Lembke
 *
 */
public class RoomServiceImpl implements RoomService {
	/**
	 * Injected RoomDAO
	 */
	private RoomDAO roomDAO;
	/**
	 * Injected AppointmentDAO
	 */
	private AppointmentDAO appointmentDAO;

	@Override
	public void saveRoom(Room room) {
		roomDAO.save(room);
	}

	@Override
	public List<Room> loadAllRooms() {
		return roomDAO.loadAll();
	}

	@Override
	public List<Room> loadAllRoomsSortedBYBuildungAndNumber() {
		List<Room> rooms = roomDAO.loadAll();

		Comparator<Room> roomComparator = new Comparator<Room>() {

			@Override
			public int compare(Room o1, Room o2) {
				// First comparing the buildung
				int buildingCompare = o1.getBuilding().compareTo(
						o2.getBuilding());
				// If building is the same, the roomNumber is relevant
				if (buildingCompare == 0) {
					return o1.getRoomNumber().compareTo(o2.getRoomNumber());
				} else {
					return buildingCompare;
				}
			}
		};
		Collections.sort(rooms, roomComparator);
		return rooms;
	}

	@Override
	public List<Appointment> getAppointmentsForRoom(Long roomId) {
		return getAppointmentsForRoomInTimeperiod(roomId, new Date(
				Long.MIN_VALUE), new Date(Long.MAX_VALUE));
	}

	@Override
	public List<Appointment> getAppointmentsForRoomInTimeperiod(Long roomId,
			Date start, Date end) {
		// TODO FK: Fehlerbehandlung?
		Room room = roomDAO.load(roomId);
		List<Appointment> appointments = appointmentDAO
				.loadAppointmentsForRoomInTimeperiod(room, start, end);
		// initialize appointments
		for (Appointment appointment : appointments) {
			Hibernate.initialize(appointment.getMeeting());
			Hibernate.initialize(appointment.getMeeting().getRooms());
			Hibernate.initialize(appointment.getMeeting().getLecturer());
			// initialize lectures
			if (EMeetingType.LECTURE.equals(
					appointment.getMeeting().getMeetingType())) {
				Hibernate.initialize(
						((Lecture)appointment.getMeeting()).getStudentGroup());
			}
			// initialize exams
			if (EMeetingType.EXAM.equals(
					appointment.getMeeting().getMeetingType())) {
				Hibernate.initialize(
						((Exam)appointment.getMeeting()).getStudentGroups());
			}
			// initialize electives
			if (EMeetingType.ELECTIVE.equals(
					appointment.getMeeting().getMeetingType())) {
				Hibernate.initialize(
						((Elective)appointment.getMeeting()).getCohort());
			}
		}
		return appointments;
	}

	@Override
	public List<ERoomType> getAllRoomTypes() {
		return Arrays.asList(ERoomType.values());
	}

	@Override
	public List<Room> findFreeRoomsForTimeperiod(Date startDate, Date endDate) {
//		List<Room> freeRooms = roomDAO.getFreeRoomsForTimeperiod(startDate,
//				endDate);
		List<Room> freeRooms = roomDAO.loadAll();
		// check changing times
		for (Room room : freeRooms) {
			int changingTime = room.getChangingTime();

			// check min. changing time
			if (changingTime < room.getRoomType().getMinBreak()) {
				changingTime = room.getRoomType().getMinBreak();
			}

			// calculate new start/end
			Calendar cal = Calendar.getInstance();

			Date startDateWithChangingTime;
			cal.setTime(startDate);
			cal.add(Calendar.MINUTE, -changingTime);
			startDateWithChangingTime = cal.getTime();

			Date endDateWithChangingTime;
			cal.setTime(endDate);
			cal.add(Calendar.MINUTE, changingTime);
			endDateWithChangingTime = cal.getTime();

			// check room again with changing time
//			if (!roomDAO.isFreeForTimeperiod(room, startDateWithChangingTime,
//					endDateWithChangingTime)) {
//				freeRooms.remove(room);
//			}
			if (!appointmentDAO.loadAppointmentsForRoomInTimeperiod(
					room, startDateWithChangingTime, endDateWithChangingTime)
					.isEmpty()) {
				freeRooms.remove(room);
			}
		}
		return freeRooms;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}

	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	public boolean isOccupied(Long id, Date startDate, Date endDate) {
		Integer changingTime = roomDAO.load(id).getChangingTime();
		// Calculate new time with changingTime
		Calendar cal = Calendar.getInstance();

		Date startDateWithChangingTime;
		cal.setTime(startDate);
		cal.add(Calendar.MINUTE, -changingTime);
		startDateWithChangingTime = cal.getTime();

		Date endDateWithChangingTime;
		cal.setTime(endDate);
		cal.add(Calendar.MINUTE, changingTime);
		endDateWithChangingTime = cal.getTime();
		return roomDAO.isOccupied(id, startDateWithChangingTime,
				endDateWithChangingTime);
	}

}
