/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;
import de.nak.stundenplandb.service.LecturerService;
import de.nak.stundenplandb.service.MeetingService;
import de.nak.stundenplandb.service.RoomService;
import de.nak.stundenplandb.service.StudentGroupService;

/**
 * @author Arne Roever
 *
 */
public class ExamAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6938348041955775951L;

	/** The exam. */
	private Exam exam;
	
	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;
	
	/** The number of appointments. */
	private Integer numberOfAppointments;
	
	/** The lecturer service. */
	private LecturerService lecturerService;
	
	/** The room service. */
	private RoomService roomService;
	
	/** The student group service. */
	private StudentGroupService studentGroupService;
	
	/** The meeting service. */
	private MeetingService meetingService;
	
	/**
	 * Gets all lecturers.
	 *
	 * @return the all lecturers
	 */
	public List<Lecturer> getAllLecturers(){
		return lecturerService.loadAllLecturers();
	}
	
	/**
	 * Gets all rooms.
	 *
	 * @return the all rooms
	 */
	public List<Room> getAllRooms(){
		return roomService.loadAllRooms();
	}
	
	/**
	 * Gets all student groups.
	 *
	 * @return the student groups
	 */
	public List<StudentGroup> getAllStudentGroups(){
		return studentGroupService.loadAllStudentGroups();
	}
	
	public String save(){
		//meetingService.saveExam(exam, numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}	
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getNumberOfAppointments() {
		return numberOfAppointments;
	}

	public void setNumberOfAppointments(Integer numberOfAppointments) {
		this.numberOfAppointments = numberOfAppointments;
	}

	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public void setStudentGroupService(StudentGroupService studentGroupService) {
		this.studentGroupService = studentGroupService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
		
	
	
	
}
