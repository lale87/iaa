/**
 * 
 */
package de.nak.stundenplandb.dao;

import de.nak.stundenplandb.model.Lecturer;

/**
 * Implementation of the LecturerDAO
 * 
 * @author Fabian Kolossa
 *
 */
public class LecturerDAOImpl extends GenericDAOImpl<Lecturer> implements
		LecturerDAO {

	public LecturerDAOImpl() {
		super(Lecturer.class);
	}
}
