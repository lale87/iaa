package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Room;

/**
 * Implemenation of the RoomDAO
 * 
 * @author Lars Lembke, Fabian Kolossa
 *
 */
public class RoomDAOImpl extends GenericDAOImpl<Room> implements RoomDAO {

	public RoomDAOImpl() {
		super(Room.class);
	}

}
