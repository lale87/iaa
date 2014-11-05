package de.nak.stundenplandb.dao;

import java.util.Date;
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
	 * Loads all appointments for a specific room in a specific period of time.
	 * @param room Room instance
	 * @param start Start date
	 * @param end End date
	 * @return List of Appointments, ordered by their start date (asc)
	 */
	List<Appointment> loadAppointmentsForRoomInTimeperiod(Room room, Date start,
			Date end);
	
	/**
	 * Loads all appointments for a specific lecturer in a specific period of time.
	 * @param lecturer Lecturer instance
	 * @param start Start date
	 * @param end End date
	 * @return List of Appointments, ordered by their start date (asc)
	 */
	List<Appointment> loadAppointmentsForLecturerInTimeperiod(Lecturer lecturer,
			Date start, Date end);
	
	/**
	 * Loads all appointments for a specific student group in a specific period of time.
	 * @param studentGroup Student group instance
	 * @param start Start date
	 * @param end End date
	 * @return List of Appointments, ordered by their start date (asc)
	 */
	List<Appointment> loadAppointmentsForStudentGroupInTimeperiod(
			StudentGroup studentGroup, Date start, Date end);
}
