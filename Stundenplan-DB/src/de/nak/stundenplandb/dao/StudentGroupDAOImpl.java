package de.nak.stundenplandb.dao;

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

}
