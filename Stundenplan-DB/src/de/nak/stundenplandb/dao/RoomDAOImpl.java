package de.nak.stundenplandb.dao;

import java.util.Date;
import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getFreeRoomsForTimeperiod(Date start, Date end) {
		List<Room> r = sessionFactory
				.getCurrentSession().createQuery(
						"SELECT mr FROM Meeting m "
					+ 	"JOIN m.rooms mr "
					+ 	"JOIN m.appointments a ")
//					+ 	"WHERE "
//					+ 	"( "
//					+ 		"( "
//								// s' >= s && e' <= e
//					+ 			"a.start >= :startDate "
//					+ 			"AND a.end <= :endDate "
//					+ 		") OR ( "
//								// s' < s && e' >= s
//					+ 			"a.start < :startDate "
//					+ 			"AND a.end >= :startDate "
//					+ 		") OR ( "
//								// s' <= e && e' > e
//					+ 			"a.start <= :endDate "
//					+ 			"AND a.end > :endDate "
//					+ 		") "
//					+ 	")")
//				.setDate("startDate", start)
//				.setDate("endDate", end)
				.list();
		List<Room> rooms = sessionFactory
				.getCurrentSession().createQuery(
				"SELECT r FROM Room r "
				+ "WHERE r NOT IN "
				+ "( "
				+ 	"SELECT mr FROM Meeting m "
				+ 	"JOIN m.rooms mr "
				+ 	"JOIN m.appointments a "
				+ 	"WHERE "
				+ 	"( "
				+ 		"( "
							// s' >= s && e' <= e
				+ 			"a.start >= :startDate "
				+ 			"AND a.end <= :endDate "
				+ 		") OR ( "
							// s' < s && e' >= s
				+ 			"a.start < :startDate "
				+ 			"AND a.end >= :startDate "
				+ 		") OR ( "
							// s' <= e && e' > e
				+ 			"a.start <= :endDate "
				+ 			"AND a.end > :endDate "
				+ 		") "
				+ 	") "
				+ ") "
				+ "ORDER BY r.building ASC, r.roomNumber ASC")
				.setDate("startDate", start)
				.setDate("endDate", end)
				.list();
		return rooms;
	}

	@Override
	public boolean isFreeForTimeperiod(Room room, Date start, Date end) {
		return sessionFactory.getCurrentSession().createQuery(
				"SELECT a FROM Appointment a "
				+ "JOIN a.meeting m "
				+ "JOIN m.rooms r WHERE r = :room "
				+ "AND ( "
				+ 	"( "
						// s' >= s && e' <= e
				+ 		"a.start >= :startDate "
				+ 		"AND a.end <= :endDate "
				+ 	") OR ( "
						// s' < s && e' >= s
				+ 		"a.start < :startDate "
				+ 		"AND a.end >= :startDate "
				+ 	") OR ( "
						// s' <= e && e' > e
				+ 		"a.start <= :endDate "
				+ 		"AND a.end > :endDate "
				+ 	") "
				+ ")")
				.setEntity("room", room)
				.setDate("startDate", start)
				.setDate("endDate", end)
				.list()
				.isEmpty();
	}

	@Override
	@Deprecated
	public boolean isOccupied(Long id, Date startDate, Date endDate) {
		return !(sessionFactory.getCurrentSession().createQuery("SELECT a FROM Appointment a JOIN a.meeting m JOIN m.rooms r WHERE r.id = :id "
				+ "AND ( "
				+ 	"( "
						// Läuft in den Termin
				+ 		"a.start >= :startDate "
				+ 		"AND a.end >= :startDate "
				+ 	") OR ( "
						// s' < s && e' >= s
				+ 		"a.end <=  :endDate "
				+ 		"AND a.end >= :startDate "
				+ 	") OR ( "
						// s' <= e && e' > e
				+ 		"a.start <= :startDate "
				+ 		"AND a.end >= :endDate "
				+ 	") "
				+ ")").setLong("id", id)
		.setDate("startDate", startDate)
		.setDate("endDate", endDate).list().isEmpty());
	}
}
