package de.nak.stundenplandb.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.service.LecturerService;
import de.nak.stundenplandb.service.MeetingService;
import de.nak.stundenplandb.service.RoomService;
import de.nak.stundenplandb.service.StudentGroupService;

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
    private List<Appointment> appointmentList;
    
    /** The lecturer service. */
    private LecturerService lecturerService;
    
    /** The student group service. */
    private StudentGroupService studentGroupService;
    
    /** The room service. */
    private RoomService roomService;

	@Override
    public String execute(){
    	switch (selectedType) {
		case "Dozent":
			break;
		case "Raum"	:
			appointmentList = roomService.getAppointmentsForRoom(selectedId);
			break;
		case "Zenturie":
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

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

	public void setStudentGroupService(StudentGroupService studentGroupService) {
		this.studentGroupService = studentGroupService;
	}	

}
