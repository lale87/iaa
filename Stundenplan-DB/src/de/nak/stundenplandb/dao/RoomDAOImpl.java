package de.nak.stundenplandb.dao;

import java.util.Date;

import de.nak.stundenplandb.model.Room;

/**
 * Implemenation des RoomDAO
 * 
 * @author Lars Lembke, Fabian Kolossa
 *
 */
public class RoomDAOImpl extends GenericDAOImpl<Room> implements RoomDAO {

	public RoomDAOImpl() {
		super(Room.class);
	}

//	@Override
//	@Deprecated
//	public boolean isOccupied(Long id, Date startDate, Date endDate) {
//		return !(sessionFactory.getCurrentSession().createQuery("SELECT a FROM Appointment a JOIN a.meeting m JOIN m.rooms r WHERE r.id = :id "
//				+ "AND ( "
//				+ 	"( "
//						// Läuft in den Termin
//				+ 		"a.start >= :startDate "
//				+ 		"AND a.end >= :startDate "
//				+ 	") OR ( "
//						// s' < s && e' >= s
//				+ 		"a.end <=  :endDate "
//				+ 		"AND a.end >= :startDate "
//				+ 	") OR ( "
//						// s' <= e && e' > e
//				+ 		"a.start <= :startDate "
//				+ 		"AND a.end >= :endDate "
//				+ 	") "
//				+ ")").setLong("id", id)
//		.setDate("startDate", startDate)
//		.setDate("endDate", endDate).list().isEmpty());
//	}
}
