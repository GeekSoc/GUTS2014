package org.geeksoc.guts2014;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	
	public static ArrayList<Job> jobQueue;
	public static float cash;
	public static AppGameContainer game;
	
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
		game = new AppGameContainer(g);
		game.setDisplayMode(800, 600, false);
		game.setShowFPS(false); 
		game.start();
		g.enterState(0);
		
	}
	
	

}
