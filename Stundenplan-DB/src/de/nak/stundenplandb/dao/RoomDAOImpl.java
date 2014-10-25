package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Room;

/**
 * Implemenation des RoomDAO
 * 
 * @author Lars Lembke
 *
 */
public class RoomDAOImpl extends GenericDaoImplTemp<Room> implements RoomDAO {

	public RoomDAOImpl() {
		super(Room.class);
	}

}
