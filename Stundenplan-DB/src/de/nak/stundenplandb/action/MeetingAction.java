package de.nak.stundenplandb.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Cohort;
import de.nak.stundenplandb.model.ECollisionType;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;
import de.nak.stundenplandb.service.LecturerService;
import de.nak.stundenplandb.service.MeetingService;
import de.nak.stundenplandb.service.RoomService;
import de.nak.stundenplandb.service.StudentGroupService;

/**
 * Abstract Action for a meeting. * 
 *
 * @author Arne Roever
 */
public abstract class MeetingAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7376786519031302846L;	
	
	/**  The lecturer id selected by the user. */
	protected Long lecturerId;
	
	/**  The room ids selected by the user. */
	protected List<Long> roomIds;

	/**  The start date entered by the user. */
	protected Date startDate;
	
	/** The end date entered by the user. */
	protected Date endDate;
	
	/**  The number of appointments entered by the user. */
	protected Integer numberOfAppointments;
	
	/**  The meeting name entered by the user. */
	protected String meetingName;

	/** The lecturer service. */
	protected LecturerService lecturerService;
	
	/** The room service. */
	protected RoomService roomService;
	
	/** The student group service. */
	protected StudentGroupService studentGroupService;
	
	/** The meeting service. */
	protected MeetingService meetingService;
	
	/** Shows whether user has tried to save a meeting that collides with others.
	 	The user can decide to save anyway or go back and change the attributes */
	protected boolean isCollided = false;
	
	/** The list of all collisions detected when trying to save. */
	protected List<ECollisionType> collisionList;
	
	/**
	 * Displays available rooms.
	 * Only used for checking for invalid dates because
	 * getAllRooms() is used 
	 *
	 * @return the result string
	 */
	@SkipValidation
	public String showAvailableRooms(){
		if (startDate == null) {
			addFieldError("startDate", getText("msg.validator.required"));
		}
		if (endDate == null) {
			addFieldError("endDate", getText("msg.validator.required"));
		}
		if (startDate != null && endDate != null){
			if (startDate.after(endDate)){
				addFieldError("startDate", getText("msg.validator.inconsistentDates"));
			}
		}		
		return SUCCESS;
	}	
	
	/**
	 * Abstract save method that saves the meeting. 	 
	 * 
	 * @return the result string
	 */
	public abstract String save();
	
	/**
	 * Abstract method that checks for collision before 
	 * saving the meeting.	 
	 *
	 * @return the result string
	 */
	public abstract String checkAndSave();
	
	/**
	 * If collisions are found this method displays
	 * the collision reasons in the meeting forms.
	 *
	 * @param list of collisiontypes
	 */
	public void showCollisionErrors(List<ECollisionType> collisionList){
		
		addActionError(getText("msg.error.collision"));		
		if(collisionList.contains(ECollisionType.ROOM_OCCUPIED)){
			addActionError(getText("msg.error.roomOccupied"));
		}
		if(collisionList.contains(ECollisionType.LECTURER_BUSY)){
			addActionError(getText("msg.error.lecturerBusy"));
		}
		if(collisionList.contains(ECollisionType.STUDENTGROUP_BUSY)){
			addActionError(getText("msg.error.studentGroupBusy"));	
		}
		if (collisionList.contains(ECollisionType.COHORT_BUSY)) {
			addActionError(getText("msg.error.studentGroupBusy"));	
		}			
	}
	
	/**
	 * Cancels collision mode, so meetings are again checked for collisions
	 * before being saved to the database.
	 *
	 * @return the result string
	 */
	public String cancelCollision(){
		isCollided = false;
		return SUCCESS;
	}
	
	/**
	 * Gets all lecturers in the database
	 *
	 * @return all lecturers
	 */
	public List<Lecturer> getAllLecturers(){
		return lecturerService.loadAllLecturers();
	}
	
	/**
	 * Gets all rooms in the database
	 *
	 * @return all rooms
	 */
	public List<Room> getAllRooms(){
		//if(startDate == null || endDate == null){
			return roomService.loadAllRoomsSortedBYBuildungAndNumber();
//		}
//		return roomService.findFreeRoomsForTimeperiod(startDate, endDate);
	}
	
	/**
	 * Gets all student groups in the database
	 *
	 * @return student groups
	 */
	public List<StudentGroup> getAllStudentGroups(){
		return studentGroupService.loadAllStudentGroupsSorted();
	}
	
	/**
	 * Gets all cohorts in the database
	 *
	 * @return all cohorts
	 */
	public List<Cohort> getAllCohorts(){		
		return studentGroupService.loadAllCohortsSortedByYearOfAdmission();
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
	
	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
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

	public boolean isCollided() {
		return isCollided;
	}

	public void setCollided(boolean isCollided) {
		this.isCollided = isCollided;
	}

	public List<ECollisionType> getCollisionList() {
		return collisionList;
	}

	public void setCollisionList(List<ECollisionType> collisionList) {
		this.collisionList = collisionList;
	}
}
