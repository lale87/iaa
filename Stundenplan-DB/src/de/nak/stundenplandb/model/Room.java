package de.nak.stundenplandb.model;

import javax.persistence.Column;

public class Room {
	/**
	 * The Identifier
	 */
	private long id;
	/**
	 * The minimum time between two meetings in this room
	 */
	private Integer ChangingTime;
	/**
	 * The maximum available seats in this room
	 */
	private Integer seats;
	/**
	 * The RoomType
	 */
	private RoomType roomType;
	/**
	 * The Building
	 */
	private String building;
	/**
	 * The roomnumber
	 */
	private Integer roomNumber;

	/**
	 * @return the building
	 */
	@Column(length = 1, nullable = false)
	public String getBuilding() {
		return building;
	}

	/**
	 * @param building
	 *            the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * @return the roomNumber
	 */
	@Column(name = "ROOM_NUMBER", nullable = false)
	public Integer getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber
	 *            the roomNumber to set
	 */
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the changingTime
	 */
	@Column(name = "CHANGING_TIME", nullable = false)
	public Integer getChangingTime() {
		return ChangingTime;
	}

	/**
	 * @param changingTime
	 *            the changingTime to set
	 */
	public void setChangingTime(Integer changingTime) {
		ChangingTime = changingTime;
	}

	/**
	 * @return the seats
	 */
	@Column(nullable = false)
	public Integer getSeats() {
		return seats;
	}

	/**
	 * @param seats
	 *            the seats to set
	 */
	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	/**
	 * @return the roomType
	 */
	public RoomType getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType
	 *            the roomType to set
	 */
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

}
