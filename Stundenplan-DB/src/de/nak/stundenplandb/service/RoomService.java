package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.ERoomType;
import de.nak.stundenplandb.model.Room;

/**
 * Schnittstelle für den RoomService
 * 
 * @author Lars Lembke
 *
 */
public interface RoomService {
	/**
	 * Creates a room.
	 *
	 * @param room
	 *            The room.
	 */
	void saveRoom(Room room);
	
	/**
	 * Loads a list of all room.
	 *
	 * @return a list which is empty if no room was found.
	 */
	List<Room> loadAllRooms();

	/**
	 * Returns the Enum ERoomType as a list
	 * 
	 * @return roomType
	 */
	List<ERoomType> getAllRoomTypes();

	/**
	 * Returns the Enum ERoomType as a list The list is sorted by the building
	 * and afterwards by the roomNumber
	 * 
	 * @return roomType
	 */
	List<Room> loadAllRoomsSortedBYBuildungAndNumber();
	
	/**
	 * Search for unused rooms in a specific period of time.
	 * @param startDate Start of timeperiod
	 * @param endDate End of timeperiod
	 * @return List of free rooms
	 */
	List<Room> findFreeRoomsForTimeperiod(Date startDate, Date endDate);
}
