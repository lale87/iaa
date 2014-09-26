package de.nak.roommgmt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * The room entity.
 * @author Stephan Anft
 */
@Entity
@Table(name = "ROOM")
public class Room implements Serializable {
	/**	Serial version uid. */
	private static final long serialVersionUID = 1L;
	/** The identifier. */
	private Long id;
	/** The name of the building. */
	private String building;
	/** The room number. */
	private int roomNumber;
	/** The number of seats. */
	private int seats;
	/** Indicates if a beamer is present. */
	private boolean beamer;
	/** The set of lectures. */
	private Set<Lecture> lectures;

	/**
	 * Returns the identifier.
	 * @return a Long value.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * Sets the identifier.
	 * @param id The identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the name of the building.
	 * @return a string.
	 */
	@NaturalId
	@Column(nullable = false)
	public String getBuilding() {
		return building;
	}

	/**
	 * Sets the name of the building.
	 * @param building The value to set.
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * Returns the room number.
	 * @return an integer.
	 */
	@NaturalId
	@Column(name = "ROOM_NUMBER", nullable = false)
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Sets the room number.
	 * @param roomNumber The value to set.
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Returns the number of seats.
	 * @return an integer.
	 */
	@Column(nullable = false)
	public int getSeats() {
		return seats;
	}

	/**
	 * Sets the number of seats.
	 * @param seats The value to set.
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}

	/**
	 * Returns whether a beamer is present or not.
	 * @return a boolena value.
	 */
	@Column(nullable = false)
	public boolean isBeamer() {
		return beamer;
	}

	/**
	 * Sets whether a beamer is present or not.
	 * @param beamer The value to set.
	 */
	public void setBeamer(boolean beamer) {
		this.beamer = beamer;
	}

	/**
	 * Returns the set of lectures.
	 * @return the lectures.
	 */
	@OneToMany(mappedBy = "room")
	public Set<Lecture> getLectures() {
		return lectures;
	}

	/**
	 * Sets the set of lectures.
	 * @param lectures the lectures to set.
	 */
	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}
	
	/**
	 * Associates the given lecture to this room.
	 * @param lecture The lecture to associate.
	 */
	public void associateLecture(Lecture lecture) {
		if (lecture == null) {
			throw new IllegalArgumentException();
		}
		if (this.equals(lecture.getRoom())) {
			// The same room is already associated
			return;
		}
		if (lecture.getRoom() != null) {
			lecture.getRoom().getLectures().remove(lecture);
		}
		lecture.setRoom(this);
		this.lectures.add(lecture);
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((building == null) ? 0 : building.hashCode());
		result = prime * result + roomNumber;
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Room other = (Room) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		return true;
	}
}
