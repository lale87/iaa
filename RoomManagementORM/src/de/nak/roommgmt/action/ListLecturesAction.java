package de.nak.roommgmt.action;

import de.nak.roommgmt.model.Lecture;
import de.nak.roommgmt.service.LectureService;

import java.util.List;

import org.springframework.context.ApplicationContext;

/**
 * List lectures action.
 *
 * @author Stephan Anft
 */
public class ListLecturesAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public ListLecturesAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Alle Vorlesungsveranstaltungen ausgeben";
	}

	/**
	 * List all lectures.
	 */
	public void execute() {
		final List<Lecture> lectures = new LectureService().listLectures();
		for (Lecture lecture : lectures) {
			System.out.println("---------------------------");
			System.out.printf("Veranstaltung mit ID %1$d:%n", lecture.getId());
			System.out.printf("Beginn - Datum: %1$te.%1$tm.%1$tY, Uhrzeit: %1$tH:%1$tM%n", lecture.getBegin());
			System.out.printf("Ende - Datum: %1$te.%1$tm.%1$tY, Uhrzeit: %1$tH:%1$tM%n", lecture.getEnd());
			System.out.printf("Vorlesung: %1$s%2$d, Dozent: %3$s, Titel: %4$s%n", lecture.getCourse().getFieldOfStudy(),
					lecture.getCourse().getNumber(), lecture.getCourse().getLecturer(), lecture.getCourse().getTitle());
			System.out.printf("Raum: %1$s%2$d%n", lecture.getRoom().getBuilding(), lecture.getRoom().getRoomNumber());
		}
		System.out.println("-----------ENDE------------");
	}
}
