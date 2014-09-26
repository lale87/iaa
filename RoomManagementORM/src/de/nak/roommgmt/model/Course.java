/**
 * 
 */
package de.nak.roommgmt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * The course entity.
 * @author Stephan Anft
 */
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {
	/** The serial version UID. */
	private static final long serialVersionUID = 1L;
	/** The identifier. */
	private Long id;
	/** The field of study. */
	private String fieldOfStudy;
	/** The course number. */
	private int number;
	/** The lecturer's name. */
	private String lecturer;
	/** The course title. */
	private String title;
	/** The set of associated lectures. */
	private Set<Lecture> lectures;
	
	/**
	 * Returns the identifier.
	 * @return a long value.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the identifier.
	 * @param id the id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Returns the field of study.
	 * @return a string.
	 */
	@NaturalId
	@Column(name = "FIELD_OF_STUDY", nullable = false)
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	
	/**
	 * Sets the field of study.
	 * @param fieldOfStudy the value to set.
	 */
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	
	/**
	 * Returns the course number.
	 * @return an int value.
	 */
	@NaturalId
	@Column(nullable = false)
	public int getNumber() {
		return number;
	}
	
	/**
	 * Sets the course number.
	 * @param number the number to set.
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * Returns the lecturer's name.
	 * @return a string.
	 */
	@Column(nullable = false)
	public String getLecturer() {
		return lecturer;
	}
	
	/**
	 * Sets the lecturer's name.
	 * @param lecturer the name to set.
	 */
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	
	/**
	 * Returns the course title.
	 * @return a string.
	 */
	@Column(nullable = false)
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the course title.
	 * @param title the title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Associates the given lecture to this course.
	 * @param lecture The lecture to associate.
	 */
	public void associateLecture(Lecture lecture) {
		if (lecture == null) {
			throw new IllegalArgumentException();
		}
		if (this.equals(lecture.getCourse())) {
			// The same course is already associated
			return;
		}
		if (lecture.getCourse() != null) {
			lecture.getCourse().getLectures().remove(lecture);
		}
		lecture.setCourse(this);
		this.lectures.add(lecture);
	}
	
	/**
	 * Returns the set of associated lectures.
	 * @return the set.
	 */
	@OneToMany(mappedBy = "course")
	public Set<Lecture> getLectures() {
		return lectures;
	}

	/**
	 * Sets the set of associated lectures.
	 * @param lectures the lectures to set.
	 */
	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}

	/**	{@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldOfStudy == null) ? 0 : fieldOfStudy.hashCode());
		result = prime * result + number;
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Course other = (Course) obj;
		if (fieldOfStudy == null) {
			if (other.fieldOfStudy != null)
				return false;
		} else if (!fieldOfStudy.equals(other.fieldOfStudy))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	
}
