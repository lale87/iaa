package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Seminar;

/**
 * Implementation des Seminar-DAO
 * 
 * @author Lars Lembke
 *
 */
public class SeminarDAOImpl extends GenericDaoImplTemp<Seminar> implements
		SeminarDAO {

	public SeminarDAOImpl() {
		super(Seminar.class);
	}

}
