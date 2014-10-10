package org.geeksoc.guts2014;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class JobFactory {
	
	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private static ArrayList<Job> jobs;
	private static boolean isRunning;
	
	
	public static void main(String[] args) {
		isRunning = true;
		jobs = new ArrayList<Job>();
	}
	
	public void startJobCreation() {
		isRunning = true;
		createJobs();
	}
	
	public void cancelJobCreation() {
		isRunning = false;
	}
	
	public void clearJobs() {
		Main.jobQueue.clear();
	}
	
	public void createJobs() {
		if(!isRunning) {
			
			// randomly create a job
			Main.jobQueue.add(new Job());
			
		}
	}
		
		
	
 // updateTime
	
}
