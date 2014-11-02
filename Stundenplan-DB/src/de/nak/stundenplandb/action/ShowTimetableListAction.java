package de.nak.stundenplandb.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.service.MeetingService;

/**
 * Action for printing the timetable.
 * 
 * @author Arne Roever
 */
public class ShowTimetableListAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6966581960183490333L;
	
    /** The id selected by the user */
    private Long selectedId;
    
    /** The type selected by the user */
    private String selectedType;

	/** The list of meetings to be displayed in the timetable */
    private List<Meeting> meetingList;
    
    /** The meeting service. */
    private MeetingService meetingService;

	@Override
    public String execute(){
    	switch (selectedType) {
		case "Dozent":
			this.meetingList = meetingService.loadMeetingsForLecturer(selectedId, new Date(), DateUtils.addDays(new Date(), 30));			
			break;
		case "Raum"	:
			this.meetingList = meetingService.loadMeetingsForRoom(selectedId,new Date(), DateUtils.addDays(new Date(), 30));
			break;
		case "Zenturie":
			this.meetingList = meetingService.loadMeetingsForStudentGroup(selectedId, new Date(), DateUtils.addDays(new Date(), 30));
			break;		
		}    	
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

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}	

}
