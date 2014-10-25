package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Appointment;

/**
 * Impementation des Appointment-DAO
 * @author Lars Lembke
 *
 */
public class AppointmentDAOImpl extends GenericDaoImpl<Appointment> implements AppointmentDAO{

	public AppointmentDAOImpl() {
		super(Appointment.class);
	}

}
