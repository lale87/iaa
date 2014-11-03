/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Elective;

/**
 * Interface of the ElectiveService
 * @author Fabian Kolossa
 *
 */
public interface ElectiveService {
	/**
	 * Creates or updates an elective without collision check
	 * @param id Set <code>null</code> in order to create a new elective
	 * @param meetingName Name of the exam
	 * @param lecturerId Id of the lecturer
	 * @param roomIds List of room ids
	 * @param cohortId Id of the cohort
	 * @param numberOfAppointments Number of weekly recurring appointments
	 * @param startDate Start date/time
	 * @param endDate End date/time
	 */
	void saveOrUpdateElective(Long id, String meetingName, Long lecturerId,
			List<Long> roomIds, Long cohortId, int numberOfAppointments,
			Date startDate, Date endDate);
	/**
	 * Collision check for an Elective
	 * @param id Set <code>null</code> in order to create a new elective
	 * @param meetingName Name of the exam
	 * @param lecturerId Id of the lecturer
	 * @param roomIds List of room ids
	 * @param cohortId Id of the cohort
	 * @param numberOfAppointments Number of weekly recurring appointments
	 * @param startDate Start date/time
	 * @param endDate End date/time
	 */
	boolean checkCollisionsForElective(Long id, String meetingName, Long lecturerId,
			List<Long> roomIds, Long cohortId, int numberOfAppointments,
			Date startDate, Date endDate);

	/**
	 * deletes an Elective.
	 *
	 * @param elective
	 *            The elective.
	 */
	void deleteElective(Elective elective);
}
