/**
 * 
 */
package de.nak.stundenplandb.action;

import de.nak.stundenplandb.model.Seminar;
import de.nak.stundenplandb.service.SeminarService;

/**
 * @author Arne Roever
 *
 */
public class SeminarAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8572676587114810892L;
	
	/** The current seminar. */
	private Seminar seminar;
	
	/** The seminar service. */
	private SeminarService seminarService;
	
	@Override
	public String save() {
		seminarService.saveOrUpdateSeminar(seminar.getId(), meetingName,lecturerId,roomIds, numberOfAppointments, startDate, endDate);
		return SUCCESS;
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


}
