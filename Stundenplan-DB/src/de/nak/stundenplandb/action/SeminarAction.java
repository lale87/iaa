/**
 * 
 */
package de.nak.stundenplandb.action;

import de.nak.stundenplandb.model.Seminar;

/**
 * @author Arne Roever
 *
 */
public class SeminarAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8572676587114810892L;
	
	/** The current seminar. */
	private Seminar seminar;
	
	@Override
	public String save() {
		//meetingService.saveLecture(meetingName,lecturerId,roomIds, numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}
	public Seminar getSeminar() {
		return seminar;
	}

	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}


}
