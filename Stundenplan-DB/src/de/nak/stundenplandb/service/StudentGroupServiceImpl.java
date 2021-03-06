package de.nak.stundenplandb.service;

import java.util.ArrayList;
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
	public List<Appointment> getAppointmentsForStudentGroupInWeek(
			Long studentGroupId, int week, int year) {
		Date start, end;
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.YEAR, year);
		start = cal.getTime();
		// check if the following week is in the next year
		cal.clear();
		cal.set(year, 11, 31);
		if (week == cal.get(Calendar.WEEK_OF_YEAR)) {
			week = 0;
			year++;
		}
		cal.clear();
		cal.set(Calendar.WEEK_OF_YEAR, week + 1);
		cal.set(Calendar.YEAR, year);
		end = cal.getTime();
		return getAppointmentsForStudentGroupInTimeperiod(
				studentGroupId, start, end);
	}
	
	@Override
	public List<Appointment> getAppointmentsForStudentGroupInTimeperiod(
			Long studentGroupId, Date start, Date end) {
		StudentGroup studentGroup = studentGroupDAO.load(studentGroupId);
		List<Appointment> appointments = appointmentDAO
				.loadAppointmentsForStudentGroup(studentGroup);
		appointments = filterAppointmentsForTimeperiod(appointments, start, end);
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

	/**Injects the appointmentDAO
	 * 
	 * @param appointmentDAO
	 */
	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	public boolean isBusy(Long studentGroupId, Date start, Date end) {
		StudentGroup studentGroup = studentGroupDAO.load(studentGroupId);
		Integer minBreak = studentGroup.getMinBreak();
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
		// When there is no Appointment for this StudentGroup within the given
		// period,
		// it is NOT busy
		List<Appointment> appointments = appointmentDAO
				.loadAppointmentsForStudentGroup(studentGroup);
		return !filterAppointmentsForTimeperiod(appointments,
				startDateWithBreakTime, endDateWithBreakTime)
				.isEmpty();
		// Ask the DAO
		// return studentGroupDAO.isBusy(studentGroupId, startDateWithBreakTime,
		// endDateWithBreakTime);
	}

	@Override
	public List<StudentGroup> loadStudentGroupsByCohortId(Long cohortId) {
		return studentGroupDAO.loadStudentGroupsByCohortId(cohortId);
	}
	
	/**
	 * Filters a list of appointments for a specific timeperiod.
	 * @param appointments
	 * 			List of appointments
	 * @param start
	 * 			Start date
	 * @param end
	 * 			End date
	 * @return List of Appointments in the given  timeperiod
	 */
	private List<Appointment> filterAppointmentsForTimeperiod(
			List<Appointment> appointments, Date start, Date end) {
		List<Appointment> appointmentsInTimeperiod =
				new ArrayList<Appointment>();
		
		// iterate appointments
		for (Appointment a : appointments) {
			// create date/time objects
			Calendar as = Calendar.getInstance();
			Calendar ae = Calendar.getInstance();
			Calendar s = Calendar.getInstance();
			Calendar e = Calendar.getInstance();
			as.setTime(a.getStart());
			ae.setTime(a.getEnd());
			s.setTime(start);
			e.setTime(end);
			
			// s' >= s && e' <= e
			if ((as.after(s) || as.equals(s))
					&& (ae.before(e) || ae.equals(e))) {
				appointmentsInTimeperiod.add(a);
				continue;
			// s' < s && e' >= s
			} else if (as.before(s) && (ae.after(s) || ae.equals(s))) {
				appointmentsInTimeperiod.add(a);
				continue;
			// s' <= e && e' > e
			} else if ((as.before(e) || as.equals(e)) && ae.after(e)) {
				appointmentsInTimeperiod.add(a);
				continue;
			}
		}
		
		return appointmentsInTimeperiod;
	}

}
