package de.nak.stundenplandb.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Exam Entity
 * 
 * @author Lars Lembke
 *
 */
@Entity
public class Exam extends Meeting {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1082604805966586549L;

	@Transient
	private Integer minBreak = 30;
	
	/**
	 * Zenturien
	 */
	private Set<StudentGroup> studentGroups;

	@Column(nullable = false)
	@OneToMany
	public Set<StudentGroup> getStudentGroups() {
		return studentGroups;
	}
	public void setStudentGroups(Set<StudentGroup> studentGroups) {
		this.studentGroups = studentGroups;
	}
}
