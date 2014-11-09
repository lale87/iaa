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

import de.nak.stundenplandb.dao.SeminarDAO;
import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.ECollisionType;
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
	private RoomService roomService;
	private LecturerService lecturerService;

	@Override
	public void saveOrUpdateSeminar(Long id, String meetingName,
			Long lecturerId, List<Long> roomIds, int numberOfAppointments,
			Date startDate, Date endDate) {

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

	/**
	 * Inject the MeetingService
	 * 
	 * @param meetingService
	 */
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	/**
	 * Inject the SeminarDAO
	 * 
	 * @param seminarDAO
	 */
	public void setSeminarDAO(SeminarDAO seminarDAO) {
		this.seminarDAO = seminarDAO;
	}

	/**
	 * Inject the RoomService
	 * 
	 * @param roomService
	 */
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	/**
	 * Inject the LecturerService
	 * 
	 * @param lecturerService
	 */
	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
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

	/**
	 * Initialzies a list of Seminars
	 * 
	 * @param seminars
	 */
	private void initializeSeminars(List<Seminar> seminars) {
		for (Seminar seminar : seminars) {
			initializeSeminar(seminar);
		}
	}

	/**
	 * Initializes a saminar
	 * 
	 * @param seminar
	 */
	private void initializeSeminar(Seminar seminar) {
		Hibernate.initialize(seminar.getLecturer());
		Hibernate.initialize(seminar.getRooms());
		Hibernate.initialize(seminar.getAppointments());
	}

	@Override
	public List<ECollisionType> getCollisions(Long id, Long lecturerId,
			List<Long> roomIds, int numberOfAppointments, Date startDate,
			Date endDate) {
		if (id != null) {
			return new ArrayList<ECollisionType>();
		}
		// The set with all found collionsTypes
		Set<ECollisionType> collisionsSet = new HashSet<ECollisionType>();

		// generate appointments
		Set<Appointment> appointments = meetingService.createAppointments(
				numberOfAppointments, startDate, endDate);

		for (Appointment appointment : appointments) {
			// set start and end date
			Date start = appointment.getStart();
			Date end = appointment.getEnd();

			// Check for RoomCollisions
			for (Long roomId : roomIds) {
				if (this.roomService.isOccupied(roomId, start, end)) {
					collisionsSet.add(ECollisionType.ROOM_OCCUPIED);
				}
			}
			// Check for LecturerCollisions
			if (lecturerService.isBusy(lecturerId, start, end)) {
				collisionsSet.add(ECollisionType.LECTURER_BUSY);
			}
		}

		// returns a List of all found collsionTypes
		return new ArrayList<ECollisionType>(collisionsSet);
	}
}
