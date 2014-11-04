/**
 * 
 */
package de.nak.stundenplandb.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.service.ElectiveService;

/**
 * Action for a single Elective
 * 
 * @author Arne Roever *
 */
public class ElectiveAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5802592208250231904L;
	
	/** The currently selected elective id. */
	private Long electiveId;
	
	/** The current elective. */
	private Elective elective;	
	
	/** The cohort id selected by the user. */
	private Long cohortId;
	
	/** The elective service. */
	private ElectiveService electiveService;

	/**
	 * Saves the elective to the database
	 *  
	 *  @return the result string.
	 */
	@Override
	public String save() {
		electiveService.saveOrUpdateElective(elective.getId(),meetingName,lecturerId,roomIds,cohortId,  numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}
	
	/**
	 * Deletes the elective from the database
	 *
	 * @return the result string
	 */
	@SkipValidation
	public String delete(){
		if ( electiveId != null) {
			electiveService.deleteElective(electiveId);
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * Displays the elective in the elective form.
	 *
	 * @return the result string
	 */
	@SkipValidation
	public String load(){
		elective = electiveService.loadElective(electiveId);
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

	public Long getElectiveId() {
		return electiveId;
	}

	public void setElectiveId(Long electiveId) {
		this.electiveId = electiveId;
	}
	
}
