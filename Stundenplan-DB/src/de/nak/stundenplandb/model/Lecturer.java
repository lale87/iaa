package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

/**
 * Lecturer Entity
 * 
 * @author Lars Lembke
 *
 */
@Entity
public class Lecturer {
	/**
	 * The identifier
	 */
	private Long id;
	/**
	 * The lecturer's academic title 
	 */
	private EAcademicTitle academicTitle;
	/**
	 * The lecturer's first name
	 */
	private String firstName;
	/**
	 * The lecturer's unique abbreviation to distinguish two lecturers with the
	 * same name
	 */
	private String abbreviation;

	/**
	 * The lecturer's last name
	 */
	private String lastName;

	/**
	 * The lecturer's shortest time between two meetings
	 */
	private Integer minBreak;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the academic title
	 */
	public EAcademicTitle getTitle() {
		return academicTitle;
	}

	/**
	 * @param title
	 *            the academic title to set
	 */
	public void setTitle(EAcademicTitle title) {
		this.academicTitle = title;
	}

	/**
	 * @return the firstName
	 */
	@Column(name = "FIRST_NAME", length = 30, nullable = false)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@Column(length = 50, nullable = false)
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the minBreak
	 */
	@Column(name = "MIN_BREAK", nullable = false)
	public Integer getMinBreak() {
		return minBreak;
	}

	/**
	 * @param minBreak
	 *            the minBreak to set
	 */
	public void setMinBreak(Integer minBreak) {
		this.minBreak = minBreak;
	}

	/**
	 * @return the abbreviation
	 */
	@Column(length = 5, nullable = false)
	@NaturalId
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation
	 *            the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

}
