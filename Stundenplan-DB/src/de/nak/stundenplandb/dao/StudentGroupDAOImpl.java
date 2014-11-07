package de.nak.stundenplandb.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Cohort;
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

	// TODO noch nicht getestet
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentGroup> loadStudentGroupsByCohortId(Long cohortId) {
		List<StudentGroup> test =(List<StudentGroup>) sessionFactory
		.getCurrentSession()
		.createQuery(
				"from StudentGroup as studentGroup where studentGroup.cohort = :id")
		.setLong("id", cohortId).list();
		
		for (StudentGroup studentGroup : test) {
			System.out.println(studentGroup.getDisplayName());
		}
		return (List<StudentGroup>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from StudentGroup as studentGroup where studentGroup.cohort = :id")
				.setLong("id", cohortId).list();
	}

	@Override
	public boolean isBusy(Long studentGroupId, Date start, Date end) {
		// TODO Hier muss geprüft werden, ob eine StudentGroup beschäftigt ist
		return true;
	}

}
