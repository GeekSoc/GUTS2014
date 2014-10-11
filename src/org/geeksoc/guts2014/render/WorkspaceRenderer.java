package org.geeksoc.guts2014.render;

import java.awt.Font;

import org.geeksoc.guts2014.Employee;
import org.geeksoc.guts2014.Main;
import org.geeksoc.guts2014.Workspace;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class WorkspaceRenderer {

	private Workspace w;
	private TrueTypeFont font;
	private RoomRenderer rr;

	public WorkspaceRenderer(Workspace w) {
		this.w = w;
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, true);
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
		g.setFont(font);
		g.drawString(w.getTime(), container.getWidth() - 100, 20);
		// System.out.println(container.getWidth()+":"+ container.getHeight());
		
		//Render Money
		g.drawString(Float.toString(Main.cash), container.getWidth()/2, 20);
		
		// Render Workload

		// Render Unused Workers

		// renderControls
		for(Employee e:w.getWorkers()){
			e.setCenterY(container.getWidth()-10);
			e.setCenterX(container.getHeight()-10);
			g.setColor(Color.magenta);
			g.fill(e);
		}
		// renderRooms
		rr.render(g, container, w.getRooms(), w.getWorkerCountPerRoom());
	}

}
