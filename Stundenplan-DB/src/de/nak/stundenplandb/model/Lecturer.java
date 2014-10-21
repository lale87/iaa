package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private AcademicTitle academicTitle;
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
	 * The lecturer's lastname
	 */
	private String lastname;

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
	public AcademicTitle getTitle() {
		return academicTitle;
	}

	/**
	 * @param title
	 *            the academic title to set
	 */
	public void setTitle(AcademicTitle title) {
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
		return lastname;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastname = lastName;
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