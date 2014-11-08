package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.EAcademicTitle;
import de.nak.stundenplandb.model.Lecturer;

/**
 * Schnittstelle für den LecturerService
 * 
 * @author Lars Lembke
 *
 */
public interface LecturerService {
	/**
	 * Creates or updates a lecturer.
	 *
	 * @param lecturer
	 *            The lecturer.
	 */
	void saveLecturer(Lecturer lecturer);

	/**
	 * Loads a list of all lecturers.
	 *
	 * @return a list which is empty if no lecturer was found.
	 */
	List<Lecturer> loadAllLecturers();

	/**
	 * Returns the Enum EAcademicTitle as a list
	 * 
	 * @return academicTitle
	 */
	List<EAcademicTitle> getAllAcademicTitles();

	/**
	 * Returns a List of all Appointments for a given lecturer.
	 * 
	 * @param lecturerId
	 *            Lecturer-Id
	 * @return List of Appointments
	 */
	List<Appointment> getAppointmentsForLecturer(Long lecturerId);
	/**
	 * Returns a List of all Appointments for a given lecturer in a specific
	 * week of a year.
	 * @param lecturerId
	 * 			Lecturer-Id
	 * @param week
	 * 			Week of year
	 * @param year
	 * 			Year
	 * @return List of Appointments
	 */
	List<Appointment> getAppointmentsForLecturerInWeek(Long lecturerId, 
			int week, int year);
	/**
	 * Returns a List of all Appointments for a given lecturer in a specific
	 * period of time.
	 * 
	 * @param lecturerId
	 *            Lecturer-Id
	 * @param start
	 *            Start of timeperiod
	 * @param end
	 *            End of timeperiod
	 * @return List of Appointments
	 */
	List<Appointment> getAppointmentsForLecturerInTimeperiod(Long lecturerId,
			Date start, Date end);

	public boolean isBusy(Long lecturerId, Date start, Date end);
}
