/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.EFieldOfStudy;
import de.nak.stundenplandb.model.StudentGroup;
import de.nak.stundenplandb.service.StudentGroupService;

/**
 * Action for a single StudentGroup
 * or getting all student groups.
 *
 * @author Arne Roever
 */
public class StudentGroupAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8655068170554081339L;
	
	/** The current student group. */
	private StudentGroup studentGroup;	
	
	/** The student group service. */
	private StudentGroupService studentGroupService;
	
	/**
	 * Save student group to the database.
	 * Displays constraint error if entry already exists.
	 *
	 * @return the result string
	 */
	public String save(){
		try {
			studentGroupService.saveStudentGroup(studentGroup);
		} catch (ConstraintViolationException e) {
			addActionError(getText("msg.error.studentGroupConstraint"));
			return INPUT;
		}		
		return SUCCESS;
	}
	
	/**
	 * Cancel method for avoiding stacktraces
	 *
	 * @return the result string
	 */
	public String cancel(){
		return SUCCESS;
	}
	
	/**
	 * Gets all student groups from the database
	 *
	 * @return all student groups
	 */
	public List<StudentGroup> getAllStudentGroups(){
		return studentGroupService.loadAllStudentGroups();
	}
	
	/**
	 * Gets all fields of study.
	 *
	 * @return the all fields of study
	 */
	public List<EFieldOfStudy> getAllFieldsOfStudy(){
		return studentGroupService.getAllFieldsOfStudy();
	}
	
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}

	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}

	public void setStudentGroupService(StudentGroupService studentGroupService) {
		this.studentGroupService = studentGroupService;
	}


}
