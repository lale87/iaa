package de.nak.stundenplandb.service;

import java.util.List;

import de.nak.stundenplandb.model.Room;
import de.nak.stundenplandb.model.StudentGroup;

/**
 * Schnittstelle für den StudentGroupService
 * @author Lars Lembke
 *
 */
public interface StudentGroupService {
	/**
	 * Creates StudentGroup.
	 *
	 * @param studentGroup
	 *            The studentGroup.
	 */
	void saveStudentGroup(StudentGroup studentGroup);

	/**
	 * Loads a list of all studentGroups.
	 *
	 * @return a list which is empty if no studentGroup was found.
	 */
	List<Room> loadAllStudentGroups();
}
