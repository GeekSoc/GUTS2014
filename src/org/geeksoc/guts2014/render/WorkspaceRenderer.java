package org.geeksoc.guts2014.render;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

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
	
	private void loadResources() throws FontFormatException, IOException  {
        Font fontRaw = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/Varela.ttf"));
        Font fontBase = fontRaw.deriveFont(Font.BOLD, 24f);
        font = new TrueTypeFont(fontBase, true);
	}

	public WorkspaceRenderer(Workspace w) {
		this.w = w;
		
		try {
			loadResources();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		int i = 0;
		for(Employee e:w.getWorkers()){
			e.move(container.getWidth()-10,container.getHeight()-10-(i*20));
			e.render(g);
			
			i++;
		}
		// renderRooms
		rr.render(g, container, w.getRooms(), w.getWorkerCountPerRoom());
	}

}
