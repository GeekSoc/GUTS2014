package org.geeksoc.guts2014;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Job {
	
	private static Random random = new Random();

	// Attributes
	private static JobType jobType;
	private static int jobDifficulty;
	
	
	public Job Job() {
		List<JobType> jobTypes = Collections.unmodifiableList(Arrays.asList(JobType.values()));
		jobType = jobTypes.get(randomNumber(0, jobTypes.size()));
		jobDifficulty = randomNumber(0,100);
		return this;
	}
	
	
	public static JobType getJobType() {
		return jobType;
	}
	
	public static int getJobDifficulty() {
		return jobDifficulty;
	}
	
	public static int randomNumber(int min, int max) {
		return random.nextInt(max) + min;
	}
}
