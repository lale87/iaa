package de.nak.stundenplandb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

/**
 * Entity of a StudentGroup (Called "Zenturie" at NAK)
 * @author Lars Lembke
 *
 */
@Entity
public class StudentGroup implements DomainObject {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 6911496656780567139L;
	/**
	 * Identifier
	 */
	private Long id;
	/**
	 * The minimun time for a break between two Meetings
	 */
	private Integer minBreak;
	/**
	 * The actual Number of students in this group
	 */
	private Integer studentCount;
	/**
	 * The field of study
	 */
	private EFieldOfStudy fieldOfStudy;
	/**
	 * A StduentGroup is a part of a Cohort
	 */
	private Cohort cohort;
	/**
	 * The letter to differentiate two student groups within the same Cohort and FieldOfStudy
	 */
	private String groupIdentifier;
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
	 * @return the minBreak
	 */
	@Column(name = "MIN_BREAK", nullable = false)
	public Integer getMinBreak() {
		return minBreak;
	}
	/**
	 * @param minBreak the minBreak to set
	 */
	public void setMinBreak(Integer minBreak) {
		this.minBreak = minBreak;
	}
	/**
	 * @return the studentCount
	 */
	@Column(name = "STUDENT_COUNT", nullable = false)
	public Integer getStudentCount() {
		return studentCount;
	}
	/**
	 * @param studentCount the studentCount to set
	 */
	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}
	/**
	 * @return the fieldOfStudy
	 */
	@Column(name = "FIELD_OF_STUDY", nullable = false)
	@NaturalId
	public EFieldOfStudy getFieldOfStudy() {
		return fieldOfStudy;
	}
	/**
	 * @param fieldOfStudy the fieldOfStudy to set
	 */
	public void setFieldOfStudy(EFieldOfStudy fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	/**
	 * @return the cohort
	 */
	@Column(name = "COHORT", nullable = false)
	@NaturalId
	public Cohort getCohort() {
		return cohort;
	}
	/**
	 * @param cohort the cohort to set
	 */
	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}
	/**
	 * @return the groupIdentifier
	 */
	@Column(name = "GROUP_IDENTYFIER", length = 1, nullable = false)
	@NaturalId
	public String getGroupIdentifier() {
		return groupIdentifier;
	}
	/**
	 * @param groupIdentifier the groupIdentifier to set
	 */
	public void setGroupIdentifier(String groupIdentifier) {
		this.groupIdentifier = groupIdentifier;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cohort == null) ? 0 : cohort.hashCode());
		result = prime * result
				+ ((fieldOfStudy == null) ? 0 : fieldOfStudy.hashCode());
		result = prime * result
				+ ((groupIdentifier == null) ? 0 : groupIdentifier.hashCode());
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
		StudentGroup other = (StudentGroup) obj;
		if (cohort == null) {
			if (other.cohort != null)
				return false;
		} else if (!cohort.equals(other.cohort))
			return false;
		if (fieldOfStudy != other.fieldOfStudy)
			return false;
		if (groupIdentifier == null) {
			if (other.groupIdentifier != null)
				return false;
		} else if (!groupIdentifier.equals(other.groupIdentifier))
			return false;
		return true;
	}
	
	
}
