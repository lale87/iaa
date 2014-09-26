package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.model.Course;
import de.nak.roommgmt.service.CourseService;
import de.nak.roommgmt.service.CourseNotFoundException;

/**
 * Show single course action.
 *
 * @author Stephan Anft
 */
public class ShowCourseAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public ShowCourseAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Vorlesung anzeigen";
	}

	/**
	 * Shows a single course.
	 *
	 * @throws CourseNotFoundException if the course was not found.
	 */
	public void execute() throws CourseNotFoundException {
		System.out.println("Die ID der Vorlesung bitte:");
		long id = ConsoleUtil.readInt();
		try {
			Course course = new CourseService().showCourse(id);
			System.out.println("---------------------------");
			System.out.printf("Vorlesung mit ID %1$d:%n", course.getId());
			System.out.printf("Fachrichtung: %1$s, Nummer: %2$d, Dozent: %3$s, Titel: %4$s%n", course.getFieldOfStudy(), course.getNumber(), course.getLecturer(), course.getTitle());
			System.out.println("-----------ENDE------------");
		}
		catch (CourseNotFoundException ex) {
			System.out.printf("Vorlesung mit der ID %1$d wurde nicht gefunden.%n", id);
			throw ex;
		}
	}
}
