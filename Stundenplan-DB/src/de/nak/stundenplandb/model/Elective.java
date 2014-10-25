package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Elective Entity
 * 
 * @author Lars Lembke
 *
 */
@Entity
public class Elective extends Meeting {
	/**
	 * Kohorte
	 */
	private Cohort cohort;

	@Column(nullable = false)
	public Cohort getCohort() {
		return cohort;
	}
	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}
	
}
