package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Lecture;

/**
 * Implementation of the LectureDAO
 * 
 * @author Lars Lembke
 *
 */
public class LectureDAOImpl extends GenericDAOImpl<Lecture> implements
		LectureDAO {

	public LectureDAOImpl() {
		super(Lecture.class);
	}

}
