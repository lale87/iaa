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
public class LectureDAOImpl extends GenericDAOImpl<Lecture> implements
		LectureDAO {

	public LectureDAOImpl() {
		super(Lecture.class);
	}

	@Override
	public List<Lecture> loadLecturesForStudentGroup(StudentGroup studentGroup,
			Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lecture> loadLecturesForLecturer(Lecturer lecturer, Date start,
			Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lecture> loadLecturesForRoom(Room room, Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

}
