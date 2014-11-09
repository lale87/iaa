package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Meeting;

/**
 * Interface for the MeetingService
 * 
 * @author Lars Lembke
 *
 */
public interface MeetingService {


	/**
	 * Sets all meeting specific attributes.
	 * 
	 * @param meeting
	 *            Specific meeting instance (lecture, exam, elective or seminar)
	 * @param meetingName
	 *            Title of the meeting
	 * @param lecturerId
	 *            Lecturer-Id
	 * @param roomIds
	 *            Room-Ids
	 * @param numberOfAppointments
	 *            Number of Appointments (iterations)
	 * @param startDate
	 *            Start date
	 * @param endDate
	 *            End date
	 */
	void fillMeeting(Meeting meeting, String meetingName, Long lecturerId,
			List<Long> roomIds, int numberOfAppointments, Date startDate,
			Date endDate, EMeetingType meetingType);

	/**
	 * Deletes a Meeting by a given ID
	 * 
	 * @param meetingId
	 */
	public void deleteExam(Long examId);

	/**
	 * Deletes a Seminar by a given ID
	 * 
	 * @param seminarId
	 */
	public void deleteSeminar(Long seminarId);

	/**
	 * Deletes a Elective by a given ID
	 * 
	 * @param electiveId
	 */
	public void deleteElective(Long electiveId);

	/**
	 * Deletes a Lecture by a given ID
	 * 
	 * @param lectureId
	 */
	public void deleteLecture(Long lectureId);
}
