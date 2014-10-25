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

/**
 * Meeting Entity
 * 
 * @author Fabian Kolossa
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Meeting {
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
	
	@OneToMany
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	public Lecturer getLecturer() {
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	@OneToMany
	public Set<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
}
