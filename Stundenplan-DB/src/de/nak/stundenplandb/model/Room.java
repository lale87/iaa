package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.NaturalId;

@Entity
public class Room {
	/**
	 * The Identifier
	 */
	private long id;
	/**
	 * The minimum time between two meetings in this room
	 */
	private Integer changingTime;
	/**
	 * The maximum available seats in this room
	 */
	private Integer seats;
	/**
	 * The RoomType
	 */
	private ERoomType roomType;
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
	@NaturalId
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
	@NaturalId
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
		return changingTime;
	}

	/**
	 * @param changingTime
	 *            the changingTime to set
	 */
	public void setChangingTime(Integer changingTime) {
		this.changingTime = changingTime;
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
	public ERoomType getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType
	 *            the roomType to set
	 */
	public void setRoomType(ERoomType roomType) {
		this.roomType = roomType;
	}

}
