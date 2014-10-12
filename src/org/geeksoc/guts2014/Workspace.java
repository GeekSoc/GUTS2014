package org.geeksoc.guts2014;

import java.util.ArrayList;

import org.geeksoc.guts2014.controls.TimeControls;
import org.geeksoc.guts2014.render.WorkLoadRenderer;
import org.geeksoc.guts2014.render.WorkspaceRenderer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Workspace extends WorkerSpace {

	public static Workspace instance;
	public static boolean sliderLock;
	private final int ROOM_COST = 1000;
	Workload wl;
	WorkspaceRenderer wr;
	JobFactory jf;
	private TimeControls timeControls;
	ArrayList<Room> rooms = new ArrayList<Room>();
	private int maxRooms = 16;
	private int deltaCounter = 0;

	private Image addRoomButton;
	private Rectangle addRoomButton2;
	private Image rmRoomButton;
	private Rectangle rmRoomButton2;
	private Image hireWorker;
	private Rectangle hireWorker2;

	public Workspace() throws SlickException {
		instance = this;
		wr = new WorkspaceRenderer(this);

		jf = new JobFactory();
		wl = new Workload(jf);

		GameTime.setTime(12, 0);
		GameTime.setSpeed(0);

		timeControls = new TimeControls();
		for (int x = 0; x < 1; x++) {
			rooms.add(new Room(this));
		}

		addRoomButton = new Image("res/img/hire.png");
		rmRoomButton = new Image("res/img/unhire.png");
		hireWorker = new Image("res/img/hire.png");

		// Add 5 workers to workspace
		ArrayList<Employee> newEmployees = new ArrayList<Employee>();
		for (int i = 0; i < 5; i++) {
			newEmployees.add(new Employee(this));
		}
		addWorkers(newEmployees);
	}

	public void update(GameContainer cont, StateBasedGame game, int delta) {
		for (Room s : rooms) {

			s.update(cont, delta);
			jf.update();

		}

		GameTime.incrementTime(delta);
		wl.update();

		int gameSpeed = GameTime.getSpeed();
		if (gameSpeed > 0) {
			deltaCounter += delta;
			if (deltaCounter > 1000 / gameSpeed) {
				deltaCounter = 0;
				for (Employee e : this.employees) {
					e.work();
				}
			}
		}

		for (Employee e : this.employees) {
			e.update(cont);
		}
		
		if (cont.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

			int mouseX = cont.getInput().getMouseX();
			int mouseY = cont.getInput().getMouseY();
			if (addRoomButton2.contains(mouseX, mouseY) && rooms.size() < maxRooms) {
				rooms.add(new Room(this));
				Main.cash -= ROOM_COST;
			}
			if (rmRoomButton2.contains(mouseX, mouseY) && rooms.size() > 1) {
				Room roomO = rooms.get(1);
				roomO.transferWorkers(this, roomO.getWorkers());
				rooms.remove(1);
			}
			if (hireWorker2.contains(mouseX, mouseY)) {
				ArrayList<Employee> temp = new ArrayList<Employee>();
				temp.add(new Employee(this));
				addWorkers(temp);
			}
		}

		this.update();

	}

	public void submitWork(WorkPacket wp) {
		wl.submit(wp);

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		wr.render(container, game, g);
		timeControls.setcoords(container.getWidth() - 100, 40);
		timeControls.render(g, container);
		WorkLoadRenderer.render(g, wl, 5, container.getHeight() - 20);

		g.setColor(Color.black);
		addRoomButton.draw(20, 20, 20, 20);
		addRoomButton2 = new Rectangle(20, 20, 20, 20);
		rmRoomButton.draw(20, 40, 20, 20);
		rmRoomButton2 = new Rectangle(20, 40, 20, 20);
		hireWorker.draw(container.getWidth() - 25, container.getHeight() - 25, 20,
				20);
		hireWorker2 = new Rectangle(container.getWidth() - 25,
				container.getHeight() - 25, 20, 20);

	}

	public String getTime() {
		return GameTime.toStringHack();
	}

	public Workload getWorkload() {
		return wl;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public int[] getWorkerCountPerRoom() {
		int[] res = new int[rooms.size()];
		int x = 0;
		for (Room room : rooms) {

			res[x] = room.getWorkerCount();
			x += 1;
		}
		return res;
	}
}
