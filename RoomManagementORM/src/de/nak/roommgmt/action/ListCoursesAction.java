package de.nak.roommgmt.action;

import de.nak.roommgmt.model.Course;
import de.nak.roommgmt.service.CourseService;

import java.util.List;

import org.springframework.context.ApplicationContext;

/**
 * List courses action.
 *
 * @author Stephan Anft
 */
public class ListCoursesAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public ListCoursesAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Alle Vorlesungen ausgeben";
	}

	/**
	 * List all courses.
	 */
	public void execute() {
		final List<Course> courses = new CourseService().listCourses();
		for (Course course : courses) {
			System.out.println("---------------------------");
			System.out.printf("Vorlesung mit ID %1$d:%n", course.getId());
			System.out.printf("Fachrichtung: %1$s, Nummer: %2$d, Dozent: %3$s, Titel: %4$s%n", course.getFieldOfStudy(), course.getNumber(), course.getLecturer(), course.getTitle());
		}
		System.out.println("-----------ENDE------------");
	}
}
