/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import de.nak.stundenplandb.dao.CohortDAO;
import de.nak.stundenplandb.dao.ElectiveDAO;
import de.nak.stundenplandb.model.Cohort;
import de.nak.stundenplandb.model.ECollisionType;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Elective;

/**
 * Implementation of the ElectiveService
 * 
 * @author Fabian Kolossa
 *
 */
public class ElectiveServiceImpl implements ElectiveService {
	private MeetingService meetingService;
	private ElectiveDAO electiveDAO;
	private CohortDAO cohortDAO;
	private RoomService roomService;

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
		meetingService
				.fillMeeting(elective, meetingName, lecturerId, roomIds,
						numberOfAppointments, startDate, endDate,
						EMeetingType.ELECTIVE);

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

	/**
	 * Inject the MeetingService
	 * 
	 * @param meetingService
	 */
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	/**
	 * Inject the ElectiveDAO
	 * 
	 * @param electiveDAO
	 */
	public void setElectiveDAO(ElectiveDAO electiveDAO) {
		this.electiveDAO = electiveDAO;
	}

	/**
	 * Inject the CohortDAO
	 * 
	 * @param cohortDAO
	 */
	public void setCohortDAO(CohortDAO cohortDAO) {
		this.cohortDAO = cohortDAO;
	}

	/**
	 * Inject the RoomService
	 * 
	 * @param roomService
	 */
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	@Override
	public boolean checkCollisionsForElective(Long id, Long lecturerId,
			List<Long> roomIds, Long cohortId, int numberOfAppointments,
			Date startDate, Date endDate) {
		// TODO Kollisionsprüfung implementieren
		return true;
	}

	@Override
	public List<Elective> loadAllElectives() {
		List<Elective> allElectives = electiveDAO.loadAll();
		initializeElectives(allElectives);
		return allElectives;
	}

	@Override
	public void deleteElective(Long id) {
		electiveDAO.delete(this.loadElective(id));
	}

	@Override
	public Elective loadElective(Long id) {
		Elective elective = electiveDAO.load(id);
		initializeElective(elective);
		return elective;
	}

	// TODO diese Mthoden evtl zusammenfassen bei allen Meeting-Subtypes
	private void initializeElectives(List<Elective> electives) {
		for (Elective elective : electives) {
			initializeElective(elective);
		}
	}

	private void initializeElective(Elective elective) {
		Hibernate.initialize(elective.getLecturer());
		Hibernate.initialize(elective.getRooms());
		Hibernate.initialize(elective.getAppointments());
	}

	@Override
	public List<ECollisionType> getCollisions(Long id, Long lecturerId,
			List<Long> roomIds, Long cohortId, int numberOfAppointments,
			Date startDate, Date endDate) {
		// The set with all found collionsTypes
		Set<ECollisionType> collisionsSet = new HashSet<ECollisionType>();
		// TODO Kollisionsprüfung einbauen
		// Check for RoomCollisions
		for (Long roomId : roomIds) {
			if (this.roomService.isOccupied(roomId, startDate, endDate)) {
				collisionsSet.add(ECollisionType.ROOM_OCCUPIED);
			}
		}
		// returns a List of all found collsionTypes
		return new ArrayList<ECollisionType>(collisionsSet);
	}
}
