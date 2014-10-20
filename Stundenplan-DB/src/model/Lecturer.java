package model;

import javax.persistence.Entity;

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
	 * The lecturer's academic title (e.g. Prof / Dr)
	 */
	private AcademicTitle academicTitle;
	/**
	 * The lecturer's first name
	 */
	private String firstName;
	/**
	 * @return the id
	 */
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
	 * @return the academic title
	 */
	public AcademicTitle getTitle() {
		return academicTitle;
	}
	/**
	 * @param title the academic title to set
	 */
	public void setTitle(AcademicTitle title) {
		this.academicTitle = title;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the minBreak
	 */
	public int getMinBreak() {
		return minBreak;
	}
	/**
	 * @param minBreak the minBreak to set
	 */
	public void setMinBreak(int minBreak) {
		this.minBreak = minBreak;
	}
	/**
	 * The lecturer's lastname
	 */
	private String lastName;
	/**
	 * The lecturer's shortest time between two meetings
	 */
	private int minBreak;

}
