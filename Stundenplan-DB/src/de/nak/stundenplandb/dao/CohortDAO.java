package de.nak.stundenplandb.dao;

import java.util.List;

import de.nak.stundenplandb.model.Cohort;

/**
 * Interface for the CohortDAO
 * 
 * @author Lars Lembke
 *
 */
public interface CohortDAO extends GenericDAO<Cohort> {
	/**
	 * loads a Cohort by the NaturalID YEAR_OF_ADMISSION
	 * 
	 * @param yearOfAdmission
	 * @return a cohort
	 */
	List<Cohort> loadCohortByYearOfAdmission(Integer yearOfAdmission);
}
