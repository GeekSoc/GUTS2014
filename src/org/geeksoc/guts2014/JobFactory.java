package org.geeksoc.guts2014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.geeksoc.guts2014.randomevents.RandomEventGenerator;

public class JobFactory {

	private static double lambda = 2.0; // rate in the poisson process

	private static Random random = new Random();
	public static boolean isRunning;
	private static Timer timer = new Timer();

	private Queue<Job> jobQueue = new LinkedList<Job>();

	public void update() {
		int speed = GameTime.getSpeed();
		if (speed == 0) {
			stopJobCreation();
		} else {
			if (!isRunning) {
				startJobCreation();
			}
			setLambda(speed / 1000.0);
		}
	}

	public Queue<Job> getJobQueue() {
		return jobQueue;
	}

	public void addInitialJobs(int max) {
		for (int i = 1; i <= max; i++) {
			Job job = new Job();
			jobQueue.add(job);
			//System.out.println(String.format("Initial job %d: %s", i, job.toString()));
		}
	}

	class Task extends TimerTask {
		@Override
		public void run() {
			double randomWait = -Math.log(1.0 - random.nextDouble()) / lambda;
			long randomWait_ms = (long) randomWait;
			timer.schedule(new Task(), randomWait_ms);
			Job job = new Job();
			jobQueue.add(job);
			if(random.nextInt(100)==0)RandomEventGenerator.generateEvent(jobQueue);
			System.out.println(String.format("Job added (%dms) - %s",
					randomWait_ms, job.toString()));
		}
	}

	public void createJobs() {
		this.update();
		if (isRunning) {
			new Task().run();
		}
	}

	public void startJobCreation() {
		clearJobs();
		isRunning = true;
		createJobs();
	}

	public void stopJobCreation() {
		timer.cancel();
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

	public void setLambda(double lmb) {
		lambda = lmb;
	}
}
