package de.nak.stundenplandb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import de.nak.stundenplandb.dao.AppointmentDAO;
import de.nak.stundenplandb.dao.RoomDAO;
import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.ERoomType;
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
				//First comparing the buildung
				int buildingCompare = o1.getBuilding().compareTo(o2.getBuilding());
				//If building is the same, the roomNumber is relevant
				if(buildingCompare == 0){
					return o1.getRoomNumber().compareTo(o2.getRoomNumber());
				}else{
					return buildingCompare;
				}
			}
		};
		Collections.sort(rooms, roomComparator);
		return rooms;
	}

	@Override
	public List<Appointment> getAppointmentsForRoom(Long roomId) {
		return getAppointmentsForRoomInTimeperiod(roomId,
				new Date(Long.MIN_VALUE), new Date(Long.MAX_VALUE));
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
		}
		return appointments;
	}
	
	@Override
	public List<ERoomType> getAllRoomTypes() {
		return Arrays.asList(ERoomType.values());
	}
	
	@Override
	public List<Room> findFreeRoomsForTimeperiod(Date startDate, Date endDate) {
		// TODO FK: Suche freier Räume implementieren
		return new ArrayList<Room>();
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	
	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}
}
