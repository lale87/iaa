/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.service.ExamService;


/**
 * @author Arne Roever
 *
 */
public class ExamAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6938348041955775951L;

	/** The exam. */
	private Exam exam;

	/** The selected studentgroup id. */
	private List<Long> studentGroupIds; 
	
	/** The exam service. */
	private ExamService examService;

	public String save(){
		examService.saveOrUpdateExam(exam.getId(), meetingName,lecturerId,roomIds,studentGroupIds,  numberOfAppointments, startDate, endDate);
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

	
		
	
	
	
}
