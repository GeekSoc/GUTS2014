package org.geeksoc.guts2014;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	
	public static ArrayList<Job> jobQueue;
	public static float cash;
	
	public static void main(String[] args) throws SlickException {
		//COMMENTED OUT DUE TO FEAR, DO NOT FUCKING UNCOMMENT OR DELETE
		//jobQueue = new ArrayList<Job>();
		//JobFactory jobFactory = new JobFactory();
		
		// Will add random job at random time interval to jobQueue of type Job
		//jobFactory.startJobCreation();
		// do not call this at update??
		
		// Will stop creating jobs, and empty the jobQueue
		//jobFactory.startJobCreation();
		
		
		Game g = new Game("geeksoc");
		AppGameContainer game = new AppGameContainer(g);
		game.setDisplayMode(640, 480, false);
		game.start();
		g.enterState(0);
		
	}
	
	

}
