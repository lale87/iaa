/**
 * 
 */
package de.nak.stundenplandb.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import de.nak.stundenplandb.model.Seminar;
import de.nak.stundenplandb.service.SeminarService;

/**
 * Action for a single Seminar
 * 
 * @author Arne Roever
 *
 */
public class SeminarAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8572676587114810892L;
	
	/** The currently selected seminar id. */
	private Long seminarId;
	
	/** The current seminar. */
	private Seminar seminar;
	
	/** The seminar service. */
	private SeminarService seminarService;
	
	@Override
	/**
	 * Saves the seminar to the database or
	 * updates the seminar in the database.
	 * 
	 * @result the result string
	 */
	public String save() {
		seminarService.saveOrUpdateSeminar(seminar.getId(), meetingName,lecturerId,roomIds, numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}
	
	/**
	 * Displays the selected seminar in the seminar form
	 *
	 * @return the string
	 */
	@SkipValidation
	public String load(){
		seminar = seminarService.loadSeminar(seminarId);
		return SUCCESS;
	}
	
	/**
	 * Deletes the seminar from the database
	 *
	 * @return the result string
	 */
	@SkipValidation
	public String delete(){
		if (seminarId != null) {
			seminarService.deleteSeminar(seminarId);	
			return SUCCESS;
		}
		return ERROR;
	}
	
	public Seminar getSeminar() {
		return seminar;
	}

	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}
	
	public void setSeminarService(SeminarService seminarService) {
		this.seminarService = seminarService;
	}
	public Long getSeminarId() {
		return seminarId;
	}
	public void setSeminarId(Long seminarId) {
		this.seminarId = seminarId;
	}


}
