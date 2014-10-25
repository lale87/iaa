package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Lecture;

/**
 * Implementation des Lecture-DAO
 * 
 * @author Lars Lembke
 *
 */
public class LectureDAOImpl extends GenericDaoImplTemp<Lecture> implements
		LectureDAO {

	public LectureDAOImpl() {
		super(Lecture.class);
	}

}
