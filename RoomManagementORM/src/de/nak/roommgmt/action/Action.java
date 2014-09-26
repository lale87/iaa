package de.nak.roommgmt.action;

import org.springframework.context.ApplicationContext;

/**
 * Abstract base type for all action classes.
 *
 * @author Stephan Anft
 */
public abstract class Action {
	/** The Spring application context. */
	private ApplicationContext context;
	
	/**
	 * Constructor with application context.
	 * @param context The Spring application context.
	 */
	public Action(ApplicationContext context) {
		this.context = context;
	}

	/**
	 * Returns the label of the action that is shown in the menu.
	 *
	 * @return a string.
	 */
	public abstract String getLabel();

	/**
	 * Execute the action's process logic.
	 *
	 * @throws Exception if something went wrong during execution.
	 */
	public abstract void execute() throws Exception;

	/**
	 * Returns the Spring application context.
	 * @return the application context.
	 */
	public ApplicationContext getContext() {
		return context;
	}
	
}
