/**
 * 
 */
package de.nak.stundenplandb.action;

import java.util.List;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.service.ElectiveService;

/**
 * Action for a single Elective
 * 
 * @author Arne Roever *
 */
public class ElectiveAction extends MeetingAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5802592208250231904L;
	
	/** The currently selected elective id. */
	private Long electiveId;
	
	/** The current elective. */
	private Elective elective;	
	
	/** The cohort id selected by the user. */
	private Long cohortId;
	
	/** The elective service. */
	private ElectiveService electiveService;

	/**
	 * Saves or updates the elective to the database when there is no
	 * collision or otherwise displays error message.
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
		
		return "collision";		
	}

	/**
	 * Saves the elective to the database
	 *  
	 *  @return the result string.
	 */
	@Override
	public String save() {
		electiveService.saveOrUpdateElective(elective.getId(),meetingName,lecturerId,roomIds,cohortId,  numberOfAppointments, startDate, endDate);
		return SUCCESS;
	}
	
	/**
	 * Deletes the elective from the database
	 *
	 * @return the result string
	 */
	@SkipValidation
	public String delete(){
		if ( electiveId != null) {
			electiveService.deleteElective(electiveId);
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * Displays the elective in the elective form.
	 *
	 * @return the result string
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String load(){
		if ( electiveId != null) {
			elective = electiveService.loadElective(electiveId);
			
			meetingName = elective.getName();
			lecturerId = elective.getLecturer().getId();	
			roomIds = (List<Long>) CollectionUtils.collect(elective.getRooms(), 
                    new BeanToPropertyValueTransformer("id"));					
			cohortId = elective.getCohort().getId();
			numberOfAppointments = elective.getNumberOfAppointments();
			startDate = elective.getAppointments().get(0).getStart();
			endDate = elective.getAppointments().get(0).getEnd();			
			
			return SUCCESS;
		}
		return ERROR;
	}
	
	public Elective getElective() {
		return elective;
	}

	public void setElective(Elective elective) {
		this.elective = elective;
	}
	
	public Long getCohortId() {
		return cohortId;
	}

	public void setCohortId(Long cohortId) {
		this.cohortId = cohortId;
	}

	public void setElectiveService(ElectiveService electiveService) {
		this.electiveService = electiveService;
	}

	public Long getElectiveId() {
		return electiveId;
	}

	public void setElectiveId(Long electiveId) {
		this.electiveId = electiveId;
	}
	
}
