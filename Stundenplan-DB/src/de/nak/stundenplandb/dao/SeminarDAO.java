package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.Seminar;

/**
 * Schnittstelle für das Seminar-DAO
 * 
 * @author Lars Lembke
 *
 */
public interface SeminarDAO extends GenericDAO<Seminar> {

//	/**
//	 * Loads all Seminars for a Lecturer within the given period
//	 * 
//	 * @return a List of Seminar
//	 */
//	@Deprecated
//	List<Meeting> loadSeminarsForLecturer(Lecturer lecturer, Date start,
//			Date end);
//
//	/**
//	 * Loads all Seminars in a Room within the given period
//	 * 
//	 * @return a List of Seminar
//	 */
//	@Deprecated
//	List<Meeting> loadSeminarsForRoom(Room room, Date start, Date end);
}
