package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.service.LectureNotFoundException;
import de.nak.roommgmt.service.LectureService;

/**
 * Delete lecture action.
 *
 * @author Stephan Anft
 */
public class DeleteLectureAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public DeleteLectureAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Vorlesungsveranstaltung löschen";
	}

	/**
	 * Deletes a lecture.
	 *
	 * @throws LectureNotFoundException if the lecture was not found.
	 */
	public void execute() throws LectureNotFoundException {
		System.out.println("Die ID der Veranstaltung bitte:");
		long id = ConsoleUtil.readInt();
		try {
			new LectureService().deleteLecture(id);
			System.out.println("Veranstaltung wurde gelöscht.");
		}
		catch (LectureNotFoundException ex) {
			System.out.printf("Veranstaltung mit der ID %1$d wurde nicht gefunden.%n", id);
			throw ex;
		}
	}
}
