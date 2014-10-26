package de.nak.stundenplandb.service;

import java.util.List;

import de.nak.stundenplandb.model.EAcademicTitle;
import de.nak.stundenplandb.model.Lecturer;

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
	List<Lecturer> loadAllLecturers();

	/**
	 * Returns the Enum EAcademixTitle as a list
	 * 
	 * @return academicTitle
	 */
	List<EAcademicTitle> getAllAcademicTitles();
}
