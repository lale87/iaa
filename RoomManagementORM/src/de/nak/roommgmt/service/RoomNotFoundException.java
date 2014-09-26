package de.nak.roommgmt.service;

/**
 * Exception throws if a room could not be found.
 * @author Stephan Anft
 */
public class RoomNotFoundException extends Exception {
	/**	Serial version uid. */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RoomNotFoundException() {
		super();
	}

	/**
	 * Constructor with message.
	 * @param message The message.
	 */
	public RoomNotFoundException(String message) {
		super(message);
	}
}
