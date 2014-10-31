package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.ERoomType;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.service.RoomService;

/**
 * Action for a single Room.
 * 
 * @author Arne Roever
 */
public class RoomAction extends ActionSupport {

	/** Serial version UID. */
	private static final long serialVersionUID = 5195981410155741713L;

	/** The current room. */
	private Room room;

	/** The room service. */
	private RoomService roomService;

	/**
	 * Saves the room to the database.
	 *
	 * @return the result string
	 */
	public String save() {
		roomService.saveRoom(room);
		return SUCCESS;
	}
	
	/**
	 * Gets the all rooms in the database
	 *
	 * @return all rooms
	 */
	public List<Room> getAllRooms(){
		return roomService.loadAllRooms();
	}
	
	
	/**
	 * Gets the all room types in the database
	 *
	 * @return all room types
	 */
	public List<ERoomType> getAllRoomTypes(){
		return roomService.getAllRoomTypes();
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

}
