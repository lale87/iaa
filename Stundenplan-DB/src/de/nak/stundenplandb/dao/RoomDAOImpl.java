package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Room;

/**
 * Implemenation des RoomDAO
 * 
 * @author Lars Lembke
 *
 */
public class RoomDAOImpl extends GenericDAOImpl<Room> implements RoomDAO {

	public RoomDAOImpl() {
		super(Room.class);
	}

}
