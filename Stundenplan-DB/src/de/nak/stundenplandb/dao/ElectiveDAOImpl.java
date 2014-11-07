package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Cohort;
import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.model.Room;

/**
 * Implementation des Elective-DAO
 * 
 * @author Lars Lembke
 *
 */
public class ElectiveDAOImpl extends GenericDAOImpl<Elective> implements
		ElectiveDAO {

	public ElectiveDAOImpl() {
		super(Elective.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Deprecated
	public List<Elective> loadElectivesForStudentGroup(Cohort cohort,
			Date start, Date end) {
		// TODO Datum berücksichtigen
		return (List<Elective>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from ELECTIVE as elective where elective.cohort = :cohort")
				.setEntity("cohort", cohort).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Deprecated
	public List<Elective> loadElectivesForLecturer(Lecturer lecturer,
			Date start, Date end) {
		// TODO Datum berücksichtigen
		return (List<Elective>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from ELECTIVE as elective where elective.lecturer = :lecturer")
				.setEntity("lecturer", lecturer).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Deprecated
	public List<Meeting> loadElectivesForRoom(Room room, Date start, Date end) {
		// TODO Datum berücksichtigen
		return (List<Meeting>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from ELECTIVE as elective where elective.room = :room")
				.setEntity("room", room).list();
	}

}
