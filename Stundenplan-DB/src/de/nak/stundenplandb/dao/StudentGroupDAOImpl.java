package de.nak.stundenplandb.dao;

import java.util.ArrayList;
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

	@Override
	public List<StudentGroup> loadStudentGroupsByCohortId(Long cohortId) {
		// TODO StudentGroups eine Kohorte Suchen
		return new ArrayList<StudentGroup>();
	}

}
