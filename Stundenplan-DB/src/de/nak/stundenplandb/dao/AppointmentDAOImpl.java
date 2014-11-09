package de.nak.stundenplandb.dao;

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
public class AppointmentDAOImpl extends GenericDAOImpl<Appointment> 
													implements AppointmentDAO {

	public AppointmentDAOImpl() {
		super(Appointment.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> loadAppointmentsForRoom(Room room) {
		List<Appointment> appointments = sessionFactory
				.getCurrentSession().createQuery(
				"SELECT a FROM Appointment a "
				+ "JOIN a.meeting m "
				+ "JOIN m.rooms r WHERE r = :room "
				+ "ORDER BY a.start ASC")
				.setEntity("room", room)
				.list();
		return appointments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> loadAppointmentsForLecturer(
			Lecturer lecturer) {
		List<Appointment> appointments = sessionFactory
				.getCurrentSession().createQuery(
				"SELECT a FROM Appointment a "
				+ "JOIN a.meeting m "
				+ "JOIN m.lecturer l WHERE l = :lecturer "
				+ "ORDER BY a.start ASC")
				.setEntity("lecturer", lecturer)
				.list();
		return appointments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> loadAppointmentsForStudentGroup(
			StudentGroup studentGroup) {
		List<Appointment> appointments = sessionFactory
				.getCurrentSession().createQuery(
				"SELECT a FROM Appointment a "
				+ "JOIN a.meeting m WHERE m IN "
					// lectures
				+ 	"(SELECT l FROM Lecture l "
				+ 	"JOIN l.studentGroup s WHERE s = :studentGroup) "
				+ "OR m IN "
					// exams
				+ 	"(SELECT e FROM Exam e "
				+ 	"JOIN e.studentGroups s WHERE s = :studentGroup) "
				+ "OR m IN "
					// electives
				+ 	"(SELECT e FROM Elective e "
				+ 	"JOIN e.cohort c WHERE c = :cohort) "
				+ "ORDER BY a.start ASC")
				.setEntity("studentGroup", studentGroup)
				.setEntity("cohort", studentGroup.getCohort())
				.list();
		return appointments;
	}

}
