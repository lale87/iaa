package de.nak.stundenplandb.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.nak.stundenplandb.dao.RoomDAO;
import de.nak.stundenplandb.model.ERoomType;
import de.nak.stundenplandb.model.Room;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"/spring-test-db-config.xml",
		"/spring-beans-config.xml"})
public class ExampleSpringTest {

	@Autowired
	private RoomDAO roomDao;

	@Test
	public void createNewRoomTest() {
		Room room = new Room();
		room.setRoomType(ERoomType.CLASSROOM);
		room.setBuilding("A");
		room.setRoomNumber(101);
		room.setSeats(34);
		room.setChangingTime(25);
		
		roomDao.save(room);
	}
	
	@Test
	public void isRoomDaoSetBySpringTest() {
		assertNotNull("RoomDao nicht gesetzt.", roomDao);
	}

}
