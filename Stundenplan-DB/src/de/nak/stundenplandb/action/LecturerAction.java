package de.nak.stundenplandb.action;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.EAcademicTitle;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.service.LecturerService;

/**
 * Action for a single lecturer 
 * or getting all existing lecturers
 * 
 * @author Arne Roever
 */
public class LecturerAction extends ActionSupport {

	/** Serial version UID.	 */
	private static final long serialVersionUID = 4082240062555980968L;
		
	/** The current lecturer. */
	private Lecturer lecturer;		

	/** The lecturer service. */
	private LecturerService lecturerService;

	/**
	 * Saves the lecturer to the database.
	 *
	 * @return the result string
	 */
	public String save(){
		try {
			lecturerService.saveLecturer(lecturer);
		} catch (ConstraintViolationException e) {
			addActionError(getText("msg.error.lecturerConstraint"));
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
	 * Gets all academic titles.
	 *
	 * @return all academic titles
	 */
	public List<EAcademicTitle> getAllAcademicTitles(){		
		return lecturerService.getAllAcademicTitles();
	}
	
	/**
	 * Gets all existing lecturers in the database
	 *
	 * @return all lecturers
	 */
	public List<Lecturer> getAllLecturers(){
		return lecturerService.loadAllLecturers();
	}
	
	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}
	
	

}
