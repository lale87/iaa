/**
 * 
 */
package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Lecturer;

/**
 * Implementation des DAO für die Klasse Lecturer
 * @author Fabian Kolossa
 *
 */
public class LecturerDAOImpl extends GenericDAOImpl<Lecturer> implements LecturerDAO {

	public LecturerDAOImpl() {
		super(Lecturer.class);
	}
}
