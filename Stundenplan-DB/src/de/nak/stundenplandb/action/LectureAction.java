/**
 * 
 */
package de.nak.stundenplandb.action;

import de.nak.stundenplandb.model.Lecture;

/**
 * The Class LectureAction.
 *
 * @author Arne Roever
 */
public class LectureAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5470788664512099858L;
	
	/** The selected studentgroup id. */
	private Long studentGroupId; 
	
	/** The lecture. */
	private Lecture lecture;
	
	public String save(){
		//meetingService.saveLecture(meetingName,lecturerId,roomIds,studentGroupId,  numberOfAppointments, startDate, endDate);
		
		return SUCCESS;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public Long getStudentGroupId() {
		return studentGroupId;
	}

	public void setStudentGroupId(Long studentGroupId) {
		this.studentGroupId = studentGroupId;
	}
}
