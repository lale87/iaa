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

	/* (non-Javadoc)
	 * @see de.nak.stundenplandb.dao.AppointmentDAO#loadAppointmentsForRoomInTimeperiod(de.nak.stundenplandb.model.Room, java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> loadAppointmentsForRoomInTimeperiod(Room room,
			Date start, Date end) {
		List<Appointment> appointments = sessionFactory
				.getCurrentSession().createQuery(
				"select a from Appointment a "
				+ "join a.meeting m "
				+ "join m.rooms r where r = :room "
				+ "and a.start > :startDate "
				+ "and a.start < :endDate")
				.setEntity("room", room)
				.setDate("startDate", start)
				.setDate("endDate", end)
				.list();
		return appointments;
	}

}
