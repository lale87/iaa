package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.service.RoomNotFoundException;
import de.nak.roommgmt.service.RoomService;

/**
 * Delete room action.
 *
 * @author Stephan Anft
 */
public class DeleteRoomAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public DeleteRoomAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Raum löschen";
	}

	/**
	 * Deletes a room.
	 *
	 * @throws RoomNotFoundException if the room could not be found.
	 */
	public void execute() throws RoomNotFoundException {
		System.out.println("Die ID des Raums bitte:");
		long id = ConsoleUtil.readInt();
		try {
			new RoomService().deleteRoom(id);
			System.out.println("Raum wurde gelöscht.");
		}
		catch (RoomNotFoundException ex) {
			System.out.printf("Raum mit der ID %1$d wurde nicht gefunden.%n", id);
			throw ex;
		}
	}
}
