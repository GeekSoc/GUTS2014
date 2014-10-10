package org.geeksoc.guts2014;

import java.util.Random;

public class Job {
	
	private static Random random = new Random();

	// Attributes
	private static String[] jobTypes = { "PHONE", "EMAIL", "WEBCHAT", "SOCIAL" };
	private static String jobType;
	private static int jobDifficulty;
	
	
	public Job() {
		jobType = jobTypes[randomNumber(0, 3)];
		jobDifficulty = randomNumber(0,100);
	}
	
	public static String getJobType() {
		return jobType;
	}
	
	public static int getJobDifficulty() {
		return jobDifficulty;
	}
	
	public static int randomNumber(int min, int max) {
		return random.nextInt(max) + min;
	}
}
