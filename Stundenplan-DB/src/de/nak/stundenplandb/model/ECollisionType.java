package de.nak.stundenplandb.model;

/**
 * All possible Collision when creating a new Meeting/Appointment
 * 
 * @author Lars Lembke
 *
 */
public enum ECollisionType {
	ROOM_OCCUPIED, LECTURER_BUSY, STUDENTGROUP_BUSY, COHORT_BUSY
}
