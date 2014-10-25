package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Cohort;
/**
 * Implementtation des Cohort-DAO
 * @author Lars Lembke
 *
 */
public class CohortDAOImpl extends GenericDaoImpl<Cohort> implements CohortDAO {

	public CohortDAOImpl() {
		super(Cohort.class);
	}

}