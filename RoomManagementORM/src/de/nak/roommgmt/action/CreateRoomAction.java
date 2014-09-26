package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

import de.nak.roommgmt.ConsoleUtil;
import de.nak.roommgmt.service.RoomAlreadyPresentException;
import de.nak.roommgmt.service.RoomService;

/**
 * Create room action.
 *
 * @author Stephan Anft
 */
public class CreateRoomAction extends Action {
	
	/**
	 * {@inheritDoc}
	 */
	public CreateRoomAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Raum anlegen";
	}

	/**
	 * Creates a new room.
	 *
	 * @throws RoomAlreadyPresentException if the room is already present
	 *                                     in the database.
	 */
	public void execute() throws RoomAlreadyPresentException {
		System.out.println("Ein Gebäude bitte:");
		String building = ConsoleUtil.readString();
		System.out.println("Eine Raumnummer bitte:");
		int roomNumber = ConsoleUtil.readInt();
		System.out.println("Anzahl der Sitzplätze:");
		int seats = ConsoleUtil.readInt();
		System.out.println("Ist ein Beamer vorhanden (true|false):");
		boolean beamer = ConsoleUtil.readBoolean();
		try {
			new RoomService().createRoom(building, roomNumber, seats, beamer);
			System.out.println("Raum ist erfolgreich angelegt.");
		}
		catch (RoomAlreadyPresentException ex) {
			System.out.println("Raum ist bereits vorhanden.");
			throw ex;
		}
	}
}
