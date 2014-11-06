/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

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
	 * Saves or updates the exam to the database when there is no
	 * collision. 
	 * 
	 * @return the result string.
	 */
	public String checkAndSave(){		
		// Anstelle von false kommt die isPossible() Methode zum Kollisionscheck
		if (false) {			
			save();
			return SUCCESS;
		}
				
		isCollided = true;		
		addActionError(getText("msg.error.collision"));		
		return INPUT;	
	}

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
	 * Deletes the exam from the database
	 *
	 * @return the result string
	 */
	@SkipValidation
	public String delete(){
		if( examId != null){
			examService.deleteExam(examId);		
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * Displays the selected exam in the exam form.
	 *
	 * @return the string
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String load(){
		if( examId != null){
			exam = examService.loadExam(examId);	
			
			meetingName = exam.getName();
			lecturerId = exam.getLecturer().getId();	
			roomIds = (List<Long>) CollectionUtils.collect(exam.getRooms(), 
                    new BeanToPropertyValueTransformer("id"));
			studentGroupIds = (List<Long>) CollectionUtils.collect(exam.getStudentGroups(), 
                    new BeanToPropertyValueTransformer("id"));			
			numberOfAppointments = exam.getNumberOfAppointments();
			startDate = exam.getAppointments().get(0).getStart();
			endDate = exam.getAppointments().get(0).getEnd();
			
			return SUCCESS;
		}
		return ERROR;
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
