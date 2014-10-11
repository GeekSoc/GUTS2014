package org.geeksoc.guts2014;

import java.util.ArrayList;

import org.geeksoc.guts2014.controls.TimeControls;
import org.geeksoc.guts2014.render.WorkLoadRenderer;
import org.geeksoc.guts2014.render.WorkspaceRenderer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Workspace extends WorkerSpace {

	Workload wl;
	WorkspaceRenderer wr;
	GameTime gt;
	JobFactory jf;
	private TimeControls timeControls;
	ArrayList<Section> rooms = new ArrayList<Section>();
	
	private RoundedRectangle addRoomButton;
	
	public Workspace() {
		wr = new WorkspaceRenderer(this);

		jf = new JobFactory();
		gt = new GameTime(jf, 12, 0);
		wl = new Workload(jf);
		jf.addInitialJobs(10);
		jf.startJobCreation();
		timeControls = new TimeControls(gt);
		for(int x=0;x<4; x++){
			rooms.add(new Section(this));
		}
		
		addRoomButton = new RoundedRectangle(20, 20, 20, 20, 0);
	}

	public void update(GameContainer cont,StateBasedGame game, int delta) {		
		for(Section s : rooms){
		s.update(cont);
		 }
		gt.incrementTime(delta);
		wl.update();
		
		if(cont.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			int mouseX = cont.getInput().getMouseX();
			int mouseY = cont.getInput().getMouseY();
			if (mouseX < addRoomButton.getMaxX()
					&& mouseX > addRoomButton.getMinX()
					&& mouseY < addRoomButton.getMaxY()
					&& mouseY > addRoomButton.getMinY()) {
				rooms.add(new Section(this));
			}
		}
		
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
		g.fill(addRoomButton);
		
	}

	public String getTime() {
		return gt.toString();
	}

	public Workload getWorkload() {
		return wl;
	}

	public ArrayList<Section> getRooms() {
		return rooms;
	}

	public int[] getWorkerCountPerRoom() {
		int[] res = new int[rooms.size()];
		int x=0;
		for(Section room:rooms){
			
			res[x] = room.getWorkerCount();
			x+=1;
		}
		return res;
	}
}
