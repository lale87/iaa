package de.nak.stundenplandb.service;

import de.nak.stundenplandb.dao.ElectiveDAO;
import de.nak.stundenplandb.dao.ExamDAO;
import de.nak.stundenplandb.dao.LectureDAO;
import de.nak.stundenplandb.dao.SeminarDAO;
import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Seminar;

/**
 * Implementation for the MeetingService
 * 
 * @author Lars Lembke
 *
 */
public class MeetingServiceImpl implements MeetingService {
	/**
	 * Injected ExamDAO
	 */
	private ExamDAO examDAO;
	/**
	 * Injected SeminarDAO
	 */
	private SeminarDAO seminarDAO;
	/**
	 * Injected ElectiveDAO
	 */
	private ElectiveDAO electiveDAO;
	/**
	 * Injected LectureDAO
	 */
	private LectureDAO lectureDAO;

	@Override
	public void saveExam(Exam exam) {
		examDAO.save(exam);
	}

	@Override
	public void deleteExam(Exam exam) {
		examDAO.delete(exam);
	}

	@Override
	public void saveLecture(Lecture lecture) {
		lectureDAO.save(lecture);
	}

	@Override
	public void deleteLecture(Lecture lecture) {
		lectureDAO.delete(lecture);
	}

	@Override
	public void saveSeminar(Seminar seminar) {
		seminarDAO.save(seminar);
	}

	@Override
	public void deleteSeminar(Seminar seminar) {
		seminarDAO.delete(seminar);
	}

	@Override
	public void saveElective(Elective elective) {
		electiveDAO.save(elective);
	}

	@Override
	public void deleteElective(Elective elective) {
		electiveDAO.delete(elective);
	}

	/**
	 * Injects the ExamDAO
	 * 
	 * @param examDAO
	 */
	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	/**
	 * Injects the SeminarDAO
	 * 
	 * @param seminarDAO
	 */
	public void setSeminarDAO(SeminarDAO seminarDAO) {
		this.seminarDAO = seminarDAO;
	}

	/**
	 * Injects the LectureDAO
	 * 
	 * @param lectureDAO
	 */
	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}

	/**
	 * Injects the ElectiveDAO
	 * 
	 * @param electiveDAO
	 */
	public void setElectiveDAO(ElectiveDAO electiveDAO) {
		this.electiveDAO = electiveDAO;
	}

}
