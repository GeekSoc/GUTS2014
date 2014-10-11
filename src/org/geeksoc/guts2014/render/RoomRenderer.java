package org.geeksoc.guts2014.render;

import java.math.*;
import java.util.ArrayList;

import org.geeksoc.guts2014.Employee;
import org.geeksoc.guts2014.Section;
import org.geeksoc.guts2014.controls.Slider;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.RoundedRectangle;

public class RoomRenderer {
	
	private final int peepRadius = 10;                   //size of people before any modifications
	private final int hallwayWidth = 10;
	private final int roomTopMargin = 80;
	private final int roomSideMargin = 5;
	private final int peepGap = 5;


	public void render(Graphics g, GameContainer c,ArrayList<Section> s, int[] people) { // nrooms is the number of rooms and 'people'
		                                           // is an array containing number in room
		
		g.setColor(new Color(240, 240, 240));
		int nRows = (int) Math.ceil(Math.sqrt(s.size()));
		int cc;
		int cr;
		int x;
		int y;
		
		int centerPointerX;
		int centerPointerY;
		int tempPrev;
		//WARNING: MATHS
		float rHorSize= (c.getWidth()-100-(nRows+1)*hallwayWidth)/nRows;
		float rVerSize= (c.getHeight()-100-(nRows+1)*hallwayWidth)/nRows;
		int i=0;
		for(Section sec:s) {
			cr=i/nRows+1;
			cc=i%nRows;
			x=((cc+1)*hallwayWidth) + (cc*(int)rHorSize-1)+50;
			y=(cr*hallwayWidth) + ((cr-1)*(int)rVerSize-1)+80;
			//g.setLineWidth(3);
			g.setColor(new Color(240, 240, 240));
			sec.rectangle = new RoundedRectangle(x,y,rHorSize,rVerSize, rHorSize/20);
			g.fill(sec.rectangle);
			sec.render(g,x,y);
			
			centerPointerX = roomSideMargin+peepRadius+x;
			centerPointerY = roomTopMargin+peepRadius+y;
			tempPrev=centerPointerX;
			for(Employee e:sec.getWorkers()) {
				e.move(centerPointerX, centerPointerY);
				e.render(g);
				centerPointerX = centerPointerX + 2*peepRadius + peepGap;
				if (centerPointerX+peepRadius>x+rHorSize) {
					centerPointerX = tempPrev;
					centerPointerY = centerPointerY + 2*peepRadius + peepGap;
				}
			}
			
			
			i++;
			
		}
		
	}
}
