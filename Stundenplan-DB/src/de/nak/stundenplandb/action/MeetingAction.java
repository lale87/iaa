package de.nak.stundenplandb.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Cohort;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;
import de.nak.stundenplandb.service.LecturerService;
import de.nak.stundenplandb.service.MeetingService;
import de.nak.stundenplandb.service.RoomService;
import de.nak.stundenplandb.service.StudentGroupService;

/**
 * Action for a single meeting.
 *
 * @author Arne Roever
 */
public abstract class MeetingAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7376786519031302846L;
	
	/** The start date. */
	protected Date startDate;
	
	/** The end date. */
	protected Date endDate;
	
	/** The number of appointments. */
	protected Integer numberOfAppointments;
	
	/** The lecturer service. */
	protected LecturerService lecturerService;
	
	/** The room service. */
	protected RoomService roomService;
	
	/** The student group service. */
	protected StudentGroupService studentGroupService;
	
	/** The meeting service. */
	protected MeetingService meetingService;
	
	public abstract String save();
	
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
		return roomService.loadAllRoomsSortedBYBuildungAndNumber();
	}
	
	/**
	 * Gets all student groups.
	 *
	 * @return the student groups
	 */
	public List<StudentGroup> getAllStudentGroups(){
		return studentGroupService.loadAllStudentGroupsSorted();
	}
	
	/**
	 * Gets all cohorts.
	 *
	 * @return all cohorts
	 */
	public List<Cohort> getAllCohorts(){		
		return studentGroupService.loadAllCohortsSortedByYearOfAdmission();
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

	public LecturerService getLecturerService() {
		return lecturerService;
	}

	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public StudentGroupService getStudentGroupService() {
		return studentGroupService;
	}

	public void setStudentGroupService(StudentGroupService studentGroupService) {
		this.studentGroupService = studentGroupService;
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
}
