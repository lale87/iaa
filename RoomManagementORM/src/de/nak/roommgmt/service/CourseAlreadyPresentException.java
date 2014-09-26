package de.nak.roommgmt.service;

/**
 * Exception indicating an already present course.
 * @author Stephan Anft
 */
public class CourseAlreadyPresentException extends Exception {
	/**	Serial version uid. */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CourseAlreadyPresentException() {
		super();
	}

	/**
	 * Constructor with message.
	 * @param message The message.
	 */
	public CourseAlreadyPresentException(String message) {
		super(message);
	}
}
