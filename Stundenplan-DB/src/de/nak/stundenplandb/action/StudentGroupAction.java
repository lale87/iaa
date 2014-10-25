/**
 * 
 */
package de.nak.stundenplandb.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.StudentGroup;

/**
 * Action for a single StudentGroup.
 *
 * @author Arne Roever
 */
public class StudentGroupAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8655068170554081339L;
	
	/** The current student group. */
	private StudentGroup studentGroup;
	
	/**
	 * Save student group to database.
	 *
	 * @return the result string
	 */
	public String save(){
		return SUCCESS;
	}

}
