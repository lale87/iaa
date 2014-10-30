package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.EAcademicTitle;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.service.LecturerService;



/**
 * The Class LecturerAction.
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
	 * Save the lecturer to the database.
	 *
	 * @return the result string
	 */
	public String save(){
		System.out.println("HIer");
		lecturerService.saveLecturer(lecturer);
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
