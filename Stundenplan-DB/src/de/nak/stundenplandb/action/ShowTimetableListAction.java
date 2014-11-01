package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Meeting;

/**
 * Action for printing the timetable.
 * 
 * @author Arne Roever
 */
public class ShowTimetableListAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6966581960183490333L;
	
    /** The selected (lecturer/room/student group) id. */
    private Long selectedId;
    
    /** The selected type. */
    private String selectedType;

	/** The meeting list. */
    private List<Meeting> meetingList;
        
    @Override
    public String execute(){
    	return SUCCESS;
    }
    
    public String getSelectedType() {
		return selectedType;
	}

	public void setSelectedType(String selectedType) {
		this.selectedType = selectedType;
	}

	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}

	public Long getSelectedId() {		
		return selectedId;
	}

	public List<Meeting> getMeetingList() {
		return meetingList;
	}	

}
