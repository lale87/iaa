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
	
	// TODO FK: comments
	List<Appointment> loadAppointmentsForRoomInTimeperiod(Room room, Date start,
			Date end);
	List<Appointment> loadAppointmentsForLecturerInTimeperiod(Lecturer lecturer,
			Date start, Date end);
	List<Appointment> loadAppointmentsForStudentGroupInTimeperiod(
			StudentGroup studentGroup, Date start, Date end);
}
