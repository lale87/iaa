/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.service.MeetingService;

/**
 * Action for showing the meeting menu 
 * and a list of all existing meetings.
 * 
 * @author Arne Roever
 */
public class ShowMeetingMenuAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7361090700772154126L;
	
	/** The meeting id selected by the user */
	private Long meetingId;
	
	/** The meeting service. */
	private MeetingService meetingService;
	
	/**
	 * Gets a list of all meetings in the database
	 *
	 * @return the meeting list
	 */
	public List<Meeting> getMeetingList() {
		return meetingService.loadAllMeetings();		
	}
	
	/**
	 * Gets a list of all lectures
	 *
	 * @return the lecture list
	 */
	public List<Meeting> getLectureList(){
		// muss noch zu LectureService bzw. Lecture geändert werden
		return meetingService.loadAllMeetings();
	}
	
	/**
	 * Gets a list of all exams
	 *
	 * @return the exam list
	 */
	public List<Meeting> getExamList(){
		// muss noch zu LectureService bzw. Lecture geändert werden
		return meetingService.loadAllMeetings();
	}
	
	public List<Meeting> getElectiveList(){
		// muss noch zu LectureService bzw. Lecture geändert werden
		return meetingService.loadAllMeetings();
	}
	
	/**
	 * Gets a list of all seminars
	 *
	 * @return the seminar list
	 */
	public List<Meeting> getSeminarList(){
		// muss noch zu LectureService bzw. Lecture geändert werden
		return meetingService.loadAllMeetings();
	}
	
	@Override
	public String execute(){
		return SUCCESS;
	}

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
}
