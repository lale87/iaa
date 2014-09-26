package de.nak.roommgmt.service;

/**
 * Exception indicating an already present room.
 * @author Stephan Anft
 */
public class RoomAlreadyPresentException extends Exception {
	/**	Serial version uid. */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RoomAlreadyPresentException() {
		super();
	}

	/**
	 * Constructor with message.
	 * @param message The message.
	 */
	public RoomAlreadyPresentException(String message) {
		super(message);
	}
}
