package de.nak.stundenplandb.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.nak.stundenplandb.dao.AppointmentDAO;
import de.nak.stundenplandb.dao.ElectiveDAO;
import de.nak.stundenplandb.dao.ExamDAO;
import de.nak.stundenplandb.dao.LectureDAO;
import de.nak.stundenplandb.dao.LecturerDAO;
import de.nak.stundenplandb.dao.RoomDAO;
import de.nak.stundenplandb.dao.SeminarDAO;
import de.nak.stundenplandb.model.Appointment;
import de.nak.stundenplandb.model.EMeetingType;
import de.nak.stundenplandb.model.Lecturer;
import de.nak.stundenplandb.model.Meeting;
import de.nak.stundenplandb.model.Room;

/**
 * Implementation for the MeetingService
 * 
 * @author Lars Lembke
 *
 */
public class MeetingServiceImpl implements MeetingService {

	private ExamDAO examDAO;
	private SeminarDAO seminarDAO;
	private ElectiveDAO electiveDAO;
	private LectureDAO lectureDAO;
	private LecturerDAO lecturerDAO;
	private RoomDAO roomDAO;
	private AppointmentDAO appointmentDAO;

	/**
	 * creates a Set of Appointments starting with the first date. For each
	 * repitition of an appointment starts seven days later than the appointment
	 * before
	 * 
	 * @param numberOfAppointments
	 *            <Integer>
	 * @param begin
	 *            <Date>
	 * @param end
	 *            <Date>
	 * @return a Set of Appointments
	 */
	protected Set<Appointment> createAppointments(Integer numberOfAppointments,
			Date begin, Date end) {
		Set<Appointment> appointmentSet = new HashSet<Appointment>();
		for (int i = 0; i < numberOfAppointments; i++) {
			int daysToAdd = i * 7;
			Calendar c = Calendar.getInstance();
			Appointment appointment = new Appointment();
			// ADD 7 day to the begin-date to match the next appointment
			c.setTime(begin);
			c.add(Calendar.DATE, daysToAdd);
			appointment.setStart(c.getTime());
			// ADD 7 day to the end-date to match the next appointment
			c.setTime(end);
			c.add(Calendar.DATE, daysToAdd);
			appointment.setEnd(c.getTime());
			// ADD the appointment to the set
			appointmentSet.add(appointment);
		}

		return appointmentSet;
	}

	@Override
	public void fillMeeting(Meeting meeting, String meetingName,
			Long lecturerId, List<Long> roomIds, int numberOfAppointments,
			Date startDate, Date endDate, EMeetingType meetingType) {
		// get referenced entities
		Lecturer lecturer = lecturerDAO.load(lecturerId);
		Set<Room> rooms = new HashSet<Room>();
		for (Long id : roomIds) {
			Room room = roomDAO.load(id);
			rooms.add(room);
		}
		// remove existing appointments first
		List<Appointment> existingAppointments = meeting.getAppointments();
		if (existingAppointments != null) {
			for (Appointment appointment : existingAppointments) {
				appointmentDAO.delete(appointment);
			}
			meeting.setAppointments(new ArrayList<Appointment>());
		}
		
		Set<Appointment> appointments = this.createAppointments(
				numberOfAppointments, startDate, endDate);

		meeting.setName(meetingName);
		meeting.setLecturer(lecturer);
		meeting.setRooms(rooms);
		meeting.setMeetingType(meetingType);
		for (Appointment appointment : appointments) {
			meeting.addAppointmentToMeeting(appointment);
		}
		// no return due to a given reference!
	}

	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	public void setSeminarDAO(SeminarDAO seminarDAO) {
		this.seminarDAO = seminarDAO;
	}

	public void setElectiveDAO(ElectiveDAO electiveDAO) {
		this.electiveDAO = electiveDAO;
	}

	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}

	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}

	@Override
	public void deleteExam(Long examId) {
		this.examDAO.delete(this.examDAO.load(examId));
	}

	@Override
	public void deleteSeminar(Long seminarId) {
		this.seminarDAO.delete(this.seminarDAO.load(seminarId));
	}

	@Override
	public void deleteElective(Long electiveId) {
		this.electiveDAO.delete(this.electiveDAO.load(electiveId));
	}

	@Override
	public void deleteLecture(Long lectureId) {
		this.lectureDAO.delete(this.lectureDAO.load(lectureId));
	}

	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

}
