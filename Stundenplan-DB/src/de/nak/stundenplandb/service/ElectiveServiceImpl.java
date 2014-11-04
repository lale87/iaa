/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.dao.CohortDAO;
import de.nak.stundenplandb.dao.ElectiveDAO;
import de.nak.stundenplandb.model.Cohort;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Elective;

/**
 * TODO FK: comment for ElectiveServiceImpl
 * @author Fabian Kolossa
 *
 */
public class ElectiveServiceImpl implements ElectiveService {
	private MeetingService meetingService;
	private ElectiveDAO electiveDAO;
	private CohortDAO cohortDAO;
	
	@Override
	public void saveOrUpdateElective(Long id, String meetingName,
			Long lecturerId, List<Long> roomIds, Long cohortId,
			int numberOfAppointments, Date startDate, Date endDate) {
		// TODO FK: Fehlerbehandlung (Objekt zu ID nicht gefunden)
		
		// update? (null if elective not exists yet)
		Elective elective = electiveDAO.load(id);
		if (elective == null) {
			elective = new Elective();
		}
		
		// set meeting attributes
		meetingService.fillMeeting(elective, meetingName, lecturerId, roomIds,
				numberOfAppointments, startDate, endDate, EMeetingType.ELECTIVE);
		
		// set elective-specific attributes
		Cohort cohort = cohortDAO.load(cohortId);
		elective.setCohort(cohort);
		
		// save elective
		electiveDAO.save(elective);
	};

	@Override
	public void deleteElective(Elective elective) {
		electiveDAO.delete(elective);
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public void setElectiveDAO(ElectiveDAO electiveDAO) {
		this.electiveDAO = electiveDAO;
	}

	public void setCohortDAO(CohortDAO cohortDAO) {
		this.cohortDAO = cohortDAO;
	}

	@Override
	public boolean checkCollisionsForElective(Long id, 
			Long lecturerId, List<Long> roomIds, Long cohortId,
			int numberOfAppointments, Date startDate, Date endDate) {
		// TODO Kollisionsprüfung implementieren
		return true;
	}

	@Override
	public List<Elective> loadAllElectives() {
		return electiveDAO.loadAll();
	}
}
