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
public class LecturerDaoImpl extends GenericDaoImpl<Lecturer> implements LecturerDao {

	public LecturerDaoImpl() {
		super(Lecturer.class);
	}
}
