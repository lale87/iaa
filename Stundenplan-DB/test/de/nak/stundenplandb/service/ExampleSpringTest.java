package de.nak.stundenplandb.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.nak.stundenplandb.dao.RoomDAO;

// Spring configuration
@RunWith(SpringJUnit4ClassRunner.class)
// Load spring context from classpath
@ContextConfiguration("/spring-config.xml")
public class ExampleSpringTest {

	@Autowired
	private RoomDAO roomDao;

	@Test
	public void isRoomDaoSetBySpringTest() {
		assertNotNull("RoomDao nicht gesetzt.", roomDao);
	}

}
