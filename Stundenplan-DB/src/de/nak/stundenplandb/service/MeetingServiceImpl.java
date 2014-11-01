package de.nak.stundenplandb.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import de.nak.stundenplandb.dao.ElectiveDAO;
import de.nak.stundenplandb.dao.ExamDAO;
import de.nak.stundenplandb.dao.LectureDAO;
import de.nak.stundenplandb.dao.LecturerDAO;
import de.nak.stundenplandb.dao.RoomDAO;
import de.nak.stundenplandb.dao.SeminarDAO;
import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation for the MeetingService
 * 
 * @author Lars Lembke
 *
 */
public class MeetingServiceImpl implements MeetingService {

	private ExamDAO examDAO;
	private SeminarDAO seminarDAO;
	private ElectiveDAO electiveDAO;
	private LectureDAO lectureDAO;
	private LecturerDAO lecturerDAO;
	private RoomDAO roomDAO;
	
	@Override
	public boolean isPossible(Meeting meeting) {

		// TODO hier wird es kompliziert! Wechselzeiten werden schwierig zu
		// ermitteln
		// List conflicts
		// List meetings := Get * from Meeting between start AND end
		// if meetings > 0
		// if meetings contain lecturer -> conflicts.add(lecturer)
		// if meetings contain
		return true;
	}

	@Override
	public List<Meeting> loadMeetingsForStudentGroup(StudentGroup studentGroup,
			Date start, Date end) {
		List<Meeting> meetingsForStudentGroup = new ArrayList<Meeting>();
		meetingsForStudentGroup.addAll(examDAO.loadExamForStudentGroup(
				studentGroup, start, end));
		meetingsForStudentGroup.addAll(lectureDAO.loadLecturesForStudentGroup(
				studentGroup, start, end));
		meetingsForStudentGroup.addAll(electiveDAO.loadElectivesForStudentGroup(
				studentGroup.getCohort(), start, end));
		initializeMeetings(meetingsForStudentGroup);
		return meetingsForStudentGroup;
	}

	@Override
	public List<Meeting> loadMeetingsForLecturer(Lecturer lecturer, Date start,
			Date end) {
		List<Meeting> meetingsForLecturer = new ArrayList<Meeting>();
		meetingsForLecturer.addAll(examDAO.loadExamForLecturer(
				lecturer, start, end));
		meetingsForLecturer.addAll(lectureDAO.loadLecturesForLecturer(
				lecturer, start, end));
		meetingsForLecturer.addAll(electiveDAO.loadElectivesForLecturer(
				lecturer, start, end));
		meetingsForLecturer.addAll(seminarDAO.loadSeminarsForLecturer(
				lecturer, start, end));
		initializeMeetings(meetingsForLecturer);
		return meetingsForLecturer;

	}

	@Override
	public List<Meeting> loadMeetingsForRoom(Room room, Date start, Date end) {
		List<Meeting> meetingsForRoom = new ArrayList<Meeting>();
		meetingsForRoom.addAll(examDAO.loadExamsForRoom(room, start, end));
		meetingsForRoom.addAll(lectureDAO.loadLecturesForRoom(room, start, end));
		meetingsForRoom.addAll(electiveDAO.loadElectivesForRoom(room, start, end));
		meetingsForRoom.addAll(seminarDAO.loadSeminarsForRoom(room, start, end));
		initializeMeetings(meetingsForRoom);
		return meetingsForRoom;
	}

	@Override
	public List<Meeting> loadAllMeetings() {
		List<Meeting> allMeetings = new ArrayList<Meeting>();
		allMeetings.addAll(examDAO.loadAll());
		allMeetings.addAll(lectureDAO.loadAll());
		allMeetings.addAll(electiveDAO.loadAll());
		allMeetings.addAll(seminarDAO.loadAll());
		initializeMeetings(allMeetings);
		return allMeetings;
	}
	
	private void initializeMeetings(List<Meeting> meetings) {
		for (Meeting meeting : meetings) {
			initializeMeeting(meeting);
		}
	}
	
	private void initializeMeeting(Meeting meeting) {
		Hibernate.initialize(meeting.getLecturer());
		Hibernate.initialize(meeting.getRooms());
		Hibernate.initialize(meeting.getAppointments());
	}

	/**
	 * creates a Set of Appointments starting with the first date. For each
	 * repitition of an appointment starts seven days later than the appointment
	 * before
	 * 
	 * @param numberOfAppointments
	 *            <Integer>
	 * @param begin
	 *            <Date>
	 * @param end
	 *            <Date>
	 * @return a Set of Appointments
	 */
	protected Set<Appointment> createAppointments(Integer numberOfAppointments,
			Date begin, Date end) {
		Set<Appointment> appointmentSet = new HashSet<Appointment>();
		//
		for (int i = 0; i < numberOfAppointments; i++) {
			Calendar c = Calendar.getInstance();
			Appointment appointment = new Appointment();
			// ADD 7 day to the begin-date to match the next appointment
			c.setTime(begin);
			c.add(Calendar.DATE, i * 7);
			appointment.setStart(c.getTime());
			// ADD 7 day to the end-date to match the next appointment
			c.setTime(end);
			c.add(Calendar.DATE, i * 7);
			appointment.setEnd(c.getTime());
			// ADD the appointment to the set
			appointmentSet.add(appointment);
		}

		return appointmentSet;
	}
	
	@Override
	public void fillMeeting(Meeting meeting, String meetingName,
			Long lecturerId, List<Long> roomIds, int numberOfAppointments,
			Date startDate, Date endDate) {
		// get referenced entities
		Lecturer lecturer = lecturerDAO.load(lecturerId);
		Set<Room> rooms = new HashSet<Room>();
		for (Long id : roomIds) {
			Room room = roomDAO.load(id);
			rooms.add(room);
		}
		Set<Appointment> appointments =
				this.createAppointments(numberOfAppointments, startDate, endDate);
		
		meeting.setName(meetingName);
		meeting.setLecturer(lecturer);
		meeting.setRooms(rooms);
		for (Appointment appointment : appointments) {			
			meeting.addAppointmentToMeeting(appointment);
		}
		// no return due to a given reference!
	}

	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	public void setSeminarDAO(SeminarDAO seminarDAO) {
		this.seminarDAO = seminarDAO;
	}

	public void setElectiveDAO(ElectiveDAO electiveDAO) {
		this.electiveDAO = electiveDAO;
	}

	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}

	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
		System.out.println("****lecturerDAO="+this.lecturerDAO);
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
}
