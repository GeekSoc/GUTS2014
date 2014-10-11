package org.geeksoc.guts2014.controls;

import org.geeksoc.guts2014.Workspace;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Slider{
	
	int x,y=0;
	int value=0;
	Rectangle slider;
	boolean sliderdown;
	
	public Slider(){

		slider = new Rectangle(x,y-5,5,10);
	}
	
	public void update(Input input){
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(!Workspace.sliderLock&&slider.contains(input.getMouseX(), input.getMouseY())){
				sliderdown=true;
				Workspace.sliderLock = true;
			}
		}
		if(sliderdown){
			slider.setCenterX(input.getAbsoluteMouseX());
			if(slider.getCenterX()>x+100){
				slider.setCenterX(x+100);
			}
			if(slider.getCenterX()<x){
				slider.setCenterX(x);
			}
			value= Math.round(slider.getCenterX()) -x;
			System.out.println("Slider changed value: " + value);
		}
		if(!input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			sliderdown =false;
			Workspace.sliderLock=false;
		}
		
	}
	
	public void render(Graphics g, int x2, int y2){
		x=x2;
		y=y2;
		slider.setCenterY(y2);
		slider.setCenterX(x2+value);
		g.fillRect(x, y, 100, 3);
		g.fill(slider);
	}
	
	public int getValue(){
		return value;
	}

	public void setValue(int i) {
		value = i;
		if (i>100) value = 100;
		if (i<0) value = 0;
		
	}

}
