package de.nak.stundenplandb.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Appointment Entity
 * 
 * @author Fabian Kolossa
 *
 */
@Entity
public class Appointment {
	/**
	 * The identifier
	 */
	private Long id;
	
//TODO ggf löschen, wenn nicht benötigt
//	/**
//	 * The related meeting
//	 * (foreign key)
//	 */
//	private Meeting meeting;
	/**
	 * Start date and time
	 */
	private Date start;
	/**
	 * End date and time
	 */
	private Date end;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
//TODO ggf löschen, wenn nicht benötigt
//	@ManyToOne
//	@JoinColumn(name = "ROOM_ID") 
//	public Meeting getMeeting() {
//		return meeting;
//	}
//	public void setMeeting(Meeting meeting) {
//		this.meeting = meeting;
//	}
	
	@Column(nullable = false)
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	
	@Column(nullable = false)
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
}
