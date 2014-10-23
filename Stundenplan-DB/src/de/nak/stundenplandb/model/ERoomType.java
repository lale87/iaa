package de.nak.stundenplandb.model;

public enum ERoomType {
	COMPUTER_LAB(15), CLASSROOM(0);
	/**
	 * The minimum chanigingTime for this RoomType
	 */
	private Integer minChangingTime;

	/**
	 * Constructor
	 * 
	 * @param minBreak
	 */
	private ERoomType(Integer minBreak) {
		this.setMinBreak(minBreak);
	}

	/**
	 * @return the minBreak
	 */
	public Integer getMinBreak() {
		return minChangingTime;
	}

	/**
	 * @param minBreak
	 *            the minBreak to set
	 */
	private void setMinBreak(Integer minBreak) {
		this.minChangingTime = minBreak;
	}
}
