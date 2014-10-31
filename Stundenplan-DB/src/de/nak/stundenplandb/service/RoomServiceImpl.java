package de.nak.stundenplandb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.dao.RoomDAO;
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

	/**
	 * Inject RoomDAO
	 * 
	 * @param roomDAO
	 */
	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
		System.out.println("*******SET_DAO: " + roomDAO.getClass());
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

}
