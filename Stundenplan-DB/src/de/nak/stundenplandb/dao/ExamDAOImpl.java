package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Exam;

/**
 * Implementation of the ExamDAO
 * 
 * @author Lars Lembke
 *
 */
public class ExamDAOImpl extends GenericDAOImpl<Exam> implements ExamDAO {

	public ExamDAOImpl() {
		super(Exam.class);
	}

}
