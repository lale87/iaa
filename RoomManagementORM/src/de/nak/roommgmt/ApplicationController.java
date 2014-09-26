package de.nak.roommgmt;

import java.util.List;

import de.nak.roommgmt.action.Action;

/**
 * The application controller.
 * 
 * @author Stephan Anft
 */
public class ApplicationController {
	/**
	 * The list of actions.
	 */
	private List<Action> actions;

	/**
	 * Prints out the menu to the standard output.
	 */
	public void showMenu() {
		assert actions != null;
		MenuController menuController = new MenuController(actions);
		while (true) {
			// Print out all available actions
			menuController.printMenu();
			// Read user input
			Action action = menuController.readMenuChoice();
			try {
				action.execute();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Returns the list of actions.
	 * 
	 * @return a List of Action elements.
	 */
	public List<Action> getActions() {
		return actions;
	}

	/**
	 * Sets the list of actions.
	 * 
	 * @param actions
	 *            The list of Action elements to set.
	 */
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
}
