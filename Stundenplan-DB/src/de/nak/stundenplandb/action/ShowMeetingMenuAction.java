/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.Seminar;
import de.nak.stundenplandb.service.ElectiveService;
import de.nak.stundenplandb.service.ExamService;
import de.nak.stundenplandb.service.LectureService;
import de.nak.stundenplandb.service.SeminarService;

/**
 * Action for showing the meeting menu 
 * and a list of all existing meetings.
 * 
 * @author Arne Roever
 */
public class ShowMeetingMenuAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7361090700772154126L;
	
	/** The lecture service. */
	private LectureService lectureService;

	/** The exam service. */
	private ExamService examService;
	
	/** The elective service. */
	private ElectiveService electiveService;
	
	/** The seminar service. */
	private SeminarService seminarService;	
	
	/**
	 * Gets a list of all lectures
	 *
	 * @return the lecture list
	 */
	public List<Lecture> getLectureList(){
		return lectureService.loadAllLectures();
	}
	
	/**
	 * Gets a list of all exams
	 *
	 * @return the exam list
	 */
	public List<Exam> getExamList(){
		return examService.loadAllExams();
	}
	
	public List<Elective> getElectiveList(){
		return electiveService.loadAllElectives();
	}
	
	/**
	 * Gets a list of all seminars
	 *
	 * @return the seminar list
	 */
	public List<Seminar> getSeminarList(){
		return seminarService.loadAllSeminars();
	}
	
	@Override
	public String execute(){
		return SUCCESS;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public void setElectiveService(ElectiveService electiveService) {
		this.electiveService = electiveService;
	}

	public void setSeminarService(SeminarService seminarService) {
		this.seminarService = seminarService;
	}
	
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
}
