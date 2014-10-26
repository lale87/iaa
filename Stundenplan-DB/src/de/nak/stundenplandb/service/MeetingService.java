package de.nak.stundenplandb.service;

import de.nak.stundenplandb.model.Meeting;

/**
 * Schnittstelle für den MeetingService
 * 
 * @author Lars Lembke
 *
 */
public interface MeetingService {
	/**
	 * Creates or updates a Meeting.
	 *
	 * @param meeting
	 *            The meeting.
	 */
	void saveMeeting(Meeting meeting);

	/**
	 * deletes a Meeting.
	 *
	 * @param meeting
	 *            The meeting.
	 */
	void deleteMeeting(Meeting meeting);
}
