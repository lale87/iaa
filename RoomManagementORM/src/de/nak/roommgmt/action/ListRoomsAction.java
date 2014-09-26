package de.nak.roommgmt.action;

import de.nak.roommgmt.model.Room;
import de.nak.roommgmt.service.RoomService;

import java.util.List;

import org.springframework.context.ApplicationContext;

/**
 * List rooms action.
 *
 * @author Stephan Anft
 */
public class ListRoomsAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public ListRoomsAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Alle Räume ausgeben";
	}

	/**
	 * List all rooms.
	 */
	public void execute() {
		final List<Room> rooms = new RoomService().listRooms();
		for (Room room : rooms) {
			System.out.println("---------------------------");
			System.out.printf("Raum mit ID %1$d:%n", room.getId());
			System.out.printf("Geb. %1$s, Nummer %2$d, Sitzpl. %3$d, Beamer: %4$b%n", room.getBuilding(), room.getRoomNumber(), room.getSeats(), room.isBeamer());
		}
		System.out.println("-----------ENDE------------");
	}
}
