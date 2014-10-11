package org.geeksoc.guts2014.render;

import java.math.*;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.RoundedRectangle;

public class RoomRenderer {
	
	private int peepradius = 10;                   //size of people before any modifications
	private int hallwayWidth = 10;


	public void render(Graphics g, GameContainer c,int nRooms, int[] people) { // nrooms is the number of rooms and 'people'
		                                           // is an array containing number in room
		g.setColor(Color.black);
		int nRows = (int) Math.ceil(Math.sqrt(nRooms));
		int cc;
		int cr;
		int x;
		int y;
		
		float rHorSize= (c.getWidth()-100-(nRows+1)*hallwayWidth)/nRows;
		float rVerSize= (c.getHeight()-100-(nRows+1)*hallwayWidth)/nRows;
		
		for(int i=0; i<nRooms; i++) {
			cr=i/nRows+1;
			cc=i%nRows;
			x=((cc+1)*hallwayWidth) + (cc*(int)rHorSize-1)+50;
			y=(cr*hallwayWidth) + ((cr-1)*(int)rVerSize-1)+80;
			g.setLineWidth(3);
			g.draw(new RoundedRectangle(x,y,rHorSize,rVerSize, rHorSize/20));
		}
	}
}
