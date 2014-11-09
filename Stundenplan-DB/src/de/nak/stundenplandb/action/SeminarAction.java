/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.exception.ConstraintViolationException;

import de.nak.stundenplandb.model.Seminar;
import de.nak.stundenplandb.service.SeminarService;

/**
 * Action for a single Seminar
 * 
 * @author Arne Roever
 *
 */
public class SeminarAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8572676587114810892L;
	
	/** The currently selected seminar id. */
	private Long seminarId;
	
	/** The current seminar. */
	private Seminar seminar;
	
	/** The seminar service. */
	private SeminarService seminarService;

	/**
	 * Saves or updates the seminar to the database when there is no
	 * collision or otherwise displays an error message.
	 * 
	 * @return the result string.
	 */
	public String checkAndSave(){		
		collisionList = seminarService.getCollisions(seminar.getId(), lecturerId, roomIds, numberOfAppointments, startDate, endDate);
		if (collisionList.isEmpty()) {			
			save();		
			return SUCCESS;
		}
				
		isCollided = true;		
		showCollisionErrors(collisionList);		
		return INPUT;	
	}
	
	@Override
	/**
	 * Saves the seminar to the database or
	 * updates the seminar in the database.
	 * 
	 * @result the result string
	 */
	public String save() {
		try {
			seminarService.saveOrUpdateSeminar(seminar.getId(), meetingName,lecturerId,roomIds, numberOfAppointments, startDate, endDate);
		} catch (ConstraintViolationException e) {
			showConstraintError();
			return INPUT;
		}
		
		return SUCCESS;
	}
	
	/**
	 * Displays the selected seminar in the seminar form
	 *
	 * @return the result string
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String load(){
		if ( seminarId != null) {
			seminar = seminarService.loadSeminar(seminarId);
			
			meetingName = seminar.getName();
			lecturerId = seminar.getLecturer().getId();	
			roomIds = (List<Long>) CollectionUtils.collect(seminar.getRooms(), 
                    new BeanToPropertyValueTransformer("id"));					
			numberOfAppointments = seminar.getNumberOfAppointments();
			startDate = seminar.getAppointments().get(0).getStart();
			endDate = seminar.getAppointments().get(0).getEnd();			
			
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * Deletes the seminar from the database
	 *
	 * @return the result string
	 */
	@SkipValidation
	public String delete(){
		if (seminarId != null) {
			seminarService.deleteSeminar(seminarId);	
			return SUCCESS;
		}
		return ERROR;
	}
	
	public Seminar getSeminar() {
		return seminar;
	}

	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}
	
	public void setSeminarService(SeminarService seminarService) {
		this.seminarService = seminarService;
	}
	public Long getSeminarId() {
		return seminarId;
	}
	public void setSeminarId(Long seminarId) {
		this.seminarId = seminarId;
	}


}
