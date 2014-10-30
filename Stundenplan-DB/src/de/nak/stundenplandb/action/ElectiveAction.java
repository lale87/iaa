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
	
	/** The current elective. */
	private Elective elective;	
	
	private Long cohortId;

	@Override
	public String save() {
		//meetingService.saveLecture(meetingName,lecturerId,roomIds,cohortId,  numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}
	
	public Elective getElective() {
		return elective;
	}

	public void setElective(Elective elective) {
		this.elective = elective;
	}
	
	public Long getCohortId() {
		return cohortId;
	}

	public void setCohortId(Long cohortId) {
		this.cohortId = cohortId;
	}
	
}
