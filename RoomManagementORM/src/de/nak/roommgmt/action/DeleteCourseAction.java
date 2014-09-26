package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.service.CourseNotFoundException;
import de.nak.roommgmt.service.CourseService;

/**
 * Delete course action.
 *
 * @author Stephan Anft
 */
public class DeleteCourseAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public DeleteCourseAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Vorlesung löschen";
	}

	/**
	 * Deletes a course.
	 *
	 * @throws CourseNotFoundException if the course could not be found.
	 */
	public void execute() throws CourseNotFoundException {
		System.out.println("Die ID der Vorlesung bitte:");
		long id = ConsoleUtil.readInt();
		try {
			new CourseService().deleteCourse(id);
			System.out.println("Vorlesung wurde gelöscht.");
		}
		catch (CourseNotFoundException ex) {
			System.out.printf("Vorlesung mit der ID %1$d wurde nicht gefunden.%n", id);
			throw ex;
		}
	}
}
