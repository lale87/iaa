package de.nak.stundenplandb.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Meeting Entity
 * 
 * @author Fabian Kolossa
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Meeting implements DomainObject{
	/**
	 * The meeting's shortest time between this and the following meeting
	 * Can be overitten in subclasses. Default: 0
	 */
	protected Integer minBreak = 0;
	
	/**
	 * The identifier
	 */
	private Long id;
	/**
	 * The name
	 */
	private String name;
	/**
	 * The rooms
	 */
	private Set<Room> rooms;
	/**
	 * The Lecturer
	 */
	private Lecturer lecturer;
	/**
	 * The Appointments
	 */
	private Set<Appointment> appointments;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable = false)
	@OneToMany
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	@Column(nullable = false)
	public Lecturer getLecturer() {
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	@Column(nullable = false)
	@OneToMany
	public Set<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	@Transient
	public Integer getMinBreak() {
		return minBreak;
	}
	public void setMinBreak(Integer minBreak) {
		this.minBreak = minBreak;
	}
}
