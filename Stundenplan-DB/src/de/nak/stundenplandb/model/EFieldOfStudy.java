package de.nak.stundenplandb.model;

/**
 * This Enum represents the actual fields of Study at NAK
 * @author Lars Lembke
 *
 */
public enum EFieldOfStudy {
	BUSINESS("Betriebswirtschaftslehre", "B"), ENGINEERIN(
			"Wirtschaftingenieurwesen", "W"), INFORMATICS(
			"Wirtschaftsinformatik", "I");
	/**
	 * The long tile for this field of stuty
	 */
	private String longTitle;
	/**
	 * The abreviation for this field of study
	 */
	private String abreviation;

	private EFieldOfStudy(String bezeichnung, String kuerzel) {
		this.longTitle = bezeichnung;
		this.abreviation = kuerzel;
	}

	/**
	 * @return the longTitle
	 */
	public String getLongTitle() {
		return longTitle;
	}

	/**
	 * @return the abreviation
	 */
	public String getAbreviation() {
		return abreviation;
	}
}
