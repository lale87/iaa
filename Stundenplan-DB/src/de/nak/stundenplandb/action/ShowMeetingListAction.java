/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Meeting;

/**
 * Action for showing the meeting list.
 * 
 * @author Arne Roever
 */
public class ShowMeetingListAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7361090700772154126L;
	
	/** The meeting list. */
	private List<Meeting> meetingList;
	
	public List<Meeting> getMeetingList() {
		return meetingList;
	}	
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	

}
