package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.service.CourseNotFoundException;
import de.nak.roommgmt.service.CourseService;

/**
 * Update room action.
 *
 * @author Stephan Anft
 */
public class UpdateCourseAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public UpdateCourseAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Vorlesung aktualisieren";
	}

	/**
	 * Updates a course.
	 *
	 * @throws CourseNotFoundException if the course was not found.
	 */
	public void execute() throws CourseNotFoundException {
		System.out.println("Die ID der Vorlesung bitte:");
		long id = ConsoleUtil.readInt();
		System.out.println("Neuer Dozent:");
		String lecturer = ConsoleUtil.readString();
		System.out.println("Neuer Titel:");
		String title = ConsoleUtil.readString();
		try {
			new CourseService().updateCourse(id, lecturer, title);
			System.out.println("Vorlesung wurde aktualisiert.");
		}
		catch (CourseNotFoundException ex) {
			System.out.printf("Vorlesung mit der ID %1$d wurde nicht gefunden.%n", id);
			throw ex;
		}
	}
}
