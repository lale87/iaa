package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Meeting;

/**
 * Action for printing the timetable.
 * 
 * @author Arne Roever
 */
public class PrintTimetableAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6966581960183490333L;
	
    /** The selected (lecturer/room/student group) id. */
    private Long selectedId;
    
    /** The meeting list. */
    private List<Meeting> meetingList;
        
    @Override
    public String execute(){
    	return SUCCESS;
    }

	public Long getSelectedId() {		
		return selectedId;
	}

	public List<Meeting> getMeetingList() {
		return meetingList;
	}	

}
