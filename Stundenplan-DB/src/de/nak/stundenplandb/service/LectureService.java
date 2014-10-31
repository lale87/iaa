/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Lecture;

/**
 * Interface of the LectureService
 * @author Fabian Kolossa
 *
 */
public interface LectureService {
	/**
	 * Creates or updates a lecture without collision check
	 * @param id Set <code>null</code> in order to create a new lecture
	 * @param meetingName Name of the lecture
	 * @param lecturerId Id of the lecturer
	 * @param roomIds List of room ids
	 * @param studentGroupId Id of the student group
	 * @param numberOfAppointments Number of weekly recurring appointments
	 * @param startDate Start date/time
	 * @param endDate End date/time
	 */
	void saveOrUpdateLecture(Long id, String meetingName, Long lecturerId,
			List<Long> roomIds, Long studentGroupId, int numberOfAppointments,
			Date startDate, Date endDate);

	/**
	 * deletes a Lecture.
	 *
	 * @param lecture
	 *            The lecture.
	 */
	void deleteLecture(Lecture lecture);
}