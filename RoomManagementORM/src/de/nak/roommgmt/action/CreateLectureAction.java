package de.nak.roommgmt.action;

import java.util.Date;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.service.CourseNotFoundException;
import de.nak.roommgmt.service.LectureService;
import de.nak.roommgmt.service.RoomNotFoundException;

/**
 * Create lecture action.
 *
 * @author Stephan Anft
 */
public class CreateLectureAction extends Action {
	
	/**
	 * {@inheritDoc}
	 */
	public CreateLectureAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Vorlesungsveranstaltung anlegen";
	}

	/**
	 * Creates a new lecture.
	 *
	 * @throws CourseNotFoundException if the given course is not existent
	 * and cannot be assigned to the new lecture.
	 * @throws RoomNotFoundException if the given room is not existent
	 * and cannot be assigned to the new lecture.
	 */
	public void execute() throws CourseNotFoundException, RoomNotFoundException {
		System.out.println("Die ID der Vorlesung bitte:");
		long courseId = ConsoleUtil.readInt();
		System.out.println("Die ID des Raumes bitte:");
		long roomId = ConsoleUtil.readInt();
		System.out.println("Den Beginn der Veranstaltung bitte:");
		Date begin = ConsoleUtil.readDate();
		System.out.println("Das Ende der Veranstaltung bitte:");
		Date end = ConsoleUtil.readDate();
		try {
			new LectureService().createLecture(begin, end, courseId, roomId);
			System.out.println("Die Vorlesungsveranstaltung wurde erfolgreich angelegt.");
		}
		catch (CourseNotFoundException ex) {
			System.out.printf("Vorlesung mit der ID %1$d wurde nicht gefunden.%n", courseId);
			throw ex;
		}
		catch (RoomNotFoundException ex) {
			System.out.printf("Raum mit the ID %1$d wurde nicht gefunden.%n", roomId);
			throw ex;
		}
	}
}
