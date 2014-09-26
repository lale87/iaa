package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.service.RoomNotFoundException;
import de.nak.roommgmt.service.RoomService;

/**
 * Update room action.
 *
 * @author Stephan Anft
 */
public class UpdateRoomAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public UpdateRoomAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Raum aktualisieren";
	}

	/**
	 * Updates a room.
	 *
	 * @throws RoomNotFoundException if the room was not found.
	 */
	public void execute() throws RoomNotFoundException {
		System.out.println("Die ID des Raums bitte:");
		long id = ConsoleUtil.readInt();
		System.out.println("Neue Anzahl von Sitzplätzen:");
		int seats = ConsoleUtil.readInt();
		System.out.println("Beamer vorhanden (true|false):");
		boolean beamer = ConsoleUtil.readBoolean();
		try {
			new RoomService().updateRoom(id, seats, beamer);
			System.out.println("Raum wurde aktualisiert.");
		}
		catch (RoomNotFoundException ex) {
			System.out.printf("Raum mit der ID %1$d wurde nicht gefunden.%n", id);
			throw ex;
		}
	}
}
