package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.Room;

/**
 * Implementation des Appointment-DAO
 * @author Lars Lembke, Fabian Kolossa
 *
 */
public class AppointmentDAOImpl extends GenericDAOImpl<Appointment> implements AppointmentDAO{

	public AppointmentDAOImpl() {
		super(Appointment.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> loadAppointmentsForRoomInTimeperiod(Room room,
			Date start, Date end) {
		List<Appointment> appointments = sessionFactory
				.getCurrentSession().createQuery(
				"SELECT a FROM Appointment a "
				+ "JOIN a.meeting m "
				+ "JOIN m.rooms r WHERE r = :room "
				+ "AND a.start > :startDate "
				+ "AND a.end < :endDate "
				+ "ORDER BY a.start ASC")
				.setEntity("room", room)
				.setDate("startDate", start)
				.setDate("endDate", end)
				.list();
		return appointments;
	}

}
