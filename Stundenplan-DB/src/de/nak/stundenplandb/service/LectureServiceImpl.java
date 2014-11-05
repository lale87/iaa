/**
 * 
 */
package de.nak.stundenplandb.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import de.nak.stundenplandb.dao.LectureDAO;
import de.nak.stundenplandb.dao.StudentGroupDAO;
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

	@Override
	public void saveOrUpdateLecture(Long id, String meetingName,
			Long lecturerId, List<Long> roomIds, Long studentGroupId,
			int numberOfAppointments, Date startDate, Date endDate) {
		// TODO FK: Fehlerbehandlung (Objekt zu ID nicht gefunden)

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

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}

	public void setStudentGroupDAO(StudentGroupDAO studentGroupDAO) {
		this.studentGroupDAO = studentGroupDAO;
	}
	
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	@Override
	public boolean CheckCollisionsForLecture(Long id, Long lecturerId,
			List<Long> roomIds, Long studentGroupId, int numberOfAppointments,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return true;
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
		return lectureDAO.load(id);
	}
	
	//TODO diese Mthoden evtl zusammenfassen bei allen Meeting-Subtypes
	private void initializeLectures(List<Lecture> lectures) {
		for (Lecture lecture : lectures) {
			initializeLecture(lecture);
		}
	}

	private void initializeLecture(Lecture lecture) {
		Hibernate.initialize(lecture.getLecturer());
		Hibernate.initialize(lecture.getRooms());
		Hibernate.initialize(lecture.getAppointments());
	}

	@Override
	public boolean isPossible(Long id, Long lecturerId, List<Long> roomIds,
			Long studentGroupId, int numberOfAppointments, Date startDate,
			Date endDate) {
		
		//Check for RoomCollisions
		for (Long roomId : roomIds) {
			if(this.roomService.isOccupied(roomId, startDate, endDate)){
				return false;
			};
		}
		return true;
	}
}
