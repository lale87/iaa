package de.nak.stundenplandb.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Meeting;

/**
 * Action for a single meeting.
 *
 * @author Arne Roever
 */
public class MeetingAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7376786519031302846L;
	
	/** The current meeting. */
	private Meeting meeting;
	
	/** The meeting id. */
	private Long meetingId;
	
	/**
	 * Saves the current meeting.
	 *
	 * @return the result string
	 */
	public String save(){
		return SUCCESS;
	}
	
	/**
	 * Deletes the currently selected meeting from the database.
	 *
	 * @return the result string
	 */
	public String delete(){
		return SUCCESS;
	}
	
	/**
	 * Displays the selected meeting in the meeting form.
	 *
	 * @return the result string
	 */
	public String load(){
		return SUCCESS;
	}
	
	/**
	 * Cancels the editing.
	 *
	 * @return the string
	 */
	public String cancel(){
		return SUCCESS;
	}
	
	@Override
	public void validate(){
		
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}
	
	
	
}
