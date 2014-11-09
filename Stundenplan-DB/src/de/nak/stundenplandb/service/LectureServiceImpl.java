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

import de.nak.stundenplandb.dao.LectureDAO;
import de.nak.stundenplandb.dao.StudentGroupDAO;
import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.ECollisionType;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation of the LectureService
 * 
 * @author Fabian Kolossa
 *
 */
public class LectureServiceImpl implements LectureService {
	private MeetingService meetingService;
	private LectureDAO lectureDAO;
	private StudentGroupDAO studentGroupDAO;
	private RoomService roomService;
	private StudentGroupService studentGroupService;
	private LecturerService lecturerService;

	@Override
	public void saveOrUpdateLecture(Long id, String meetingName,
			Long lecturerId, List<Long> roomIds, Long studentGroupId,
			int numberOfAppointments, Date startDate, Date endDate) {

		// update? (null if lecture not exists yet)
		Lecture lecture = lectureDAO.load(id);
		if (lecture == null) {
			lecture = new Lecture();
		}

		// set meeting attributes
		meetingService.fillMeeting(lecture, meetingName, lecturerId, roomIds,
				numberOfAppointments, startDate, endDate, EMeetingType.LECTURE);

		// set lecturer-specific attributes
		StudentGroup studentGroup = studentGroupDAO.load(studentGroupId);
		lecture.setStudentGroup(studentGroup);

		// save lecture
		lectureDAO.save(lecture);
	};

	@Override
	public void deleteLecture(Lecture lecture) {
		lectureDAO.delete(lecture);
	}

	/**
	 * Injects the MeetingService
	 * 
	 * @param meetingService
	 */
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	/**
	 * Injects the lectureDAO
	 * 
	 * @param lectureDAO
	 */
	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}

	/**
	 * Injects the studentGroupDAO
	 * 
	 * @param studentGroupDAO
	 */
	public void setStudentGroupDAO(StudentGroupDAO studentGroupDAO) {
		this.studentGroupDAO = studentGroupDAO;
	}

	/**
	 * Injects the roomServiceDAO
	 * 
	 * @param roomService
	 */
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	/**
	 * Injects the studentGroupService
	 * 
	 * @param studentGroupService
	 */
	public void setStudentGroupService(StudentGroupService studentGroupService) {
		this.studentGroupService = studentGroupService;
	}

	/**
	 * Injects the lectureService
	 * 
	 * @param lecturerService
	 */
	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

	@Override
	public List<Lecture> loadAllLectures() {
		List<Lecture> allLectures = lectureDAO.loadAll();
		initializeLectures(allLectures);
		return allLectures;
	}

	@Override
	public void deleteLecture(Long id) {
		lectureDAO.delete(this.loadLecture(id));
	}

	@Override
	public Lecture loadLecture(Long id) {
		Lecture lecture = lectureDAO.load(id);
		initializeLecture(lecture);
		return lecture;
	}

	/**
	 * Initializes a lift of Lectures
	 * 
	 * @param lectures
	 */
	private void initializeLectures(List<Lecture> lectures) {
		for (Lecture lecture : lectures) {
			initializeLecture(lecture);
		}
	}

	/**
	 * Initiliazies a Lecture
	 * 
	 * @param lecture
	 */
	private void initializeLecture(Lecture lecture) {
		Hibernate.initialize(lecture.getLecturer());
		Hibernate.initialize(lecture.getRooms());
		Hibernate.initialize(lecture.getAppointments());
	}

	@Override
	public List<ECollisionType> getCollisions(Long id, Long lecturerId,
			List<Long> roomIds, Long studentGroupId, int numberOfAppointments,
			Date startDate, Date endDate) {
		// Set with all found collisions
		Set<ECollisionType> collisionsSet = new HashSet<ECollisionType>();
		
		// generate appointments
		Set<Appointment> appointments = meetingService.createAppointments(
				numberOfAppointments, startDate, endDate);
		
		for (Appointment appointment : appointments) {
			// set start and end date
			Date start = appointment.getStart();
			Date end = appointment.getEnd();
			
			for (Long roomId : roomIds) {
				// Check for RoomCollisions
				if (this.roomService.isOccupied(roomId, start, end)) {
					collisionsSet.add(ECollisionType.ROOM_OCCUPIED);
				}
				// Check for RoomSizeCollisions
				if (this.roomService.hasEnoughSeats(roomId, studentGroupId)) {
					collisionsSet.add(ECollisionType.ROOM_TOO_SMALL);
				}
			}
			// Check for LecturerCollisions
			if (lecturerService.isBusy(lecturerId, start, end)) {
				collisionsSet.add(ECollisionType.LECTURER_BUSY);
			}
			// Check for StudentGroupCollisions
			if (studentGroupService.isBusy(studentGroupId, start, end)) {
				collisionsSet.add(ECollisionType.STUDENTGROUP_BUSY);
			}
		}

		// Returns a List with all found collisions
		return new ArrayList<ECollisionType>(collisionsSet);
	}
}
