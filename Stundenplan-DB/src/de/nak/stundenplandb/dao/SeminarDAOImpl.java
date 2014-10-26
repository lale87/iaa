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

	@Override
	public List<Meeting> loadSeminarsForLecturer(Lecturer lecturer, Date start,
			Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meeting> loadSeminarsForRoom(Room room, Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

}
