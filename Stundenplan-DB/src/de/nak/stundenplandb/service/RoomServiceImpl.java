package de.nak.stundenplandb.service;

import java.util.List;

import de.nak.stundenplandb.dao.RoomDAO;
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

	@Override
	public void saveRoom(Room room) {
		roomDAO.save(room);
	}

	@Override
	public List<Room> loadAllRooms() {
		return roomDAO.loadAll();
	}

	/**
	 * Inject RoomDAO
	 * 
	 * @param roomDAO
	 */
	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
		System.out.println("*******SET_DAO: " + roomDAO.getClass());
	}

}
