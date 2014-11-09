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
 * with lists of all existing meetings.
 * 
 * @author Arne Roever
 */
public class ShowMeetingMenuAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7361090700772154126L;
	
	/** The lecture id selected by the user */
	private Long lectureId;
	
	/** The exam id selected by the user. */
	private Long examId;
	
	/** The elective id selected by the user. */
	private Long electiveId;
	
	/** The seminar id selected by the user. */
	private Long seminarId;
	
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
	
	/**
	 * Gets a list of all electives
	 *
	 * @return the elective list
	 */
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

	public Long getLectureId() {
		return lectureId;
	}

	public void setLectureId(Long lectureId) {
		this.lectureId = lectureId;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public Long getElectiveId() {
		return electiveId;
	}

	public void setElectiveId(Long electiveId) {
		this.electiveId = electiveId;
	}

	public Long getSeminarId() {
		return seminarId;
	}

	public void setSeminarId(Long seminarId) {
		this.seminarId = seminarId;
	}
}
