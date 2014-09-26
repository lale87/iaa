package de.nak.roommgmt.service;

/**
 * Exception throws if a lecture could not be found.
 * @author Stephan Anft
 */
public class LectureNotFoundException extends Exception {
	/**	Serial version uid. */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LectureNotFoundException() {
		super();
	}

	/**
	 * Constructor with message.
	 * @param message The message.
	 */
	public LectureNotFoundException(String message) {
		super(message);
	}
}
