package de.nak.stundenplandb.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

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
	
	@Column(nullable = false)
	@Type(type = "timestamp")
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	
	@Column(nullable = false)
	@Type(type = "timestamp")
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
}
