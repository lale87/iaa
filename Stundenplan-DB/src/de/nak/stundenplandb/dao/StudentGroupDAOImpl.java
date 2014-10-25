package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation des StudentGroup-DAO
 * 
 * @author Lars Lembke
 *
 */
public class StudentGroupDAOImpl extends GenericDaoImplTemp<StudentGroup> implements
		StudentGroupDAO {

	public StudentGroupDAOImpl() {
		super(StudentGroup.class);
	}

}
