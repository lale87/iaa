package de.nak.stundenplandb.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Exam Entity
 * 
 * @author Lars Lembke
 *
 */
@Entity
public class Exam extends Meeting {
	/**
	 * Teilnehmende Zenturien
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
