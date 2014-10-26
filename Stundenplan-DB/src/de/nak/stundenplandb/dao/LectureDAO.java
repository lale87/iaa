package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation des Lecture-DAO
 * 
 * @author Lars Lembke
 *
 */
public interface LectureDAO extends GenericDAO<Lecture> {
	/**
	 * Loads all Lectures for a StudentGroup within the given period
	 * 
	 * @return a List of Lectures
	 */
	List<Lecture> loadLecturesForStudentGroup(StudentGroup studentGroup,
			Date start, Date end);

	/**
	 * Loads all Lectures for a Lecturer within the given period
	 * 
	 * @return a List of Lectures
	 */
	List<Lecture> loadLecturesForLecturer(Lecturer lecturer, Date start,
			Date end);

	/**
	 * Loads all Lectures in a Room within the given period
	 * 
	 * @return a List of Lectures
	 */
	List<Lecture> loadLecturesForRoom(Room room, Date start, Date end);}
