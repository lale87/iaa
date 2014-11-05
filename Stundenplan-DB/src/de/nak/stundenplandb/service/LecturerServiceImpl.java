package de.nak.stundenplandb.service;

import java.util.Arrays;
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
		return getAppointmentsForLecturerInTimeperiod(lecturerId,
				new Date(Long.MIN_VALUE), new Date(Long.MAX_VALUE));
	}
	
	@Override
	public List<Appointment> getAppointmentsForLecturerInTimeperiod(Long lecturerId,
			Date start, Date end) {
		// TODO FK: Fehlerbehandlung?
		Lecturer lecturer = lecturerDAO.load(lecturerId);
		List<Appointment> appointments = appointmentDAO
				.loadAppointmentsForLecturerInTimeperiod(lecturer, start, end);
		// initialize appointments
		for (Appointment appointment : appointments) {
			Hibernate.initialize(appointment.getMeeting());
			Hibernate.initialize(appointment.getMeeting().getRooms());
			Hibernate.initialize(appointment.getMeeting().getLecturer());
			// initialize lectures
			if (EMeetingType.LECTURE.equals(
					appointment.getMeeting().getMeetingType())) {
				Hibernate.initialize(
						((Lecture)appointment.getMeeting()).getStudentGroup());
			}
			// initialize exams
			if (EMeetingType.EXAM.equals(
					appointment.getMeeting().getMeetingType())) {
				Hibernate.initialize(
						((Exam)appointment.getMeeting()).getStudentGroups());
			}
			// initialize electives
			if (EMeetingType.ELECTIVE.equals(
					appointment.getMeeting().getMeetingType())) {
				Hibernate.initialize(
						((Elective)appointment.getMeeting()).getCohort());
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
}
