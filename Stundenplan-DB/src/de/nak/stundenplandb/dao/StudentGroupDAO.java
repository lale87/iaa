package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.StudentGroup;

/**
 * Schnittstelle für das StudentGroup-DAO
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

	/**
	 * Chekcs if the the studentGroup is busy during the given time period
	 * 
	 * @param studentGroupId
	 * @param start
	 * @param end
	 * @return
	 */
	boolean isBusy(Long studentGroupId, Date start, Date end);
}
