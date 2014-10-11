package org.geeksoc.guts2014;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class JobFactory {
	
	private static int MIN_WAIT = 1000; // 1000 ms is minimum time between new jobs being created
	private static int MAX_WAIT = 3000; // 3000 ms is maximum time between new jobs being created
	
	private static Random random = new Random();
	private static boolean isRunning;
	private static Timer timer = new Timer();
	
	
	private Queue<Job> jobQueue = new LinkedList<Job>();
	
	public static void main(String[] args) {
		JobFactory jobFactory = new JobFactory();
		jobFactory.startJobCreation();		
	}
	
	public Queue<Job> getJobQueue() {
		return jobQueue;
	}
	
	public void addInitialJobs(int max) {
		for(int i = 1; i <= max; i++) {
			Job job = new Job();
			jobQueue.add(job);
			System.out.println(
				String.format("Initial job %d: %s",
					i,
					job.toString()
				)
			);
		}
	}
	
	class Task extends TimerTask {
		@Override
		public void run() {
			int randomWait = randomNumber(MIN_WAIT, MAX_WAIT);
			timer.schedule(new Task(), randomWait);
			Job job = new Job();
			jobQueue.add(job);
			
			System.out.println(
				String.format(
					"Job added (%dms) - %s",
					randomWait,
					job.toString()
				)
			);
		}
	}
	
	public void createJobs() {
		if(isRunning) {
			new Task().run();
		}
	}
	
	public void setWaitingTimes(int min, int max) {
		MIN_WAIT = min;
		MAX_WAIT = max;
	}
	
	public void startJobCreation() {
		clearJobs();
		isRunning = true;
		createJobs();
	}
	
	public void stopJobCreation() {
		timer = new Timer();
		clearJobs();
		isRunning = false;
	}
	
	public void clearJobs() {
		jobQueue.clear();
	}
	public int numJobs() {
		return jobQueue.size();
	}
	
	public static int randomNumber(int min, int max) {
		return random.nextInt(max) + min;
	}
}
