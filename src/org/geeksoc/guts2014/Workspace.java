package org.geeksoc.guts2014;

import java.util.ArrayList;

import org.geeksoc.guts2014.controls.TimeControls;
import org.geeksoc.guts2014.render.WorkLoadRenderer;
import org.geeksoc.guts2014.render.WorkspaceRenderer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Workspace extends WorkerSpace {
	
	Workload wl;
	WorkspaceRenderer wr;
	ArrayList<Section> sections;
	GameTime gt;
	JobFactory jf;
	private TimeControls timeControls;
	
	public Workspace(){
		wr = new WorkspaceRenderer(this);
		
		jf = new JobFactory();
		gt = new GameTime(jf,12,0);
		wl = new Workload(jf);
		jf.addInitialJobs(10);
		jf.startJobCreation();
		timeControls = new TimeControls(gt);
	}
	
	public void update(int delta){
		//for(Section s : sections){
		//	s.update();
		//}
		gt.incrementTime(delta);
		wl.update();
	}

	

	public void submitWork(WorkPacket wp) {
		//wl.submit(wp)
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g){
		wr.render(container,game,g);
		timeControls.setcoords(container.getWidth()-100, 40);
		timeControls.render(g, container);
		WorkLoadRenderer.render(g,wl,5,container.getHeight()-20);
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
