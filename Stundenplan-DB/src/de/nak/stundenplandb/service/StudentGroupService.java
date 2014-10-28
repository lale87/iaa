package de.nak.stundenplandb.service;

import java.util.List;

import de.nak.stundenplandb.model.Cohort;
import de.nak.stundenplandb.model.EFieldOfStudy;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Schnittstelle für den StudentGroupService
 * 
 * @author Lars Lembke
 *
 */
public interface StudentGroupService {
	/**
	 * Creates StudentGroup.
	 *
	 * @param studentGroup
	 *            The studentGroup.
	 */
	void saveStudentGroup(StudentGroup studentGroup);

	/**
	 * Loads a list of all studentGroups.
	 *
	 * @return a list which is empty if no studentGroup was found.
	 */
	List<StudentGroup> loadAllStudentGroups();

	/**
	 * Loads a list of all cohorts.
	 *
	 * @return a list which is empty if no cohort was found.
	 */
	List<Cohort> loadAllCohorts();

	/**
	 * Loads a list of all cohorts.
	 *
	 * @return a list which is empty if no cohort was found.
	 */
	List<Cohort> loadAllCohortsSortedByYearOfAdmission();

	/**
	 * Returns the Enum EFieldOfStudy as a list
	 * 
	 * @return fieldOfStudy
	 */
	List<EFieldOfStudy> getAllFieldsOfStudy();

	/**
	 * Loads a list of all studentGroups. The Groups are sorted by the Year of
	 * Admission, the Abbreviation of the FielOfStudy and the GroupIdentifier
	 *
	 * @return a list which is empty if no studentGroup was found.
	 */
	List<StudentGroup> loadAllStudentGroupsSorted();
}
