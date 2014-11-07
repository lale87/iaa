/**
 * 
 */
package de.nak.stundenplandb.dao;

import java.util.Date;

import de.nak.stundenplandb.model.Lecturer;

/**
 * Schnittstelle des Lecturer-DAO
 * 
 * @author Fabian Kolossa
 *
 */
public interface LecturerDAO extends GenericDAO<Lecturer> {
	/**
	 * Checks if the Lecturer is busy during the given time period
	 * 
	 * @param id
	 * @param start
	 * @param end
	 * @return
	 */
	boolean isBusy(Long id, Date start, Date end);
}
