package org.geeksoc.guts2014;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) throws SlickException {
		/*
		 * Queue<Job> jobQueue = new LinkedList<Job>(); JobFactory jobFactory =
		 * new JobFactory(); // Set the rate of jobs per second
		 * jobFactory.setLambda(2.0); // Add a few jobs to start with
		 * jobFactory.addInitialJobs(10); // Will add random job at random time
		 * interval to jobQueue of type Job jobFactory.startJobCreation(); //
		 * call this in update jobQueue = jobFactory.getJobQueue(); // Will stop
		 * creating jobs, and empty the jobQueue jobFactory.stopJobCreation();
		 */

		AppGameContainer game = new AppGameContainer(new Game("geeksoc"));

		game.start();
	}

}
