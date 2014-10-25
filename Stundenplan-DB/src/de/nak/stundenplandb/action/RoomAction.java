package de.nak.stundenplandb.action;

import com.opensymphony.xwork2.ActionSupport;
import de.nak.stundenplandb.model.Room;

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
	
	/**
	 * Saves the current room to the database
	 *
	 * @return the result string
	 */
	private String save(){
		return SUCCESS;
	}

}
