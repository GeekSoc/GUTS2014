package org.geeksoc.guts2014;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class JobFactory {
	
	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private static ArrayList<Job> jobs;
	
	
	public static void main(String[] args) {
<<<<<<< HEAD
		jobs = new ArrayList<Job>();
		createJobs();
	}
	
	public static void createJobs() {
		final Runnable beeper = new Runnable() {
			public void run() { 
				jobs.add(new Job());
			}
		};
		
		
		ScheduledFuture<?> handler;
		
		
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);
		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true); 
			}
		}, 60 * 60, TimeUnit.SECONDS);
=======
		Timer timer = new Timer();
>>>>>>> 4d28642ed3627071f73a63037f9b8db01525b644
	}
		
		
	
 // updateTime
	
}
