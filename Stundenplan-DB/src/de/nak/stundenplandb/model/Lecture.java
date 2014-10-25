package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

/**
 * Lecture Entity.
 * 
 * @author Lars Lembke
 *
 */
@Entity
public class Lecture extends Meeting {
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
