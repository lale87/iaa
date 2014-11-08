package de.nak.stundenplandb.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import de.nak.stundenplandb.dao.AppointmentDAO;
import de.nak.stundenplandb.dao.LecturerDAO;
import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.EAcademicTitle;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Lecturer;

/**
 * Implementation for the LecturerService
 * 
 * @author Lars Lembke
 *
 */
public class LecturerServiceImpl implements LecturerService {
	/**
	 * Injected DAO
	 */
	private LecturerDAO lecturerDAO;
	/**
	 * Injected DAO
	 */
	private AppointmentDAO appointmentDAO;

	@Override
	public void saveLecturer(Lecturer lecturer) {
		lecturerDAO.save(lecturer);
	}

	@Override
	public List<Lecturer> loadAllLecturers() {
		return lecturerDAO.loadAll();
	}

	@Override
	public List<EAcademicTitle> getAllAcademicTitles() {
		return Arrays.asList(EAcademicTitle.values());
	}

	@Override
	public List<Appointment> getAppointmentsForLecturer(Long lecturerId) {
		return getAppointmentsForLecturerInTimeperiod(lecturerId, new Date(
				Long.MIN_VALUE), new Date(Long.MAX_VALUE));
	}

	@Override
	public List<Appointment> getAppointmentsForLecturerInWeek(Long lecturerId, 
			int week, int year) {
		Date start, end;
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.YEAR, year);
		start = cal.getTime();
		// check if the following week is in the next year
		cal.clear();
		cal.set(year, 11, 31);
		if (week == cal.get(Calendar.WEEK_OF_YEAR)) {
			week = 0;
			year++;
		}
		cal.clear();
		cal.set(Calendar.WEEK_OF_YEAR, week + 1);
		cal.set(Calendar.YEAR, year);
		end = cal.getTime();
		return getAppointmentsForLecturerInTimeperiod(lecturerId, start, end);
	}
	
	@Override
	public List<Appointment> getAppointmentsForLecturerInTimeperiod(
			Long lecturerId, Date start, Date end) {
		Lecturer lecturer = lecturerDAO.load(lecturerId);
		List<Appointment> appointments = appointmentDAO
				.loadAppointmentsForLecturerInTimeperiod(lecturer, start, end);
		// initialize appointments
		for (Appointment appointment : appointments) {
			Hibernate.initialize(appointment.getMeeting());
			Hibernate.initialize(appointment.getMeeting().getRooms());
			Hibernate.initialize(appointment.getMeeting().getLecturer());
			// initialize lectures
			if (EMeetingType.LECTURE.equals(appointment.getMeeting()
					.getMeetingType())) {
				Hibernate.initialize(((Lecture) appointment.getMeeting())
						.getStudentGroup());
			}
			// initialize exams
			if (EMeetingType.EXAM.equals(appointment.getMeeting()
					.getMeetingType())) {
				Hibernate.initialize(((Exam) appointment.getMeeting())
						.getStudentGroups());
			}
			// initialize electives
			if (EMeetingType.ELECTIVE.equals(appointment.getMeeting()
					.getMeetingType())) {
				Hibernate.initialize(((Elective) appointment.getMeeting())
						.getCohort());
			}
		}
		return appointments;
	}

	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}

	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	public boolean isBusy(Long lecturerId, Date start, Date end) {
		Lecturer lecturer = lecturerDAO.load(lecturerId);
		Integer minBreak = lecturer.getMinBreak();
		// Calculate new time with minBreak
		Calendar cal = Calendar.getInstance();

		Date startDateWithBreakTime;
		cal.setTime(start);
		cal.add(Calendar.MINUTE, -minBreak);
		startDateWithBreakTime = cal.getTime();

		Date endDateWithBreakTime;
		cal.setTime(end);
		cal.add(Calendar.MINUTE, minBreak);
		endDateWithBreakTime = cal.getTime();

		// When there is no Appointment for this Lecturer within the given period,
		// he is NOT busy
		return !appointmentDAO.loadAppointmentsForLecturerInTimeperiod(
				lecturer, startDateWithBreakTime, endDateWithBreakTime)
				.isEmpty();
		// Ask the DAO
		// return lecturerDAO.isBusy(lecturerId, startDateWithBreakTime,
		// endDateWithBreakTime);
	}

}
