package de.nak.roommgmt.service;

import de.nak.roommgmt.HibernateUtil;
import de.nak.roommgmt.model.Room;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

/**
 * The room service that manages all business functionality.
 *
 * @author Stephan Anft
 */
public class RoomService {
	/**
	 * The current Hibernate session.
	 */
	private final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	/**
	 * Creates a new room and stores it in the database.
	 *
	 * @param building   The building.
	 * @param roomNumber The room number.
	 * @param seats	  The number of seats.
	 * @param beamer	 The beamer flag.
	 * @throws RoomAlreadyPresentException if a room with the same building/room number
	 *                                     combination is already present in the database.
	 */
	public void createRoom(String building, int roomNumber, int seats, boolean beamer) throws RoomAlreadyPresentException {
		// Create room object
		Room room = new Room();
		room.setBuilding(building);
		room.setRoomNumber(roomNumber);
		room.setSeats(seats);
		room.setBeamer(beamer);
		try {
			session.save(room);
		}
		catch (ConstraintViolationException ex) {
			throw new RoomAlreadyPresentException();
		}
	}

	/**
	 * List all rooms currently stored in the database.
	 *
	 * @return a list of Room entities. If no room was found an empty list is
	 *         returned.
	 */
	@SuppressWarnings("unchecked")
	public List<Room> listRooms() {
		return (List<Room>) session.createQuery("from Room").list();
	}

	/**
	 * Returns the room identified by the given id.
	 *
	 * @param id The identifier.
	 * @return the found entity.
	 * @throws RoomNotFoundException if no room could be found for the given id.
	 */
	public Room showRoom(Long id) throws RoomNotFoundException {
		Room room = (Room) session.get(Room.class, id);
		if (room == null) {
			throw new RoomNotFoundException();
		}
		return room;
	}

	/**
	 * Updates a room entity and stores the changes into the database.
	 *
	 * @param id	 The identifier.
	 * @param seats  The number of seats.
	 * @param beamer The beamer flag.
	 * @throws RoomNotFoundException if no room could be found for the given id.
	 */
	public void updateRoom(Long id, int seats, boolean beamer) throws RoomNotFoundException {
		Room room = (Room) session.get(Room.class, id);
		if (room == null) {
			throw new RoomNotFoundException();
		}
		room.setSeats(seats);
		room.setBeamer(beamer);
	}

	/**
	 * Deletes the room with the given id.
	 *
	 * @param id The identifier.
	 * @throws RoomNotFoundException if no room could be fount for the given id.
	 */
	public void deleteRoom(Long id) throws RoomNotFoundException {
		Room room = (Room) session.get(Room.class, id);
		if (room == null) {
			throw new RoomNotFoundException();
		}
		session.delete(room);
	}
}
