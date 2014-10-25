package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entitiy of a Cohort. A Chort is an age group at the NAK. A Cohort consists of
 * a various number of StudentGroups
 * 
 * @author Lars Lembke
 *
 */
public class Cohort implements DomainObject {
	/**
	 * Identifier
	 */
	private Long id;
	/**
	 * The year of admission
	 */
	private Integer yearOfAdmission;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	@Column(name = "YEAR_OF_ADMISSION", nullable = false)
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the yearOfAdmission
	 */
	public Integer getYearOfAdmission() {
		return yearOfAdmission;
	}
	/**
	 * @param yearOfAdmission the yearOfAdmission to set
	 */
	public void setYearOfAdmission(Integer yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}
}
