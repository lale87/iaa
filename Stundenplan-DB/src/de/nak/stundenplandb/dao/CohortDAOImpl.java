package de.nak.stundenplandb.dao;

import java.util.List;

import de.nak.stundenplandb.model.Cohort;

/**
 * Implementation of the CohortDAO
 * 
 * @author Lars Lembke
 *
 */
public class CohortDAOImpl extends GenericDAOImpl<Cohort> implements CohortDAO {

	public CohortDAOImpl() {
		super(Cohort.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cohort> loadCohortByYearOfAdmission(Integer yearOfAdmission) {
		return (List<Cohort>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Cohort as cohort where cohort.yearOfAdmission = :yoa")
				.setInteger("yoa", yearOfAdmission).list();
	}
}
