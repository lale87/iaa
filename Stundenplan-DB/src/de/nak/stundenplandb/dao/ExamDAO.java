package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Schnittstelle des Exam-DAO
 * 
 * @author Lars Lembke
 *
 */
public interface ExamDAO extends GenericDAO<Exam> {
	/**
	 * Loads all Meetings for a StudentGroup within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Exam> loadExamForStudentGroup(StudentGroup studentGroup,
			Date start, Date end);

	/**
	 * Loads all Meetings for a Lecturer within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Exam> loadExamForLecturer(Lecturer lecturer, Date start,
			Date end);

	/**
	 * Loads all Meetings in a Room within the given period
	 * 
	 * @return a List of Meeting
	 */
	List<Meeting> loadExamsForRoom(Room room, Date start, Date end);
}
