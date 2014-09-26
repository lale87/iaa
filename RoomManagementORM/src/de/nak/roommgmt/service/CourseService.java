package de.nak.roommgmt.service;

import java.util.List;

import de.nak.roommgmt.HibernateUtil;
import de.nak.roommgmt.model.Course;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 * The course service that manages all business functionality.
 *
 * @author Stephan Anft
 */
public class CourseService {
	/**
	 * The current Hibernate session.
	 */
	private final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	/**
	 * Creates a new course in the database.
	 * @param fieldOfStudy The field of study.
	 * @param number The course number.
	 * @param lecturer The lecturer's name.
	 * @param title The title.
	 * @throws CourseAlreadyPresentException if the course already exists in the database.
	 */
	public void createCourse(String fieldOfStudy, int number, String lecturer, String title) throws CourseAlreadyPresentException {
		// Create course object
		Course course = new Course();
		course.setFieldOfStudy(fieldOfStudy);
		course.setNumber(number);
		course.setLecturer(lecturer);
		course.setTitle(title);
		try {
			session.save(course);
		}
		catch (ConstraintViolationException ex) {
			throw new CourseAlreadyPresentException();
		}
	}
	
	/**
	 * List all courses currently stored in the database.
	 *
	 * @return a list of course entities. If no course was found an empty list is
	 *         returned.
	 */
	@SuppressWarnings("unchecked")
	public List<Course> listCourses() {
		return (List<Course>) session.createQuery("from Course").list();
	}

	/**
	 * Returns the course identified by the given id.
	 *
	 * @param id The identifier.
	 * @return the found entity.
	 * @throws CourseNotFoundException if no room could be found for the given id.
	 */
	public Course showCourse(Long id) throws CourseNotFoundException {
		Course course = (Course) session.get(Course.class, id);
		if (course == null) {
			throw new CourseNotFoundException();
		}
		return course;
	}

	/**
	 * Updates a course entity and stores the changes into the database.
	 *
	 * @param id The identifier.
	 * @param lecturer The lecturer.
	 * @param title The title.
	 * @throws CourseNotFoundException if no course could be found for the given id.
	 */
	public void updateCourse(Long id, String lecturer, String title) throws CourseNotFoundException {
		Course course = (Course) session.get(Course.class, id);
		if (course == null) {
			throw new CourseNotFoundException();
		}
		course.setLecturer(lecturer);
		course.setTitle(title);
	}

	/**
	 * Deletes the course with the given id.
	 *
	 * @param id The identifier.
	 * @throws CourseNotFoundException if no course could be fount for the given id.
	 */
	public void deleteCourse(Long id) throws CourseNotFoundException {
		Course course = (Course) session.get(Course.class, id);
		if (course == null) {
			throw new CourseNotFoundException();
		}
		session.delete(course);
	}

}
