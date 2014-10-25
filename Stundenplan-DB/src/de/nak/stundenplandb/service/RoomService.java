package de.nak.stundenplandb.service;

import java.util.List;

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
}
