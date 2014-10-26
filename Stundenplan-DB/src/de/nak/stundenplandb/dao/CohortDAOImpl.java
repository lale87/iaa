package de.nak.stundenplandb.dao;

import java.util.List;

import de.nak.stundenplandb.model.Cohort;
/**
 * Implementtation des Cohort-DAO
 * @author Lars Lembke
 *
 */
public class CohortDAOImpl extends GenericDAOImpl<Cohort> implements CohortDAO {

	public CohortDAOImpl() {
		super(Cohort.class);
	}
	
	@Override
	public List<Cohort> loadCohortByYearOfAdmission(Integer yearOfAdmission){
		//TODO LL - bisher ungetestet 26.10.14
		return (List<Cohort>) sessionFactory.getCurrentSession().createQuery("from Cohort as cohort where room.yearOfAdmission = :yoa").setInteger("yoa", yearOfAdmission).list();	
	}
}
