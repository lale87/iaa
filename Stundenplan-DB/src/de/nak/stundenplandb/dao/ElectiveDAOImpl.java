package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Elective;

/**
 * Implementation des Elective-DAO
 * 
 * @author Lars Lembke
 *
 */
public class ElectiveDAOImpl extends GenericDaoImpl<Elective> implements
		ElectiveDAO {

	public ElectiveDAOImpl() {
		super(Elective.class);
	}

}
