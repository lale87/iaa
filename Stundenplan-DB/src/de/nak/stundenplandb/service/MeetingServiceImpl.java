package de.nak.stundenplandb.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.nak.stundenplandb.dao.ElectiveDAO;
import de.nak.stundenplandb.dao.ExamDAO;
import de.nak.stundenplandb.dao.LectureDAO;
import de.nak.stundenplandb.dao.SeminarDAO;
import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.Seminar;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation for the MeetingService
 * 
 * @author Lars Lembke
 *
 */
public class MeetingServiceImpl implements MeetingService {
	/**
	 * Injected ExamDAO
	 */
	private ExamDAO examDAO;
	/**
	 * Injected SeminarDAO
	 */
	private SeminarDAO seminarDAO;
	/**
	 * Injected ElectiveDAO
	 */
	private ElectiveDAO electiveDAO;
	/**
	 * Injected LectureDAO
	 */
	private LectureDAO lectureDAO;

	@Override
	public void saveExam(Exam exam, Integer numberOfAppointments, Date begin,
			Date end) {
		exam.setAppointments(createAppointments(numberOfAppointments, begin,
				end));
		examDAO.save(exam);
	}

	@Override
	public void deleteExam(Exam exam) {
		examDAO.delete(exam);
	}

	@Override
	public void saveLecture(Lecture lecture, Integer numberOfAppointments,
			Date begin, Date end) {
		lecture.setAppointments(createAppointments(numberOfAppointments, begin,
				end));
		lectureDAO.save(lecture);
	}

	@Override
	public void deleteLecture(Lecture lecture) {
		lectureDAO.delete(lecture);
	}

	@Override
	public void saveSeminar(Seminar seminar, Integer numberOfAppointments,
			Date begin, Date end) {
		seminar.setAppointments(createAppointments(numberOfAppointments, begin,
				end));
		seminarDAO.save(seminar);
	}

	@Override
	public void deleteSeminar(Seminar seminar) {
		seminarDAO.delete(seminar);
	}

	@Override
	public void saveElective(Elective elective, Integer numberOfAppointments,
			Date begin, Date end) {
		elective.setAppointments(createAppointments(numberOfAppointments,
				begin, end));
		electiveDAO.save(elective);
	}

	@Override
	public void deleteElective(Elective elective) {
		electiveDAO.delete(elective);
	}

	/**
	 * Injects the ExamDAO
	 * 
	 * @param examDAO
	 */
	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	/**
	 * Injects the SeminarDAO
	 * 
	 * @param seminarDAO
	 */
	public void setSeminarDAO(SeminarDAO seminarDAO) {
		this.seminarDAO = seminarDAO;
	}

	/**
	 * Injects the LectureDAO
	 * 
	 * @param lectureDAO
	 */
	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}

	/**
	 * Injects the ElectiveDAO
	 * 
	 * @param electiveDAO
	 */
	public void setElectiveDAO(ElectiveDAO electiveDAO) {
		this.electiveDAO = electiveDAO;
	}

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
		meetingsForStudentGroup.add((Meeting) examDAO.loadExamForStudentGroup(
				studentGroup, start, end));
		meetingsForStudentGroup.add((Meeting) lectureDAO
				.loadLecturesForStudentGroup(studentGroup, start, end));
		meetingsForStudentGroup.add((Meeting) electiveDAO
				.loadElectivesForStudentGroup(studentGroup.getCohort(), start,
						end));
		return meetingsForStudentGroup;
	}

	@Override
	public List<Meeting> loadMeetingsForLecturer(Lecturer lecturer, Date start,
			Date end) {
		List<Meeting> meetingsForLecturer = new ArrayList<Meeting>();
		meetingsForLecturer.add((Meeting) examDAO.loadExamForLecturer(lecturer,
				start, end));
		meetingsForLecturer.add((Meeting) lectureDAO.loadLecturesForLecturer(
				lecturer, start, end));
		meetingsForLecturer.add((Meeting) electiveDAO.loadElectivesForLecturer(
				lecturer, start, end));
		meetingsForLecturer.add((Meeting) seminarDAO.loadSeminarsForLecturer(
				lecturer, start, end));
		return meetingsForLecturer;

	}

	@Override
	public List<Meeting> loadMeetingsForRoom(Room room, Date start, Date end) {
		List<Meeting> meetingsForRoom = new ArrayList<Meeting>();
		meetingsForRoom.add((Meeting) examDAO
				.loadExamsForRoom(room, start, end));
		meetingsForRoom.add((Meeting) lectureDAO.loadLecturesForRoom(room,
				start, end));
		meetingsForRoom.add((Meeting) electiveDAO.loadElectivesForRoom(room,
				start, end));
		meetingsForRoom.add((Meeting) seminarDAO.loadSeminarsForRoom(room,
				start, end));
		return meetingsForRoom;
	}

	@Override
	public List<Meeting> loadAllMeetings() {
		List<Meeting> allMeetings = new ArrayList<Meeting>();
		allMeetings.add((Meeting) examDAO.loadAll());
		allMeetings.add((Meeting) lectureDAO.loadAll());
		allMeetings.add((Meeting) electiveDAO.loadAll());
		allMeetings.add((Meeting) seminarDAO.loadAll());
		return allMeetings;
	}

	/**
	 * creates a Set of Appointments starting with the first date. For each
	 * repitition of an appointment starts seven days later than the appointment
	 * before
	 * 
	 * @param numberOfAppointments<Integer>
	 * @param begin<Date>
	 * @param end<Date>
	 * @return a Set of Appointments
	 */
	private Set<Appointment> createAppointments(Integer numberOfAppointments,
			Date begin, Date end) {
		Set<Appointment> appointmentSet = new HashSet<Appointment>();
		// TODO Addieren von Tagen noch ordentlich implementieren
		for (int i = 0; i < numberOfAppointments; i++) {
			Calendar c = Calendar.getInstance();
			Appointment appointment = new Appointment();
			c.setTime(begin);
			c.add(Calendar.DATE, i * 7);
			appointment.setStart(c.getTime());

			c.setTime(end);
			c.add(Calendar.DATE, i * 7);
			appointment.setEnd(c.getTime());
			appointmentSet.add(appointment);
		}

		return appointmentSet;
	}

}
