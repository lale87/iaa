package de.nak.stundenplandb.dao;

import java.util.List;

import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation of the StudentGroupDAO
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

}
