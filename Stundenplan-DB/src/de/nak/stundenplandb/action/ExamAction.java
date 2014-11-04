/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.service.ExamService;


/**
 * Action for a single Exam.
 * 
 * @author Arne Roever
 *
 */
public class ExamAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6938348041955775951L;
	
	/** The currently selected exam id. */
	private Long examId;

	/** The current exam. */
	private Exam exam;

	/** The  student group id selected by the user. */
	private List<Long> studentGroupIds; 
	
	/** The exam service. */
	private ExamService examService;

	/**
	 * Saves the exam to the database
	 * 
	 * @return the result string.
	 */
	public String save(){
		examService.saveOrUpdateExam(exam.getId(), meetingName,lecturerId,roomIds,studentGroupIds,  numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}	
	
	/**
	 * Displays the selected exam in the exam form.
	 *
	 * @return the string
	 */
	public String load(){
		exam = examService.loadExam(examId);
		return SUCCESS;
	}
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<Long> getStudentGroupIds() {
		return studentGroupIds;
	}

	public void setStudentGroupIds(List<Long> studentGroupIds) {
		this.studentGroupIds = studentGroupIds;
	}
	
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	
		
	
	
	
}
