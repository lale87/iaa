package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.Seminar;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Schnittstelle für den MeetingService
 * 
 * @author Lars Lembke
 *
 */
public interface MeetingService {
	/**
	 * Creates or updates an Exam.
	 *
	 * @param exam
	 *            The exam.
	 */
	void saveExam(Exam exam);

	/**
	 * deletes an Exam.
	 *
	 * @param exam
	 *            The exam.
	 */
	void deleteExam(Exam exam);

	/**
	 * Creates or updates a Lecture.
	 *
	 * @param Lecture
	 *            The lecture.
	 */
	void saveLecture(Lecture lecture);

	/**
	 * deletes a Lecture.
	 *
	 * @param lecture
	 *            The lecture.
	 */
	void deleteLecture(Lecture lecture);

	/**
	 * Creates or updates a Seminar.
	 *
	 * @param seminar
	 *            The seminar.
	 */
	void saveSeminar(Seminar seminar);

	/**
	 * deletes a Seminar.
	 *
	 * @param Seminar
	 *            The seminar.
	 */
	void deleteSeminar(Seminar seminar);

	/**
	 * Creates or updates an Elective.
	 *
	 * @param elective
	 *            The elective.
	 */
	void saveElective(Elective elective);

	/**
	 * deletes an Elective.
	 *
	 * @param elective
	 *            The elective.
	 */
	void deleteElective(Elective elective);

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
	List<Meeting> loadMeetingsForStudentGroup(StudentGroup studentGroup,
			Date start, Date end);

	/**
	 * Loads all Meetings for a Lecturer within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadMeetingsForLecturer(Lecturer lecturer, Date start,
			Date end);

	/**
	 * Loads all Meetings in a Room within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadMeetingsForRoom(Room room, Date start, Date end);
}
