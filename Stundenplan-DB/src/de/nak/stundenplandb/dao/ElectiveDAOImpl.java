package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Elective;

/**
 * Implementation des Elective-DAO
 * 
 * @author Lars Lembke
 *
 */
public class ElectiveDAOImpl extends GenericDaoImplTemp<Elective> implements
		ElectiveDAO {

	public ElectiveDAOImpl() {
		super(Elective.class);
	}

}
