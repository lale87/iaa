package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Exam;

/**
 * Implementation des Exam-DAO
 * 
 * @author Lars Lembke
 *
 */
public class ExamDAOImpl extends GenericDaoImplTemp<Exam> implements ExamDAO {

	public ExamDAOImpl() {
		super(Exam.class);
	}

}
