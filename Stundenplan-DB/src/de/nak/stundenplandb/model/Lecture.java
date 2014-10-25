package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Lecture Entity.
 * 
 * @author Lars Lembke
 *
 */
@Entity
public class Lecture extends Meeting {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 7305304331461460366L;
	/**
	 * Zenturie der Vorlesung
	 */
	private StudentGroup studentGroup;

	@Column(nullable = false)
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}
	
}
