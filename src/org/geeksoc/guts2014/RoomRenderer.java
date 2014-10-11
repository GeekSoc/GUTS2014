package org.geeksoc.guts2014;

import java.math.*;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class RoomRenderer {
	
	private Graphics graphics;
	private GameContainer container;
	private int peepradius = 10;                   //size of people before any modifications
	private int hallwayWidth = 10;
	
	public RoomRenderer(Graphics g, GameContainer c) {
		graphics = g;
		container = c;
	}

	public void render(int nRooms, int[] people) { // nrooms is the number of rooms and 'people'
		                                           // is an array containing number in room
		
		int nRows = (int) Math.ceil(Math.sqrt(nRooms));
		int cc;
		int cr;
		int x;
		int y;
		
		float rHorSize= (container.getWidth()-(nRows+1)*hallwayWidth)/nRows;
		float rVerSize= (container.getHeight()-(nRows+1)*hallwayWidth)/nRows;
		
		for(int i=0; i<nRooms; i++) {
			cr=i/nRows+1;
			cc=i%nRows;
			x=((cc+1)*hallwayWidth) + (cc*(int)rHorSize-1);
			y=(cr*hallwayWidth) + ((cr-1)*(int)rVerSize-1);
			graphics.draw(new Rectangle(x,y,rHorSize,rVerSize));
		}
	}
}
