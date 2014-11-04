package de.nak.stundenplandb.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> loadAppointmentsForLecturerInTimeperiod(
			Lecturer lecturer, Date start, Date end) {
		List<Appointment> appointments = sessionFactory
				.getCurrentSession().createQuery(
				"SELECT a FROM Appointment a "
				+ "JOIN a.meeting m "
				+ "JOIN m.lecturer l WHERE l = :lecturer "
				+ "AND a.start > :startDate "
				+ "AND a.end < :endDate "
				+ "ORDER BY a.start ASC")
				.setEntity("lecturer", lecturer)
				.setDate("startDate", start)
				.setDate("endDate", end)
				.list();
		return appointments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> loadAppointmentsForStudentGroupInTimeperiod(
			StudentGroup studentGroup, Date start, Date end) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		// Lecture
		appointments.addAll(sessionFactory
				.getCurrentSession().createQuery(
				"SELECT a FROM Appointment a "
				+ "JOIN a.meeting m "
				+ "JOIN m."
				+ "JOIN m.lecturer l WHERE l = :studentGroup "
				+ "AND a.start > :startDate "
				+ "AND a.end < :endDate "
				+ "ORDER BY a.start ASC")
				.setEntity("studentGroup", studentGroup)
				.setDate("startDate", start)
				.setDate("endDate", end)
				.list());
		return appointments;
	}

}
