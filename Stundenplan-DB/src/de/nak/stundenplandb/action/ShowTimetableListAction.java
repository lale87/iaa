package de.nak.stundenplandb.action;

import java.util.Calendar;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;
import de.nak.stundenplandb.service.LecturerService;
import de.nak.stundenplandb.service.RoomService;
import de.nak.stundenplandb.service.StudentGroupService;

/**
 * Action for displaying the timetable.
 * 
 * @author Arne Roever
 */
public class ShowTimetableListAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6966581960183490333L;

	/** The id selected by the user */
	private Long selectedId;

	/** The type selected by the user (room/lecturer/studentgroup) */
	private String selectedType;

	/** The year entered by the user */
	private Integer year;

	/** The calendar week entered by the user */
	private Integer calendarWeek;

	/** The list of meetings to be displayed in the timetable */
	private List<Appointment> appointmentList;

	/** The lecturer service. */
	private LecturerService lecturerService;

	/** The student group service. */
	private StudentGroupService studentGroupService;

	/** The room service. */
	private RoomService roomService;

	/** The calendar used for displaying current year and calendarWeek */
	private Calendar calendar = Calendar.getInstance();

	/**
	 * Sets current year and current calendar week as default values
	 *
	 * @return the room list
	 */
	public String execute() {
		year = calendar.get(Calendar.YEAR);
		calendarWeek = calendar.get(Calendar.WEEK_OF_YEAR);
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

	/**
	 * Displays timetable depending on which type was selected by the user.
	 * 
	 * @param the result string
	 * */
	public String showTimetable() {
		switch (selectedType) {
		case "Dozent":
			appointmentList = lecturerService.getAppointmentsForLecturerInWeek(
					selectedId, calendarWeek, year);
			break;
		case "Raum":
			appointmentList = roomService.getAppointmentsForRoomInWeek(
					selectedId, calendarWeek, year);
			break;
		case "Zenturie":
			appointmentList = studentGroupService
					.getAppointmentsForStudentGroupInWeek(selectedId,
							calendarWeek, year);
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getCalendarWeek() {
		return calendarWeek;
	}

	public void setCalendarWeek(Integer calendarWeek) {
		this.calendarWeek = calendarWeek;
	}

}
