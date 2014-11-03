/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.nak.stundenplandb.dao.ExamDAO;
import de.nak.stundenplandb.dao.StudentGroupDAO;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation of the ExamService
 * @author Fabian Kolossa
 *
 */
public class ExamServiceImpl implements ExamService {
	private MeetingService meetingService;
	private ExamDAO examDAO;
	private StudentGroupDAO studentGroupDAO;
	
	@Override
	public void saveOrUpdateExam(Long id, String meetingName,
			Long lecturerId, List<Long> roomIds, List<Long> studentGroupIds,
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

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	public void setStudentGroupDAO(StudentGroupDAO studentGroupDAO) {
		this.studentGroupDAO = studentGroupDAO;
	}

	@Override
	public boolean CheckCollisionsForExam(Long id, String meetingName,
			Long lecturerId, List<Long> roomIds, List<Long> studentGroupIds,
			int numberOfAppointments, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return true;
	}
}
