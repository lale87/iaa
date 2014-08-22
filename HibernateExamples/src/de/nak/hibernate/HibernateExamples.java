package de.nak.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.nak.hibernate.model.Room;

/**
 * Main Klasse der Anwendung
 * @author Lars
 *
 */
public class HibernateExamples {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Room room = new Room();
//		room.setBuilding("A");
//		room.setRoomNumber(1);
//		room.setSeats(40);
//		room.setBeamerPresent(true);
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();
//		currentSession.save(room);
		Room room = (Room) currentSession.get(Room.class, 1L);
		room.setBuilding("B");
		//TODO Welcher Typ?
		List rooms = currentSession.createQuery("from Room room WHERE room.building = 'B'").list();
		room.setSeats(45);
		System.out.println(room.getBuilding());
		System.out.println(room.getSeats());
		currentSession.getTransaction().commit();
		
	}

}
