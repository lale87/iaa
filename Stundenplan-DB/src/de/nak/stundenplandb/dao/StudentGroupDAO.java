package de.nak.stundenplandb.dao;

import java.util.List;

import de.nak.stundenplandb.model.StudentGroup;

/**
 * Interface for the StudentGroupDAO
 * 
 * @author Lars Lembke
 *
 */
public interface StudentGroupDAO extends GenericDAO<StudentGroup> {
	/**
	 * loads all StudentGroups for a specific Cohort
	 * 
	 * @param cohortId
	 * @return
	 */
	List<StudentGroup> loadStudentGroupsByCohortId(Long cohortId);
}
