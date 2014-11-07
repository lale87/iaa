/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import de.nak.stundenplandb.dao.ExamDAO;
import de.nak.stundenplandb.dao.StudentGroupDAO;
import de.nak.stundenplandb.model.ECollisionType;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation of the ExamService
 * 
 * @author Fabian Kolossa
 *
 */
public class ExamServiceImpl implements ExamService {
	private MeetingService meetingService;
	private ExamDAO examDAO;
	private StudentGroupDAO studentGroupDAO;
	private RoomService roomService;

	@Override
	public void saveOrUpdateExam(Long id, String meetingName, Long lecturerId,
			List<Long> roomIds, List<Long> studentGroupIds,
			int numberOfAppointments, Date startDate, Date endDate) {
		// TODO FK: Fehlerbehandlung (Objekt zu ID nicht gefunden)

		// update? (null if exam not exists yet)
		Exam exam = examDAO.load(id);
		if (exam == null) {
			exam = new Exam();
		}

		// set meeting attributes
		meetingService.fillMeeting(exam, meetingName, lecturerId, roomIds,
				numberOfAppointments, startDate, endDate, EMeetingType.EXAM);

		// set exam-specific attributes
		Set<StudentGroup> studentGroups = new HashSet<StudentGroup>();
		for (Long studentGroupId : studentGroupIds) {
			StudentGroup studentGroup = studentGroupDAO.load(studentGroupId);
			studentGroups.add(studentGroup);
		}
		exam.setStudentGroups(studentGroups);

		// save exam
		examDAO.save(exam);
	};

	@Override
	public void deleteExam(Exam exam) {
		examDAO.delete(exam);
	}

	/**
	 * Inject the MeetingService
	 * 
	 * @param meetingService
	 */
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	/**
	 * Inject the ExamDAO
	 * 
	 * @param examDAO
	 */
	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	/**
	 * Inject the StudentGroupDAO
	 * 
	 * @param studentGroupDAO
	 */
	public void setStudentGroupDAO(StudentGroupDAO studentGroupDAO) {
		this.studentGroupDAO = studentGroupDAO;
	}

	/**
	 * Inject the RoomService
	 * 
	 * @param roomService
	 */
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	@Override
	public boolean CheckCollisionsForExam(Long id, Long lecturerId,
			List<Long> roomIds, List<Long> studentGroupIds,
			int numberOfAppointments, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Exam> loadAllExams() {
		List<Exam> allExams = examDAO.loadAll();
		initializeExams(allExams);
		return allExams;
	}

	@Override
	public void deleteExam(Long id) {
		examDAO.delete(this.loadExam(id));
	}

	@Override
	public Exam loadExam(Long id) {
		Exam exam = examDAO.load(id);
		initializeExam(exam);
		return exam;
	}

	// TODO diese Mthoden evtl zusammenfassen bei allen Meeting-Subtypes
	private void initializeExams(List<Exam> exams) {
		for (Exam exam : exams) {
			initializeExam(exam);
		}
	}

	private void initializeExam(Exam exam) {
		Hibernate.initialize(exam.getLecturer());
		Hibernate.initialize(exam.getRooms());
		Hibernate.initialize(exam.getAppointments());
		Hibernate.initialize(exam.getStudentGroups());
	}

	@Override
	public List<ECollisionType> getCollisions(Long id, Long lecturerId,
			List<Long> roomIds, List<Long> studentGroupIds,
			int numberOfAppointments, Date startDate, Date endDate) {
		// The set with all found collionsTypes
		Set<ECollisionType> collisionsSet = new HashSet<ECollisionType>();
		// TODO Kollisionsprüfung einbauen
		// Check for RoomCollisions
		for (Long roomId : roomIds) {
			if (this.roomService.isOccupied(roomId, startDate, endDate)) {
				collisionsSet.add(ECollisionType.ROOM_OCCUPIED);
			}
		}
		// returns a List of all found collsionTypes
		return new ArrayList<ECollisionType>(collisionsSet);
	}
}
