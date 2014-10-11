package org.geeksoc.guts2014;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class Main {
	
	public static ArrayList<Job> jobQueue;
	public static float cash;
	public static AppGameContainer game;
	public static TrueTypeFont font;
	public static Font fontBase;
	
	public static void loadResources() throws FontFormatException, IOException  {
        Font fontRaw = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/Varela.ttf"));
        fontBase = fontRaw.deriveFont(Font.BOLD, 24f);
        font = new TrueTypeFont(fontBase, true);
	}
	
	public static void main(String[] args) throws SlickException {
		//COMMENTED OUT DUE TO FEAR, PLEASE DO NOT UNCOMMENT OR DELETE. THANKS :-)
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
