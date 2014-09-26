package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.service.CourseAlreadyPresentException;
import de.nak.roommgmt.service.CourseService;

/**
 * Create course action.
 *
 * @author Stephan Anft
 */
public class CreateCourseAction extends Action {
		
	/**
	 * {@inheritDoc}
	 */
	public CreateCourseAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Vorlesung anlegen";
	}

	/**
	 * Creates a new course.
	 *
	 * @throws CourseAlreadyPresentException if the course is already present
	 * in the database.
	 */
	public void execute() throws CourseAlreadyPresentException {
		System.out.println("Eine Fachrichtung bitte:");
		String fieldOfStudy = ConsoleUtil.readString();
		System.out.println("Eine Vorlesungsnummer bitte:");
		int number = ConsoleUtil.readInt();
		System.out.println("Der Name des Dozenten bitte:");
		String lecturer = ConsoleUtil.readString();
		System.out.println("Welchen Titel hat die Vorlesung:");
		String title = ConsoleUtil.readString();
		try {
			new CourseService().createCourse(fieldOfStudy, number, lecturer, title);
			System.out.println("Die Vorlesung wurde erfolgreich angelegt.");
		}
		catch (CourseAlreadyPresentException ex) {
			System.out.println("Vorlesung ist bereits vorhanden.");
			throw ex;
		}
	}
}
