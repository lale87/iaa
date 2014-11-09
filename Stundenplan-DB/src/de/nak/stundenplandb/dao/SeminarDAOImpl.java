package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.Seminar;

/**
 * Implementation des Seminar-DAO
 * 
 * @author Lars Lembke
 *
 */
public class SeminarDAOImpl extends GenericDAOImpl<Seminar> implements
		SeminarDAO {

	public SeminarDAOImpl() {
		super(Seminar.class);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	@Deprecated
//	public List<Meeting> loadSeminarsForLecturer(Lecturer lecturer, Date start,
//			Date end) {
//		// TODO DATE
//		return sessionFactory
//				.getCurrentSession()
//				.createQuery(
//						"from SEMINAR as seminar where seminar.lecturer = :lecturer")
//				.setEntity("lecturer", lecturer).list();
//
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	@Deprecated
//	public List<Meeting> loadSeminarsForRoom(Room room, Date start, Date end) {
//		// TODO DATE
//		return sessionFactory
//				.getCurrentSession()
//				.createQuery(
//						"from SEMINAR as seminar where seminar.room = :room")
//				.setEntity("room", room).list();
//	}

}
