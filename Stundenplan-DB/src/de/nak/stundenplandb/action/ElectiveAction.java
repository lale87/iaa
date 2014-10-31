/**
 * 
 */
package de.nak.stundenplandb.action;

import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.service.ElectiveService;

/**
 * @author Arne Roever
 *
 */
public class ElectiveAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5802592208250231904L;
	
	/** The current elective. */
	private Elective elective;	
	
	/** The selected cohort id. */
	private Long cohortId;
	
	/** The elective service. */
	private ElectiveService electiveService;

	@Override
	public String save() {
		electiveService.saveOrUpdateElective(elective.getId(),meetingName,lecturerId,roomIds,cohortId,  numberOfAppointments, startDate, endDate);
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

	public void setElectiveService(ElectiveService electiveService) {
		this.electiveService = electiveService;
	}
	
}
