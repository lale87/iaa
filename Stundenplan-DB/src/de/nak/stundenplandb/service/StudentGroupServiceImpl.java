package de.nak.stundenplandb.service;

import java.util.Arrays;
import java.util.List;

import de.nak.stundenplandb.dao.StudentGroupDAO;
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
	
	@Override
	public void saveStudentGroup(StudentGroup studentGroup) {
		studentGroupDAO.save(studentGroup);
	}

	@Override
	public List<StudentGroup> loadAllStudentGroups() {
		return studentGroupDAO.loadAll();
	}

	public void setStudentGroupDAO(StudentGroupDAO studentGroupDAO){
		this.studentGroupDAO = studentGroupDAO;
	}

	@Override
	public List<EFieldOfStudy> getAllFieldsOfStudy() {
		return Arrays.asList(EFieldOfStudy.values());
	}
		
}
