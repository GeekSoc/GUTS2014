package org.geeksoc.guts2014.render;

import java.awt.Canvas;
import java.awt.FontMetrics;

import org.geeksoc.guts2014.Employee;
import org.geeksoc.guts2014.Main;
import org.geeksoc.guts2014.Workspace;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class WorkspaceRenderer {

	private Workspace w;
	private RoomRenderer rr;
	private int flashtimer;
	private String flash;
	

	public WorkspaceRenderer(Workspace w) {
		this.w = w;		
		rr= new RoomRenderer();
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		// renderBackground
		g.setColor(Color.white);
		Rectangle r = new Rectangle(0, 0, container.getWidth(),
				container.getHeight());
		g.fill(r);

		// Render Time
		g.setColor(Color.black);
		g.setFont(Main.font);
		g.drawString(w.getTime(), container.getWidth() - 100, 20);
		// System.out.println(container.getWidth()+":"+ container.getHeight());
		
		//Render Money
		Canvas c = new Canvas();
		FontMetrics metrics = c.getFontMetrics(Main.fontBase);
		if (Main.cash<0){
			g.setColor(new Color(0xfa, 0x80, 0x72));
		}
		g.drawString(String.format("£" + "%.2f", Main.cash), container.getWidth()/2-metrics.stringWidth(String.format("£" + "%.2f", Main.cash))/2, 20);
		
		g.setColor(Color.black);
		
		//Render Metrics
		if (Main.rep<50){
			g.setColor(new Color(0xfa, 0x80, 0x72));
		}
		g.drawString(Main.rep+ " Rep", container.getWidth()/4-metrics.stringWidth( Main.rep+ " Rep")/2, 20);
		
		g.setColor(Color.black);
		
		
		if(Main.flash != null){
			flash = Main.flash;
			flashtimer = 100;
		}
		if(flashtimer > 0){
		g.drawString(flash, container.getWidth()/4-metrics.stringWidth( flash)/2, container.getHeight()-20);
		flashtimer--;
		}
		// Render Workload

		// Render Unused Workers

		// renderControls
		int i = 0;
		for(Employee e:w.getWorkers()){
			e.move(container.getWidth() - 15,container.getHeight()-40-(i*20));
			e.render(g);
			
			i++;
		}
		// renderRooms
		rr.render(g, container, w.getRooms(), w.getWorkerCountPerRoom());
	}

}
