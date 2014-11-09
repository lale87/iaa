package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;

@Entity
public class Room implements DomainObject {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -358278385710870583L;
	/**
	 * The Identifier
	 */
	private Long id;
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
	@Column(name = "ROOM_NUMBER", scale = 4, nullable = false)
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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the changingTime
	 */
	@Column(name = "CHANGING_TIME", scale = 3, nullable = false)
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
	@Column(nullable = false, scale = 3)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((building == null) ? 0 : building.hashCode());
		result = prime * result
				+ ((roomNumber == null) ? 0 : roomNumber.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		return true;
	}

	/**
	 * Returns the display name
	 * 
	 * @return
	 */
	@Transient
	public String getDisplayName() {
		// Führende Nullen hinzufügen
		String roomNumber = getRoomNumber().toString();
		while (roomNumber.length() < 3) {
			roomNumber = "0" + roomNumber;
		}
		return getBuilding() + roomNumber;
	}
}
