package de.nak.stundenplandb.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Elective Entity
 * 
 * @author Lars Lembke
 *
 */
@Entity
public class Elective extends Meeting {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1110670613194853340L;
	/**
	 * Kohorte
	 */
	private Cohort cohort;

	@ManyToOne(optional = false)
	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

}
