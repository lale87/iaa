package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.Room;

/**
 * Schnittstelle für das Appointment-DAO
 * 
 * @author Lars Lembke
 *
 */
public interface AppointmentDAO extends GenericDAO<Appointment> {
	
	List<Appointment> loadAppointmentsForRoomInTimeperiod(Room room, Date start,
			Date end);
}
