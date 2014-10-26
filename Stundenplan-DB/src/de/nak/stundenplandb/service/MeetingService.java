package de.nak.stundenplandb.service;

import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Seminar;

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
}
