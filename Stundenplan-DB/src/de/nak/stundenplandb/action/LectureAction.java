/**
 * 
 */
package de.nak.stundenplandb.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private String startDate;
	
	/** The end date. */
	private String endDate;
	
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
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss");
		Date formatStartDate;
		Date formatEndDate;
		try {
			formatStartDate = formatter.parse(startDate);
			formatEndDate = formatter.parse(endDate);
			meetingService.saveLecture(lecture, numberOfAppointments, formatStartDate, formatEndDate);
			//meetingService.saveLecture(lecturerId,roomIds,studentGroupId,lectureName,startDate,endDate, numberOfAppointments);
		} catch (ParseException e) {			
			e.printStackTrace();
		}		
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
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

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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
