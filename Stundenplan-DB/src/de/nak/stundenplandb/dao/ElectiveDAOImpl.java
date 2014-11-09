package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Elective;

/**
 * Implementation of the ElectiveDAO
 * 
 * @author Lars Lembke
 *
 */
public class ElectiveDAOImpl extends GenericDAOImpl<Elective> implements
		ElectiveDAO {

	public ElectiveDAOImpl() {
		super(Elective.class);
	}

}
