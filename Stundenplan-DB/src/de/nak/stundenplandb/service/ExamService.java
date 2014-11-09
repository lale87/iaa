/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.ECollisionType;
import de.nak.stundenplandb.model.Exam;

/**
 * Interface of the ExamService
 * 
 * @author Fabian Kolossa
 *
 */
public interface ExamService {
	/**
	 * Creates or updates an exam without collision check
	 * 
	 * @param id
	 *            Set <code>null</code> in order to create a new exam
	 * @param meetingName
	 *            Name of the exam
	 * @param lecturerId
	 *            Id of the lecturer
	 * @param roomIds
	 *            List of room ids
	 * @param studentGroupIds
	 *            List of student group ids
	 * @param numberOfAppointments
	 *            Number of weekly recurring appointments
	 * @param startDate
	 *            Start date/time
	 * @param endDate
	 *            End date/time
	 */
	void saveOrUpdateExam(Long id, String meetingName, Long lecturerId,
			List<Long> roomIds, List<Long> studentGroupIds,
			int numberOfAppointments, Date startDate, Date endDate);

//	/**
//	 * collision check for an Exam
//	 * 
//	 * @param id
//	 *            Set <code>null</code> in order to create a new exam
//	 * @param meetingName
//	 *            Name of the exam
//	 * @param lecturerId
//	 *            Id of the lecturer
//	 * @param roomIds
//	 *            List of room ids
//	 * @param studentGroupIds
//	 *            List of student group ids
//	 * @param numberOfAppointments
//	 *            Number of weekly recurring appointments
//	 * @param startDate
//	 *            Start date/time
//	 * @param endDate
//	 *            End date/time
//	 */
//	@Deprecated
//	boolean CheckCollisionsForExam(Long id, Long lecturerId,
//			List<Long> roomIds, List<Long> studentGroupIds,
//			int numberOfAppointments, Date startDate, Date endDate);

	/**
	 * collision check for an Exam. Returns a list with all found collisionTypes
	 * 
	 * @param id
	 *            Set <code>null</code> in order to create a new exam
	 * @param meetingName
	 *            Name of the exam
	 * @param lecturerId
	 *            Id of the lecturer
	 * @param roomIds
	 *            List of room ids
	 * @param studentGroupIds
	 *            List of student group ids
	 * @param numberOfAppointments
	 *            Number of weekly recurring appointments
	 * @param startDate
	 *            Start date/time
	 * @param endDate
	 *            End date/time
	 */
	List<ECollisionType> getCollisions(Long id, Long lecturerId,
			List<Long> roomIds, List<Long> studentGroupIds,
			int numberOfAppointments, Date startDate, Date endDate);

	/**
	 * Loads all existing exams
	 * 
	 * @return a List of Exams
	 */
	List<Exam> loadAllExams();

	/**
	 * deletes an Exam.
	 *
	 * @param exam
	 *            The exam.
	 */
	void deleteExam(Exam exam);

	/**
	 * deletes an Exam by a given ID.
	 *
	 * @param exam
	 *            The exam.
	 */
	void deleteExam(Long id);

	/**
	 * loads an Exam.
	 *
	 * @param exam
	 *            The exam.
	 */
	Exam loadExam(Long id);
}
