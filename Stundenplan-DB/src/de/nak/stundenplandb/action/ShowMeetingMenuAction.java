/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.service.MeetingService;

/**
 * Action for showing the meeting list.
 * 
 * @author Arne Roever
 */
public class ShowMeetingMenuAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7361090700772154126L;
	
	private MeetingService meetingService;
	
	public List<Meeting> getMeetingList() {
		return meetingService.loadAllMeetings(); 		
	}	
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	

}
