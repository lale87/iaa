package de.nak.roommgmt.service;

/**
 * Exception throws if a course could not be found.
 * @author Stephan Anft
 */
public class CourseNotFoundException extends Exception {
	/**	Serial version uid. */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CourseNotFoundException() {
		super();
	}

	/**
	 * Constructor with message.
	 * @param message The message.
	 */
	public CourseNotFoundException(String message) {
		super(message);
	}
}
