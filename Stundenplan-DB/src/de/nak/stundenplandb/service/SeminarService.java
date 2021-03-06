/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.ECollisionType;
import de.nak.stundenplandb.model.Seminar;

/**
 * Interface of the SeminarService
 * 
 * @author Fabian Kolossa
 *
 */
public interface SeminarService {
	/**
	 * Creates or updates a seminar without collision check
	 * 
	 * @param id
	 *            Set <code>null</code> in order to create a new seminar
	 * @param meetingName
	 *            Name of the seminar
	 * @param lecturerId
	 *            Id of the lecturer
	 * @param roomIds
	 *            List of room ids
	 * @param numberOfAppointments
	 *            Number of weekly recurring appointments
	 * @param startDate
	 *            Start date/time
	 * @param endDate
	 *            End date/time
	 */
	void saveOrUpdateSeminar(Long id, String meetingName, Long lecturerId,
			List<Long> roomIds, int numberOfAppointments, Date startDate,
			Date endDate);

	/**
	 * Collision check for a Seminar. Returns a list of found CollisionTypes
	 * 
	 * @param id
	 *            Set <code>null</code> in order to create a new seminar
	 * @param meetingName
	 *            Name of the seminar
	 * @param lecturerId
	 *            Id of the lecturer
	 * @param roomIds
	 *            List of room ids
	 * @param numberOfAppointments
	 *            Number of weekly recurring appointments
	 * @param startDate
	 *            Start date/time
	 * @param endDate
	 *            End date/time
	 */
	List<ECollisionType> getCollisions(Long id, Long lecturerId,
			List<Long> roomIds, int numberOfAppointments, Date startDate,
			Date endDate);

	/**
	 * Loads all existing seminars
	 * 
	 * @return a List of Seminars
	 */
	List<Seminar> loadAllSeminars();

	/**
	 * deletes a Seminar.
	 *
	 * @param Seminar
	 *            The seminar.
	 */
	void deleteSeminar(Seminar seminar);

	/**
	 * deletes a Seminar by a given ID.
	 *
	 * @param Seminar
	 *            The seminar.
	 */
	void deleteSeminar(Long id);

	/**
	 * loads a Seminar by a given ID.
	 *
	 * @param Seminar
	 *            The seminar.
	 */
	Seminar loadSeminar(Long id);
}
