package de.nak.stundenplandb.dao;

import java.util.List;

import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Schnittstelle für das Appointment-DAO
 * 
 * @author Lars Lembke
 *
 */
public interface AppointmentDAO extends GenericDAO<Appointment> {
	/**
	 * Loads all appointments for a specific room.
	 * @param room Room instance
	 * @return List of Appointments, ordered by their start date (asc)
	 */
	List<Appointment> loadAppointmentsForRoom(Room room);
	
	/**
	 * Loads all appointments for a specific lecturer.
	 * @param lecturer Lecturer instance
	 * @return List of Appointments, ordered by their start date (asc)
	 */
	List<Appointment> loadAppointmentsForLecturer(Lecturer lecturer);
	
	/**
	 * Loads all appointments for a specific student group.
	 * @param studentGroup Student group instance
	 * @return List of Appointments, ordered by their start date (asc)
	 */
	List<Appointment> loadAppointmentsForStudentGroup(
			StudentGroup studentGroup);
}
