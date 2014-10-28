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
	
	/** The lecture. */
	private Lecture lecture;
	
	public String save(){
		getMeetingService().saveLecture(lecture, getNumberOfAppointments(), getStartDate(), getEndDate());
		//meetingService.saveLecture(lecturerId,roomIds,studentGroupId,lectureName,startDate,endDate, numberOfAppointments);
		return SUCCESS;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}	
}
