package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation des Exam-DAO
 * 
 * @author Lars Lembke
 *
 */
public class ExamDAOImpl extends GenericDAOImpl<Exam> implements ExamDAO {

	public ExamDAOImpl() {
		super(Exam.class);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	@Deprecated
//	public List<Exam> loadExamForStudentGroup(StudentGroup studentGroup,
//			Date start, Date end) {
//		// TODO DATE
//		return sessionFactory
//				.getCurrentSession()
//				.createQuery(
//						"from EXAM as exam where exam.studentGroup = :studentGroup")
//				.setEntity("studentGroup", studentGroup).list();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	@Deprecated
//	public List<Exam> loadExamForLecturer(Lecturer lecturer, Date start,
//			Date end) {
//		// TODO DATE
//		return sessionFactory
//				.getCurrentSession()
//				.createQuery(
//						"from EXAM as exam where exam.lecturer = :lecturer")
//				.setEntity("lecturer", lecturer).list();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	@Deprecated
//	public List<Meeting> loadExamsForRoom(Room room, Date start, Date end) {
//		// TODO DATE
//		return sessionFactory.getCurrentSession()
//				.createQuery("from EXAM as exam where exam.room = :room")
//				.setEntity("room", room).list();
//	}

}
