/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;
import de.nak.stundenplandb.service.LecturerService;
import de.nak.stundenplandb.service.MeetingService;
import de.nak.stundenplandb.service.RoomService;
import de.nak.stundenplandb.service.StudentGroupService;

/**
 * The Class LectureAction.
 *
 * @author Arne Roever
 */
public class LectureAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5470788664512099858L;

	/** The lecturer service. */
	private LecturerService lecturerService;
	
	/** The room service. */
	private RoomService roomService;
	
	/** The student group service. */
	private StudentGroupService studentGroupService;
	
	/** The lecturer id. */
	private Long lecturerId;
	
	/** The room ids. */
	private List<Long> roomIds;
	
	/** The student group. */
	private Long studentGroupId;	

	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;
	
	/** The number of appointments. */
	private Integer numberOfAppointments;
	
	/** The meeting service. */
	private MeetingService meetingService;
	
	/** The lecture. */
	private Lecture lecture;	

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
		meetingService.saveLecture(lecture, numberOfAppointments, startDate, endDate);
		//meetingService.saveLecture(lecturerId,roomIds,studentGroupId,lectureName,startDate,endDate, numberOfAppointments);
		return SUCCESS;
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
	public Long getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}

	public List<Long> getRoomIds() {
		return roomIds;
	}

	public void setRoomIds(List<Long> roomIds) {
		this.roomIds = roomIds;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getNumberOfAppointments() {
		return numberOfAppointments;
	}

	public void setNumberOfAppointments(Integer numberOfAppointments) {
		this.numberOfAppointments = numberOfAppointments;
	}

	public Long getStudentGroupId() {
		return studentGroupId;
	}

	public void setStudentGroupId(Long studentGroupId) {
		this.studentGroupId = studentGroupId;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	
	
	
	
}
