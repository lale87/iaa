package de.nak.stundenplandb.model;

/**
 * Enumeration for acedemic titles
 * 
 * @author Lars Lembke
 *
 */
public enum EAcademicTitle {
	PROF("Professor", "Prof."), DR("Doktor", "Dr."), PROF_DR(
			"Professor Doktor", "Prof. Dr.");
	private String longTitle;
	private String shortTitle;

	/**
	 * The constructor
	 * 
	 * @param longTitle
	 * @param shortTitle
	 */
	private EAcademicTitle(String longTitle, String shortTitle) {
		this.setLongTitle(longTitle);
		this.setShortTitle(shortTitle);
	}

	/**
	 * @return the longTitle
	 */
	public String getLongTitle() {
		return longTitle;
	}

	/**
	 * @param longTitle
	 *            the longTitle to set
	 */
	public void setLongTitle(String longTitle) {
		this.longTitle = longTitle;
	}

	/**
	 * @return the shortTitle
	 */
	public String getShortTitle() {
		return shortTitle;
	}

	/**
	 * @param shortTitle
	 *            the shortTitle to set
	 */
	private void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

}
