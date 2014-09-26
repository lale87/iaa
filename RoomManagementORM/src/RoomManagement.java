import de.nak.roommgmt.ApplicationController;
import de.nak.roommgmt.action.*;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Main class of the room management application.
 *
 * @author Stephan Anft
 */
public class RoomManagement {

	/**
	 * Runs the application.
	 *
	 * @param args Arguments (not supported).
	 */
	public static void main(String[] args) {
		ApplicationController controller = new ApplicationController();
		// Create Spring context
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		// Create list of actions
		List<Action> actions = new ArrayList<Action>();
		actions.add(new ExitAction(context));
		actions.add(new ListRoomsAction(context));
		actions.add(new ShowRoomAction(context));
		actions.add(new CreateRoomAction(context));
		actions.add(new UpdateRoomAction(context));
		actions.add(new DeleteRoomAction(context));
		actions.add(new ListCoursesAction(context));
		actions.add(new ShowCourseAction(context));
		actions.add(new CreateCourseAction(context));
		actions.add(new UpdateCourseAction(context));
		actions.add(new DeleteCourseAction(context));
		actions.add(new ListLecturesAction(context));
		actions.add(new CreateLectureAction(context));
		actions.add(new DeleteLectureAction(context));
		controller.setActions(actions);
		// Show menu
		controller.showMenu();
	}
}
