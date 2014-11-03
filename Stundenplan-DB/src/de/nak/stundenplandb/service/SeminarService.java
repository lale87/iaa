/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Seminar;

/**
 * Interface of the SeminarService
 * @author Fabian Kolossa
 *
 */
public interface SeminarService {
	/**
	 * Creates or updates a seminar without collision check
	 * @param id Set <code>null</code> in order to create a new seminar
	 * @param meetingName Name of the seminar
	 * @param lecturerId Id of the lecturer
	 * @param roomIds List of room ids
	 * @param numberOfAppointments Number of weekly recurring appointments
	 * @param startDate Start date/time
	 * @param endDate End date/time
	 */
	void saveOrUpdateSeminar(Long id, String meetingName, Long lecturerId,
			List<Long> roomIds, int numberOfAppointments, Date startDate, Date endDate);
	
	/**
	 * Collision check for a Seminar
	 * @param id Set <code>null</code> in order to create a new seminar
	 * @param meetingName Name of the seminar
	 * @param lecturerId Id of the lecturer
	 * @param roomIds List of room ids
	 * @param numberOfAppointments Number of weekly recurring appointments
	 * @param startDate Start date/time
	 * @param endDate End date/time
	 */
	boolean checkCollisionsForSeminar(Long id, Long lecturerId,
			List<Long> roomIds, int numberOfAppointments, Date startDate, Date endDate);

	/**
	 * deletes a Seminar.
	 *
	 * @param Seminar
	 *            The seminar.
	 */
	void deleteSeminar(Seminar seminar);
}
