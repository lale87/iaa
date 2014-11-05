package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Room;

/**
 * Schnittstelle des Room-DAO
 * @author Lars Lembke, Fabian Kolossa
 *
 */
public interface RoomDAO extends GenericDAO<Room> {
	/**
	 * Find free rooms for a specific period of time.
	 * @param start Start date
	 * @param end End date
	 * @return List of free rooms
	 */
	List<Room> getFreeRoomsForTimeperiod(Date start, Date end);
	
	/**
	 * Checks whether the room is available for a specific period of time.
	 * @param room Room instance
	 * @param start Start date
	 * @param end End date
	 * @return Is free?
	 */
	boolean isFreeForTimeperiod(Room room, Date start, Date end);
}
