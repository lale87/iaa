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

	/** The room. */
	private Room room;

	/** The room service. */
	private RoomService roomService;

	/**
	 * Saves the current room to the database.
	 *
	 * @return the result string
	 */
	public String save() {
		roomService.saveRoom(room);
		return SUCCESS;
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
	
	public List<ERoomType> getAllRoomTypes(){
		return roomService.getAllRoomTypes();
	}

}
