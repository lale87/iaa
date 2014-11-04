/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Lecture;

/**
 * Interface of the LectureService
 * 
 * @author Fabian Kolossa
 *
 */
public interface LectureService {
	/**
	 * Creates or updates a lecture without collision check
	 * 
	 * @param id
	 *            Set <code>null</code> in order to create a new lecture
	 * @param meetingName
	 *            Name of the lecture
	 * @param lecturerId
	 *            Id of the lecturer
	 * @param roomIds
	 *            List of room ids
	 * @param studentGroupId
	 *            Id of the student group
	 * @param numberOfAppointments
	 *            Number of weekly recurring appointments
	 * @param startDate
	 *            Start date/time
	 * @param endDate
	 *            End date/time
	 */
	void saveOrUpdateLecture(Long id, String meetingName, Long lecturerId,
			List<Long> roomIds, Long studentGroupId, int numberOfAppointments,
			Date startDate, Date endDate);

	/**
	 * Collision check for a Lecture
	 * 
	 * @param id
	 *            Set <code>null</code> in order to create a new lecture
	 * @param meetingName
	 *            Name of the lecture
	 * @param lecturerId
	 *            Id of the lecturer
	 * @param roomIds
	 *            List of room ids
	 * @param studentGroupId
	 *            Id of the student group
	 * @param numberOfAppointments
	 *            Number of weekly recurring appointments
	 * @param startDate
	 *            Start date/time
	 * @param endDate
	 *            End date/time
	 */
	boolean CheckCollisionsForLecture(Long id, Long lecturerId,
			List<Long> roomIds, Long studentGroupId, int numberOfAppointments,
			Date startDate, Date endDate);

	/**
	 * Loads all existing lectures
	 * 
	 * @return a List of Lecture
	 */
	List<Lecture> loadAllLectures();

	/**
	 * deletes a Lecture.
	 *
	 * @param lecture
	 *            The lecture.
	 */
	void deleteLecture(Lecture lecture);

	/**
	 * deletes a Lecture by a given ID.
	 *
	 * @param lecture
	 *            The lecture.
	 */
	void deleteLecture(Long id);

	/**
	 * loads a Lecture by a given ID.
	 *
	 * @param lecture
	 *            The lecture.
	 */
	Lecture loadLecture(Long id);
}
