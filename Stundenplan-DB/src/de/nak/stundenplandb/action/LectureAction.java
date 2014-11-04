/**
 * 
 */
package de.nak.stundenplandb.action;

import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.service.LectureService;

/**
 * Action for a single Lecture.
 *
 * @author Arne Roever
 */
public class LectureAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5470788664512099858L;
	
	/** The student group id selected by the user */
	private Long studentGroupId; 
	
	/** The currently selected lecture id. */
	private Long lectureId;
	
	/** The current lecture. */
	private Lecture lecture;
	
	/** The lecture service. */
	private LectureService lectureService;

	/**
	 * Saves or updates the lecture to/in the database
	 * 
	 * @return the result string.
	 */
	public String save(){
		lectureService.saveOrUpdateLecture(lecture.getId(), meetingName, lecturerId,
				roomIds, studentGroupId, numberOfAppointments, startDate, endDate);
		
		return SUCCESS;
	}
	
	/**
	 * Deletes the lecture from the database
	 *
	 * @return the result string
	 */
	public String delete(){
		lectureService.deleteLecture(lectureId);
		return SUCCESS;
	}
	
	public String load(){
		lecture = lectureService.loadLecture(lectureId);
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
	
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}

	public Long getLectureId() {
		return lectureId;
	}

	public void setLectureId(Long lectureId) {
		this.lectureId = lectureId;
	}
}
