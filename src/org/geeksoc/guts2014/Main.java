package org.geeksoc.guts2014;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer game = new AppGameContainer(new Game("geeksoc"));
	}

}
