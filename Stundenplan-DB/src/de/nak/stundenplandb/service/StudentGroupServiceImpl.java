package de.nak.stundenplandb.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import de.nak.stundenplandb.dao.AppointmentDAO;
import de.nak.stundenplandb.dao.CohortDAO;
import de.nak.stundenplandb.dao.StudentGroupDAO;
import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.Cohort;
import de.nak.stundenplandb.model.EFieldOfStudy;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Elective;
import de.nak.stundenplandb.model.Exam;
import de.nak.stundenplandb.model.Lecture;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Implementation for the StudentGroupService
 * 
 * @author Lars Lembke
 *
 */
public class StudentGroupServiceImpl implements StudentGroupService {

	/**
	 * Injected DAO
	 */
	private StudentGroupDAO studentGroupDAO;
	/**
	 * Injected DAO
	 */
	private CohortDAO cohortDAO;
	/**
	 * Injected DAO
	 */
	private AppointmentDAO appointmentDAO;

	/**
	 * Comparator for a Cohort
	 */
	private Comparator<Cohort> cohortComparator = new Comparator<Cohort>() {

		@Override
		public int compare(Cohort o1, Cohort o2) {
			return o1.getYearOfAdmission().compareTo(o2.getYearOfAdmission());
		}
	};

	/**
	 * Comparator for a StudentGroup
	 */
	private Comparator<StudentGroup> studentGroupComparator = new Comparator<StudentGroup>() {

		@Override
		public int compare(StudentGroup o1, StudentGroup o2) {
			int cohortCompare = cohortComparator.compare(o1.getCohort(),
					o2.getCohort());
			// If Cohort is the same campare the FieldOfStudy by Abbreviation
			if (cohortCompare == 0) {
				// If FieldOfStudy-Abbreviation is the same compare the
				// GroupIdentifier
				int fieldCompare = o1.getFieldOfStudy().getAbreviation()
						.compareTo(o2.getFieldOfStudy().getAbreviation());
				if (fieldCompare == 0) {
					return o1.getGroupIdentifier().compareTo(
							o2.getGroupIdentifier());
				} else {
					return fieldCompare;
				}
			} else {
				return cohortCompare;
			}
		}
	};

	@Override
	public void saveStudentGroup(StudentGroup studentGroup) {
		List<Cohort> cohortFromDBList = cohortDAO
				.loadCohortByYearOfAdmission(studentGroup.getCohort()
						.getYearOfAdmission());
		// Replace Cohort by Cohort from DB - Should be just one element in the
		// list
		if (cohortFromDBList != null && cohortFromDBList.size() == 1) {
			studentGroup.setCohort(cohortFromDBList.get(0));
		}
		studentGroupDAO.save(studentGroup);
	}

	@Override
	public List<StudentGroup> loadAllStudentGroups() {
		return studentGroupDAO.loadAll();
	}

	@Override
	public List<StudentGroup> loadAllStudentGroupsSorted() {
		// load the groups
		List<StudentGroup> studentGroups = studentGroupDAO.loadAll();
		// sort the groups
		Collections.sort(studentGroups, studentGroupComparator);
		// return the sorted groups
		return studentGroups;
	}

	@Override
	public List<Cohort> loadAllCohorts() {
		return cohortDAO.loadAll();
	}

	@Override
	public List<Cohort> loadAllCohortsSortedByYearOfAdmission() {
		List<Cohort> cohortList = cohortDAO.loadAll();
		// Orders the list of cohorts by the year of admission
		// Comparator<Cohort> cohortComparator = new Comparator<Cohort>() {
		//
		// @Override
		// public int compare(Cohort o1, Cohort o2) {
		// return o1.getYearOfAdmission().compareTo(o2.getYearOfAdmission());
		// }
		// };
		Collections.sort(cohortList, cohortComparator);
		return cohortList;
	}

	@Override
	public List<EFieldOfStudy> getAllFieldsOfStudy() {
		return Arrays.asList(EFieldOfStudy.values());
	}

	@Override
	public List<Appointment> getAppointmentsForStudentGroup(Long studentGroupId) {
		return getAppointmentsForStudentGroupInTimeperiod(studentGroupId,
				new Date(Long.MIN_VALUE), new Date(Long.MAX_VALUE));
	}

	@Override
	public List<Appointment> getAppointmentsForStudentGroupInTimeperiod(
			Long studentGroupId, Date start, Date end) {
		// TODO FK: Fehlerbehandlung?
		StudentGroup studentGroup = studentGroupDAO.load(studentGroupId);
		List<Appointment> appointments = appointmentDAO
				.loadAppointmentsForStudentGroupInTimeperiod(studentGroup,
						start, end);
		// initialize appointments
		for (Appointment appointment : appointments) {
			Hibernate.initialize(appointment.getMeeting());
			Hibernate.initialize(appointment.getMeeting().getRooms());
			Hibernate.initialize(appointment.getMeeting().getLecturer());
			// initialize lectures
			if (EMeetingType.LECTURE.equals(appointment.getMeeting()
					.getMeetingType())) {
				Hibernate.initialize(((Lecture) appointment.getMeeting())
						.getStudentGroup());
			}
			// initialize exams
			if (EMeetingType.EXAM.equals(appointment.getMeeting()
					.getMeetingType())) {
				Hibernate.initialize(((Exam) appointment.getMeeting())
						.getStudentGroups());
			}
			// initialize electives
			if (EMeetingType.ELECTIVE.equals(appointment.getMeeting()
					.getMeetingType())) {
				Hibernate.initialize(((Elective) appointment.getMeeting())
						.getCohort());
			}
		}
		return appointments;
	}

	/**
	 * Injects the studentGroupDAO
	 * 
	 * @param studentGroupDAO
	 */
	public void setStudentGroupDAO(StudentGroupDAO studentGroupDAO) {
		this.studentGroupDAO = studentGroupDAO;
	}

	/**
	 * Injects the studentGroupDAO
	 * 
	 * @param studentGroupDAO
	 */
	public void setCohortDAO(CohortDAO cohortDAO) {
		this.cohortDAO = cohortDAO;
	}

	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	public boolean isBusy(Long studentGroupId, Date start, Date end) {
		Integer minBreak = studentGroupDAO.load(studentGroupId).getMinBreak();
		// Calculate new time with changingTime
		Calendar cal = Calendar.getInstance();

		Date startDateWithBreakTime;
		cal.setTime(start);
		cal.add(Calendar.MINUTE, -minBreak);
		startDateWithBreakTime = cal.getTime();

		Date endDateWithBreakTime;
		cal.setTime(end);
		cal.add(Calendar.MINUTE, minBreak);
		endDateWithBreakTime = cal.getTime();
		// Ask the DAO
		return studentGroupDAO.isBusy(studentGroupId, startDateWithBreakTime,
				endDateWithBreakTime);
	}

	@Override
	public List<StudentGroup> loadStudentGroupsByCohortId(Long cohortId) {
		return studentGroupDAO.loadStudentGroupsByCohortId(cohortId);
	}

}
