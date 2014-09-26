/**
 * 
 */
package de.nak.roommgmt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * The lecture entity.
 * @author Stephan Anft
 */
@Entity
@Table(name = "LECTURE")
public class Lecture implements Serializable {
	/** The serial version UID. */
	private static final long serialVersionUID = 1L;
	/** The identifier. */
	private Long id;
	/** The begin of the lecture. */
	private Date begin;
	/** The end of the lecture. */
	private Date end;
	/** The associated course. */
	private Course course;
	/** The associated room. */
	private Room room;
	
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
	 * @param id the id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Returns the begin.
	 * @return a date.
	 */
	@Column(nullable = false)
	@Type(type = "timestamp")
	public Date getBegin() {
		return begin;
	}

	/**
	 * Sets the begin.
	 * @param begin the date to set.
	 */
	public void setBegin(Date begin) {
		this.begin = begin;
	}

	/**
	 * Returns the end.
	 * @return a date.
	 */
	@Column(nullable = false)
	@Type(type = "timestamp")
	public Date getEnd() {
		return end;
	}

	/**
	 * Sets the end.
	 * @param end the date to set.
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	/**
	 * Returns the associated course.
	 * @return the course.
	 */
	@ManyToOne
	@JoinColumn(name = "COURSE_ID")
	public Course getCourse() {
		return course;
	}

	/**
	 * Sets the associated course.
	 * @param course the course to set.
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * Returns the associated room.
	 * @return the room.
	 */
	@ManyToOne
	@JoinColumn(name = "ROOM_ID")
	public Room getRoom() {
		return room;
	}

	/**
	 * Sets the associated room.
	 * @param room the room to set.
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

}
