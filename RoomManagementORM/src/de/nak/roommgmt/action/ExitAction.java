package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

/**
 * The exit action.
 *
 * @author Stephan Anft
 */
public class ExitAction extends Action {

	/**
	 * {@inheritDoc}
	 */
	public ExitAction(ApplicationContext context) {
		super(context);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Verlassen";
	}

	/**
	 * {@inheritDoc}
	 */
	public void execute() {
		// Exit
		System.exit(0);
	}


}
