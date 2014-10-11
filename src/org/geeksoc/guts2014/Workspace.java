package org.geeksoc.guts2014;

import java.util.ArrayList;

import org.geeksoc.guts2014.render.WorkspaceRenderer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Workspace extends WorkerSpace {
	
	Workload wl;
	WorkspaceRenderer wr;
	ArrayList<Section> sections;
	
	public Workspace(){
		wr = new WorkspaceRenderer(this);
	}
	
	public void update(){
		for(Section s : sections){
			s.update();
		}
		
	}

	public void submitWork(WorkPacket wp) {
		//wl.submit(wp)
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g){
		wr.render(container,game,g);
	}

	public String getTime() {
		// TODO Auto-generated method stub
		return "12:00";
	}

	public Workload getWorkload() {
		// TODO Auto-generated method stub
		return null;
	}

}
