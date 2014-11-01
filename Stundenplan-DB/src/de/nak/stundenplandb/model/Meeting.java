package de.nak.stundenplandb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	 * Serial UID
	 */
	private static final long serialVersionUID = -1617091957188183873L;

	/**
	 * The meeting's shortest time between this and the following meeting
	 * Can be overwritten in subclasses. Default: 0
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
	
	@OneToMany
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	@ManyToOne(optional = false)
	public Lecturer getLecturer() {
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting")
	@OnDelete(action = OnDeleteAction.CASCADE)
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
	
	public void addAppointmentToMeeting(Appointment appointment) {
		appointment.setMeeting(this);
		if (this.getAppointments() == null) {
			this.setAppointments(new HashSet<Appointment>());
		}
		this.getAppointments().add(appointment);
	}
}
