package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

/**
 * Entitiy of a Cohort. A Chort is an age group at the NAK. A Cohort consists of
 * a various number of StudentGroups
 * 
 * @author Lars Lembke
 *
 */
@Entity
public class Cohort implements DomainObject {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -767019587578069195L;
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
	
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the yearOfAdmission
	 */
	@NaturalId
	@Column(name = "YEAR_OF_ADMISSION", nullable = false)
	public Integer getYearOfAdmission() {
		return yearOfAdmission;
	}
	/**
	 * @param yearOfAdmission the yearOfAdmission to set
	 */
	public void setYearOfAdmission(Integer yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((yearOfAdmission == null) ? 0 : yearOfAdmission.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cohort other = (Cohort) obj;
		if (yearOfAdmission == null) {
			if (other.yearOfAdmission != null)
				return false;
		} else if (!yearOfAdmission.equals(other.yearOfAdmission))
			return false;
		return true;
	}
	
}
