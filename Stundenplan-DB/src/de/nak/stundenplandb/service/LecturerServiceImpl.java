package de.nak.stundenplandb.service;

import java.util.Arrays;
import java.util.List;

import de.nak.stundenplandb.dao.LecturerDAO;
import de.nak.stundenplandb.model.EAcademicTitle;
import de.nak.stundenplandb.model.Lecturer;

/**
 * Implementation for the LecturerService
 * 
 * @author Lars Lembke
 *
 */
public class LecturerServiceImpl implements LecturerService {
	/**
	 * Injected DAO
	 */
	private LecturerDAO lecturerDAO;

	@Override
	public void saveLecturer(Lecturer lecturer) {
		lecturerDAO.save(lecturer);
	}

	@Override
	public List<Lecturer> loadAllLecturers() {
		return lecturerDAO.loadAll();
	}

	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}

	@Override
	public List<EAcademicTitle> getAllAcademicTitles() {
		return Arrays.asList(EAcademicTitle.values());
	}
}
