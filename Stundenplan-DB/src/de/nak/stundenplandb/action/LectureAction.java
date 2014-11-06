/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.service.LectureService;

/**
 * Action for a single Lecture.
 *
 * @author Arne Roever
 */
public class LectureAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5470788664512099858L;
	
	/** The student group id selected by the user */
	private Long studentGroupId; 
	
	/** The currently selected lecture id. */
	private Long lectureId;
	
	/** The current lecture. */
	private Lecture lecture;
	
	/** The lecture service. */
	private LectureService lectureService;

	/**
	 * Saves or updates the lecture to the database when there is no
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
	 * Saves the lecture to the database without checking for collisions.
	 *
	 * @return the result string
	 */
	public String save(){
		lectureService.saveOrUpdateLecture(lecture.getId(), meetingName, lecturerId,
				roomIds, studentGroupId, numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}
	
	/**
	 * Deletes the lecture from the database
	 *
	 * @return the result string
	 */
	@SkipValidation
	public String delete(){
		if (lectureId != null) {
			lectureService.deleteLecture(lectureId);
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * Displays the selected lecture in the lecture form.
	 *
	 * @return the string
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String load(){
		if (lectureId != null) {
			lecture = lectureService.loadLecture(lectureId);
			
			meetingName = lecture.getName();
			lecturerId = lecture.getLecturer().getId();	
			roomIds = (List<Long>) CollectionUtils.collect(lecture.getRooms(), 
                    new BeanToPropertyValueTransformer("id"));
			studentGroupId = lecture.getStudentGroup().getId();
			numberOfAppointments = lecture.getNumberOfAppointments();
			startDate = lecture.getAppointments().get(0).getStart();
			endDate = lecture.getAppointments().get(0).getEnd();
			return SUCCESS;
		}
		return ERROR;		
	}
	
	/**
	 * Displays available rooms.	 
	 *
	 * @return the result string
	 */
	@SkipValidation
	public String showAvailableRooms(){
		if (startDate == null) {
			addFieldError("startDate", getText("msg.validator.required"));
		}
		if (endDate == null) {
			addFieldError("endDate", getText("msg.validator.required"));
		}
		if (startDate != null && endDate != null){
			if (startDate.after(endDate)){
				addFieldError("startDate", getText("msg.validator.inconsistentDate"));
			}
		}		
		return SUCCESS;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public Long getStudentGroupId() {
		return studentGroupId;
	}

	public void setStudentGroupId(Long studentGroupId) {
		this.studentGroupId = studentGroupId;
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
}
