/**
 * 
 */
package de.nak.stundenplandb.action;

import de.nak.stundenplandb.model.Exam;


/**
 * @author Arne Roever
 *
 */
public class ExamAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6938348041955775951L;

	/** The exam. */
	private Exam exam;	
	
	public String save(){
		//meetingService.saveExam(exam, numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}	
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	
		
	
	
	
}
