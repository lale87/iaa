package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Meeting;

/**
 * Schnittstelle für den MeetingService
 * 
 * @author Lars Lembke
 *
 */
public interface MeetingService {
	/**
	 * checks for conflicts
	 * 
	 * @param meeting
	 * @return isPossible
	 */
	boolean isPossible(Meeting meeting);

	/**
	 * Loads all Meetings for a StudentGroup within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadMeetingsForStudentGroup(Long studentGroupId, Date start,
			Date end);

	/**
	 * Loads all Meetings for a StudentGroup
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadAllMeetingsForStudentGroup(Long studentGroupId);

	/**
	 * Loads all Meetings for a Lecturer within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadMeetingsForLecturer(Long lecturerId, Date start, Date end);

	/**
	 * Loads all Meetings for a Lecturer
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadAllMeetingsForLecturer(Long lecturerId);

	/**
	 * Loads all Meetings in a Room within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadMeetingsForRoom(Long roomId, Date start, Date end);

	/**
	 * Loads all Meetings in a Room
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadAllMeetingsForRoom(Long roomId);

	/**
	 * Loads all existing meetings
	 * 
	 * @return a List of Meetings
	 */
	List<Meeting> loadAllMeetings();

	/**
	 * TODO FK: comment
	 * 
	 * @param meeting
	 * @param meetingName
	 * @param lecturerId
	 * @param roomIds
	 * @param numberOfAppointments
	 * @param startDate
	 * @param endDate
	 */
	void fillMeeting(Meeting meeting, String meetingName, Long lecturerId,
			List<Long> roomIds, int numberOfAppointments, Date startDate,
			Date endDate);

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
