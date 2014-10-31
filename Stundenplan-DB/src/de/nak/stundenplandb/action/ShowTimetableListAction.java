/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Action for showing the timetable list.
 * 
 * @author Arne Roever
 *
 */
public class ShowTimetableListAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -884697338449586946L;
	
	/** The room list. */
	private List<Room> roomList;
	
	/** The student group list. */
	private List<StudentGroup> studentGroupList;
	
	/** The lecturer list. */
	private List<Lecturer> lecturerList;
	
	@Override
	public String execute(){
		return SUCCESS;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public List<StudentGroup> getStudentGroupList() {
		return studentGroupList;
	}

	public List<Lecturer> getLecturerList() {
		return lecturerList;
	}
	

}
