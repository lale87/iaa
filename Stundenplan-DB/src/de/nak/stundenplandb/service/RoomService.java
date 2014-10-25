package de.nak.stundenplandb.service;

import java.util.List;

import de.nak.stundenplandb.model.Room;

/**
 * Schnittstelle für den RoomService
 * @author Lars Lembke
 *
 */
public interface RoomService {
	/**
	 * Creates or updates a car.
	 *
	 * @param car The car.
	 */
	void saveRoom(Room car);


	/**
	 * Loads a list of all cars.
	 *
	 * @return a list which is empty if no car was found.
	 */
	List<Room> loadAllRooms();
}
