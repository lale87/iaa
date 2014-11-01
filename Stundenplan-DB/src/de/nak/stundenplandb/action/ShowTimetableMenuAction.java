/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;
import de.nak.stundenplandb.service.LecturerService;
import de.nak.stundenplandb.service.RoomService;
import de.nak.stundenplandb.service.StudentGroupService;

/**
 * Action for showing the timetable menu.
 * 
 * @author Arne Roever
 *
 */
public class ShowTimetableMenuAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -884697338449586946L;
		
	/** The lecturer service. */
	private LecturerService lecturerService;
	
	/** The student group service. */
	private StudentGroupService studentGroupService;
	
	/** The room service. */
	private RoomService roomService;

	@Override
	public String execute(){
		return SUCCESS;
	}

	/**
	 * Gets all rooms in the database.
	 *
	 * @return the room list
	 */
	public List<Room> getRoomList() {
		return roomService.loadAllRoomsSortedBYBuildungAndNumber();
	}

	/**
	 * Gets all student groups in the database
	 *
	 * @return the student group list
	 */
	public List<StudentGroup> getStudentGroupList() {
		return studentGroupService.loadAllStudentGroupsSorted();
	}

	/**
	 * Gets all lecturers in the database.
	 *
	 * @return the lecturer list
	 */
	public List<Lecturer> getLecturerList() {
		return lecturerService.loadAllLecturers();
	}
	
	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

	public void setStudentGroupService(StudentGroupService studentGroupService) {
		this.studentGroupService = studentGroupService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	
	

}
