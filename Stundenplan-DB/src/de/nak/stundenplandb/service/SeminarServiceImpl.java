/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import de.nak.stundenplandb.dao.SeminarDAO;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Seminar;

/**
 * Implementation of the SeminarService
 * 
 * @author Fabian Kolossa
 *
 */
public class SeminarServiceImpl implements SeminarService {
	private MeetingService meetingService;
	private SeminarDAO seminarDAO;

	@Override
	public void saveOrUpdateSeminar(Long id, String meetingName,
			Long lecturerId, List<Long> roomIds, int numberOfAppointments,
			Date startDate, Date endDate) {
		// TODO FK: Fehlerbehandlung (Objekt zu ID nicht gefunden)

		// update? (null if seminar not exists yet)
		Seminar seminar = seminarDAO.load(id);
		if (seminar == null) {
			seminar = new Seminar();
		}

		// set meeting attributes
		meetingService.fillMeeting(seminar, meetingName, lecturerId, roomIds,
				numberOfAppointments, startDate, endDate, EMeetingType.SEMINAR);

		// set seminar-specific attributes
		// nothing to set

		// save seminar
		seminarDAO.save(seminar);
	};

	@Override
	public void deleteSeminar(Seminar seminar) {
		seminarDAO.delete(seminar);
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public void setSeminarDAO(SeminarDAO seminarDAO) {
		this.seminarDAO = seminarDAO;
	}

	@Override
	public boolean checkCollisionsForSeminar(Long id, Long lecturerId,
			List<Long> roomIds, int numberOfAppointments, Date startDate,
			Date endDate) {
		// TODO Kollisionsprüfung implementieren
		return true;
	}

	@Override
	public List<Seminar> loadAllSeminars() {
		List<Seminar> allSeminars = seminarDAO.loadAll();
		initializeSeminars(allSeminars);
		return allSeminars;
	}

	@Override
	public void deleteSeminar(Long id) {
		seminarDAO.delete(this.loadSeminar(id));
	}

	@Override
	public Seminar loadSeminar(Long id) {
		Seminar seminar = seminarDAO.load(id);
		initializeSeminar(seminar);
		return seminar;
	}

	// TODO diese Mthoden evtl zusammenfassen bei allen Meeting-Subtypes
	private void initializeSeminars(List<Seminar> seminars) {
		for (Seminar seminar : seminars) {
			initializeSeminar(seminar);
		}
	}

	private void initializeSeminar(Seminar seminar) {
		Hibernate.initialize(seminar.getLecturer());
		Hibernate.initialize(seminar.getRooms());
		Hibernate.initialize(seminar.getAppointments());
	}
}
