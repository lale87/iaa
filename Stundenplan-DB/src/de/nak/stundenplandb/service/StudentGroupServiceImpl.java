package de.nak.stundenplandb.service;

import java.util.Arrays;
import java.util.List;

import de.nak.stundenplandb.dao.CohortDAO;
import de.nak.stundenplandb.dao.StudentGroupDAO;
import de.nak.stundenplandb.model.Cohort;
import de.nak.stundenplandb.model.EFieldOfStudy;
import de.nak.stundenplandb.model.StudentGroup;
/**
 * Implementation for the StudentGroupService
 * @author Lars Lembke
 *
 */
public class StudentGroupServiceImpl implements StudentGroupService {

	/**
	 * Injected DAO
	 */
	private StudentGroupDAO studentGroupDAO;
	/**
	 * Injected DAO
	 */
	private CohortDAO cohortDAO;
	
	
	@Override
	public void saveStudentGroup(StudentGroup studentGroup) {
		List<Cohort> cohortFromDBList = cohortDAO.loadCohortByYearOfAdmission(studentGroup.getCohort().getYearOfAdmission());
		//Replace Cohort by Cohort from DB - Should be just one element in the list
		if(cohortFromDBList != null && cohortFromDBList.size() == 1){
			studentGroup.setCohort(cohortFromDBList.get(0));
		}
		studentGroupDAO.save(studentGroup);
	}

	@Override
	public List<StudentGroup> loadAllStudentGroups() {
		return studentGroupDAO.loadAll();
	}
	@Override
	public List<EFieldOfStudy> getAllFieldsOfStudy() {
		return Arrays.asList(EFieldOfStudy.values());
	}
	/**
	 * Injects the studentGroupDAO
	 * @param studentGroupDAO
	 */
	public void setStudentGroupDAO(StudentGroupDAO studentGroupDAO){
		this.studentGroupDAO = studentGroupDAO;
	}
	/**
	 * Injects the studentGroupDAO
	 * @param studentGroupDAO
	 */
	public void setCohortDAO(CohortDAO cohortDAO){
		this.cohortDAO = cohortDAO;
	}

		
}
