package de.nak.stundenplandb.service;

import java.util.List;

import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;

/**
 * Schnittstelle für den LecturerService
 * 
 * @author Lars Lembke
 *
 */
public interface LecturerService {
	/**
	 * Creates or updates a lecturer.
	 *
	 * @param lecturer
	 *            The lecturer.
	 */
	void saveLecturer(Lecturer lecturer);

	/**
	 * Loads a list of all lecturers.
	 *
	 * @return a list which is empty if no lecturer was found.
	 */
	List<Room> loadAllLecturers();
}
