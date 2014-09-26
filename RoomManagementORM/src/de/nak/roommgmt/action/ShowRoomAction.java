package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.model.Room;
import de.nak.roommgmt.service.RoomNotFoundException;
import de.nak.roommgmt.service.RoomService;

/**
 * Show single room action.
 *
 * @author Stephan Anft
 */
public class ShowRoomAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public ShowRoomAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Raum anzeigen";
	}

	/**
	 * Shows a single room.
	 *
	 * @throws RoomNotFoundException if the room was not found.
	 */
	public void execute() throws RoomNotFoundException {
		System.out.println("Die ID des Raums bitte:");
		long id = ConsoleUtil.readInt();
		try {
			Room room = new RoomService().showRoom(id);
			System.out.println("---------------------------");
			System.out.printf("Raum mit ID %1$d:%n", room.getId());
			System.out.printf("Geb. %1$s, Nummer %2$d, Sitzpl. %3$d, Beamer: %4$b%n", room.getBuilding(), room.getRoomNumber(), room.getSeats(), room.isBeamer());
			System.out.println("-----------ENDE------------");
		}
		catch (RoomNotFoundException ex) {
			System.out.printf("Raum mit der ID %1$d wurde nicht gefunden.%n", id);
			throw ex;
		}
	}
}
