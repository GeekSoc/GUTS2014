package org.geeksoc.guts2014.render;

import org.geeksoc.guts2014.Workload;
import org.geeksoc.guts2014.Workspace;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class WorkspaceRenderer {
	
	private Workspace w;

	public WorkspaceRenderer(Workspace w){
		this.w = w;
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		renderBackground(g,container);
		renderTime(g,w.getTime());
		renderWorkload(g,w.getWorkload());
		renderWorkerList(g,w);
		renderControls();
		renderWorkplace();
		
		
	}

	private void renderWorkplace() {
		// TODO Auto-generated method stub
		
	}

	private void renderControls() {
		// TODO Auto-generated method stub
		
	}

	private void renderWorkerList(Graphics g, Workspace w) {
		for(int i = 0; i < w.getWorkerCount();i++){
			
		}
		
	}

	private void renderWorkload(Graphics g, Workload workload) {
		
		
	}

	private void renderTime(Graphics g, String time) {
		g.drawString(w.getTime(), 10, 100);
		
		
	}

	private void renderBackground(Graphics g, GameContainer container) {
		g.setColor(Color.green);
		g.drawRect(0, 0, container.getWidth(), container.getHeight());
		
	}
	
	

}
