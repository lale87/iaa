package de.nak.stundenplandb.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Lecturer;



/**
 * The Class LecturerAction.
 * 
 * @author Arne Roever
 */
public class LecturerAction extends ActionSupport {

	/** Serial version UID.	 */
	private static final long serialVersionUID = 4082240062555980968L;
	
	
	/** The current lecturer. */
	private Lecturer lecturer;	
	
	/**
	 * Save the lecturer to the database.
	 *
	 * @return the result string
	 */
	public String save(){
		return SUCCESS;
	}

}
