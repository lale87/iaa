package de.nak.stundenplandb.service;

import java.util.ArrayList;
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
 * Implementation for the RoomService
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
	public List<Appointment> getAppointmentsForRoomInWeek(Long roomId,
			int week, int year) {
		Date start, end;
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.YEAR, year);
		start = cal.getTime();
		// check if the following week is in the next year
		cal.clear();
		cal.set(year, 11, 31);
		if (week == cal.get(Calendar.WEEK_OF_YEAR)) {
			week = 0;
			year++;
		}
		cal.clear();
		cal.set(Calendar.WEEK_OF_YEAR, week + 1);
		cal.set(Calendar.YEAR, year);
		end = cal.getTime();
		return getAppointmentsForRoomInTimeperiod(roomId, start, end);
	}

	@Override
	public List<Appointment> getAppointmentsForRoomInTimeperiod(Long roomId,
			Date start, Date end) {
		Room room = roomDAO.load(roomId);
		List<Appointment> appointments = appointmentDAO
				.loadAppointmentsForRoom(room);
		appointments = filterAppointmentsForTimeperiod(appointments, start, end);
		// initialize appointments
		for (Appointment appointment : appointments) {
			Hibernate.initialize(appointment.getMeeting());
			Hibernate.initialize(appointment.getMeeting().getRooms());
			Hibernate.initialize(appointment.getMeeting().getLecturer());
			// initialize lectures
			if (EMeetingType.LECTURE.equals(appointment.getMeeting()
					.getMeetingType())) {
				Hibernate.initialize(((Lecture) appointment.getMeeting())
						.getStudentGroup());
			}
			// initialize exams
			if (EMeetingType.EXAM.equals(appointment.getMeeting()
					.getMeetingType())) {
				Hibernate.initialize(((Exam) appointment.getMeeting())
						.getStudentGroups());
			}
			// initialize electives
			if (EMeetingType.ELECTIVE.equals(appointment.getMeeting()
					.getMeetingType())) {
				Hibernate.initialize(((Elective) appointment.getMeeting())
						.getCohort());
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
		// List<Room> freeRooms = roomDAO.getFreeRoomsForTimeperiod(startDate,
		// endDate);
		List<Room> rooms = roomDAO.loadAll();
		List<Room> freeRooms = new ArrayList<Room>();
		// check changing times
		for (Room room : rooms) {
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

			List<Appointment> appointments = appointmentDAO
					.loadAppointmentsForRoom(room);
			// TODO kann das weg?
			// boolean isOccupied = false;
			// for (Appointment a : appointments) {
			// // create date/time objects
			// Calendar as = Calendar.getInstance();
			// Calendar ae = Calendar.getInstance();
			// Calendar s = Calendar.getInstance();
			// Calendar e = Calendar.getInstance();
			// as.setTime(a.getStart());
			// ae.setTime(a.getEnd());
			// s.setTime(startDateWithChangingTime);
			// e.setTime(endDateWithChangingTime);
			//
			// // s' >= s && e' <= e
			// if ((as.after(s) || as.equals(s))
			// && (ae.before(e) || ae.equals(e))) {
			// isOccupied = true;
			// break;
			// // s' < s && e' >= s
			// } else if (as.before(s) && (ae.after(s) || ae.equals(s))) {
			// isOccupied = true;
			// break;
			// // s' <= e && e' > e
			// } else if ((as.before(e) || as.equals(e)) && ae.after(e)) {
			// isOccupied = true;
			// break;
			// }
			// }

			if (filterAppointmentsForTimeperiod(appointments,
					startDateWithChangingTime, endDateWithChangingTime)
					.isEmpty()) {
				freeRooms.add(room);
			}
		}
		return freeRooms;
	}

	/**
	 * Filters a list of appointments for a specific timeperiod.
	 * 
	 * @param appointments
	 *            List of appointments
	 * @param start
	 *            Start date
	 * @param end
	 *            End date
	 * @return List of Appointments in the given timeperiod
	 */
	private List<Appointment> filterAppointmentsForTimeperiod(
			List<Appointment> appointments, Date start, Date end) {
		List<Appointment> appointmentsInTimeperiod = new ArrayList<Appointment>();

		// iterate appointments
		for (Appointment a : appointments) {
			// create date/time objects
			Calendar as = Calendar.getInstance();
			Calendar ae = Calendar.getInstance();
			Calendar s = Calendar.getInstance();
			Calendar e = Calendar.getInstance();
			as.setTime(a.getStart());
			ae.setTime(a.getEnd());
			s.setTime(start);
			e.setTime(end);

			// s' >= s && e' <= e
			if ((as.after(s) || as.equals(s)) && (ae.before(e) || ae.equals(e))) {
				appointmentsInTimeperiod.add(a);
				continue;
				// s' < s && e' >= s
			} else if (as.before(s) && (ae.after(s) || ae.equals(s))) {
				appointmentsInTimeperiod.add(a);
				continue;
				// s' <= e && e' > e
			} else if ((as.before(e) || as.equals(e)) && ae.after(e)) {
				appointmentsInTimeperiod.add(a);
				continue;
			}
		}

		return appointmentsInTimeperiod;
	}

	/**
	 * Injects the roomDAO
	 * 
	 * @param roomDAO
	 */
	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}

	/**
	 * Injects the appointmentDAO
	 * 
	 * @param appointmentDAO
	 */
	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	public boolean isOccupied(Long id, Date startDate, Date endDate) {
		Room room = roomDAO.load(id);
		Integer changingTime = room.getChangingTime();
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
		// When there is no Appointment in this room within the given period,
		// it is not occupied
		List<Appointment> appointments = appointmentDAO
				.loadAppointmentsForRoom(room);
		return !filterAppointmentsForTimeperiod(appointments,
				startDateWithChangingTime, endDateWithChangingTime).isEmpty();
		// return roomDAO.isOccupied(id, startDateWithChangingTime,
		// endDateWithChangingTime);
	}

}
