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
	List<Meeting> loadMeetingsForStudentGroup(Long studentGroupId,
			Date start, Date end);

	/**
	 * Loads all Meetings for a Lecturer within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadMeetingsForLecturer(Long lecturerId, Date start,
			Date end);

	/**
	 * Loads all Meetings in a Room within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadMeetingsForRoom(Long roomId, Date start, Date end);

	/**
	 * Loads all existing meetings
	 * 
	 * @return a List of Meetings
	 */
	List<Meeting> loadAllMeetings();
	/**
	 * TODO FK: comment
	 * @param meeting
	 * @param meetingName
	 * @param lecturerId
	 * @param roomIds
	 * @param numberOfAppointments
	 * @param startDate
	 * @param endDate
	 */
	void fillMeeting(Meeting meeting, String meetingName,
			Long lecturerId, List<Long> roomIds, int numberOfAppointments,
			Date startDate, Date endDate);
}
