package de.nak.roommgmt.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import de.nak.roommgmt.HibernateUtil;
import de.nak.roommgmt.model.Course;
import de.nak.roommgmt.model.Lecture;
import de.nak.roommgmt.model.Room;

/**
 * The lecture service that manages all business functionality.
 * @author Stephan Anft
 */
public class LectureService {
	/**
	 * The current Hibernate session.
	 */
	private final Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	/**
	 * Creates and stores a new lecture entity.
	 * @param begin The begin of the lecture.
	 * @param end The end of the lecture.
	 * @param courseId The id of the course entity.
	 * @param roomId The id of the room entity.
	 * @throws CourseNotFoundException if the given course is not found.
	 * @throws RoomNotFoundException if the given room is not found.
	 */
	public void createLecture(Date begin, Date end, Long courseId, Long roomId) throws CourseNotFoundException, RoomNotFoundException {
		// Get the course entity
		Course course = (Course)session.get(Course.class, courseId);
		if (course == null) {
			throw new CourseNotFoundException();
		}
		// Get the room entity
		Room room = (Room)session.get(Room.class, roomId);
		if (room == null) {
			throw new RoomNotFoundException();
		}
		// Create a new lecture
		Lecture lecture = new Lecture();
		lecture.setBegin(begin);
		lecture.setEnd(end);
		// Associate lecture to course
		course.associateLecture(lecture);
		// Associate lecture to room
		room.associateLecture(lecture);
		// Save the entity
		session.save(lecture);
	}
	
	/**
	 * Lists all lectures currently stored in the database.
	 * @return a list of lectures.
	 */
	@SuppressWarnings("unchecked")
	public List<Lecture> listLectures() {
		return (List<Lecture>)session.createQuery("from Lecture").list();
	}
	
	/**
	 * Deletes the given lecture entity.
	 * @param id The identifier.
	 * @throws LectureNotFoundException if no lecture was found using
	 * the given identifier.
	 */
	public void deleteLecture(Long id) throws LectureNotFoundException {
		Lecture lecture = (Lecture)session.get(Lecture.class, id);
		if (lecture == null) {
			throw new LectureNotFoundException();
		}
		session.delete(lecture);
	}
}
