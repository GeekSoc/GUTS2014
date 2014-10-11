package org.geeksoc.guts2014;

import java.util.ArrayList;

import org.geeksoc.guts2014.controls.TimeControls;
import org.geeksoc.guts2014.render.WorkspaceRenderer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Workspace extends WorkerSpace {
	
	Workload wl;
	WorkspaceRenderer wr;
	ArrayList<Section> sections;
	GameTime gt;
	private TimeControls timeControls;
	
	public Workspace(){
		wr = new WorkspaceRenderer(this);
		gt = new GameTime(12,0);
		timeControls = new TimeControls(gt);
	}
	
	public void update(int delta){
		//for(Section s : sections){
		//	s.update();
		//}
		gt.incrementTime(delta);
		
	}

	

	public void submitWork(WorkPacket wp) {
		//wl.submit(wp)
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g){
		wr.render(container,game,g);
		timeControls.setcoords(container.getWidth()-100, 40);
		timeControls.render(g, container);
	}

	public String getTime() {
		// TODO Auto-generated method stub
		return gt.toString();
	}

	public Workload getWorkload() {
		// TODO Auto-generated method stub
		return null;
	}



}
