/**
 * 
 */
package de.nak.stundenplandb.dao;

import java.util.Date;

import de.nak.stundenplandb.model.Lecturer;

/**
 * Implementation des DAO für die Klasse Lecturer
 * 
 * @author Fabian Kolossa
 *
 */
public class LecturerDAOImpl extends GenericDAOImpl<Lecturer> implements
		LecturerDAO {

	public LecturerDAOImpl() {
		super(Lecturer.class);
	}

	@Override
	public boolean isBusy(Long id, Date start, Date end) {
		// TODO Hier muss die Query hin, um zu prüfen, ob ein Dozent beschäftigt
		// ist
		return false;
	}
}
