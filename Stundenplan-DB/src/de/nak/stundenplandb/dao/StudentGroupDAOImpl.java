package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation des StudentGroup-DAO
 * 
 * @author Lars Lembke
 *
 */
public class StudentGroupDAOImpl extends GenericDAOImpl<StudentGroup> implements
		StudentGroupDAO {

	public StudentGroupDAOImpl() {
		super(StudentGroup.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentGroup> loadStudentGroupsByCohortId(Long cohortId) {
		return (List<StudentGroup>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from StudentGroup as studentGroup where studentGroup.cohort = :id")
				.setLong("id", cohortId).list();
	}

//	@Override
//	@Deprecated
//	public boolean isBusy(Long studentGroupId, Date start, Date end) {
//		// TODO Hier muss geprüft werden, ob eine StudentGroup beschäftigt ist
//		return true;
//	}

}
