/**
 * 
 */
package de.nak.stundenplandb.action;

import de.nak.stundenplandb.model.Elective;

/**
 * @author Arne Roever
 *
 */
public class ElectiveAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5802592208250231904L;
	
	/** The elective. */
	private Elective elective;	
	
	@Override
	public String save() {
		//meetingService.saveElective(elective, numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}
	
	public Elective getElective() {
		return elective;
	}

	public void setElective(Elective elective) {
		this.elective = elective;
	}
	
}
