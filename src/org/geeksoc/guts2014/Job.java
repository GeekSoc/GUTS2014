package org.geeksoc.guts2014;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Job {

	private static Random random = new Random();

	// Attributes
	private static JobType jobType;
	private static String jobTypeName;
	private static int jobDifficulty;

	public Job() {
		List<JobType> jobTypes = Collections.unmodifiableList(Arrays
				.asList(JobType.values()));
		int rndJobType = randomNumber(0, jobTypes.size());
		jobDifficulty = randomNumber(0, 100);
		jobType = jobTypes.get(rndJobType);
		jobTypeName = jobTypes.get(rndJobType).name();
		return;
	}

	public JobType getJobType() {
		return jobType;
	}

	public String getJobTypeName() {
		return jobTypeName;
	}

	public int getJobDifficulty() {
		return jobDifficulty;
	}

	public String toString() {
		return String.format("Job type: %s. Job Difficulty: %d",
				getJobTypeName(), getJobDifficulty());
	}

	public static int randomNumber(int min, int max) {
		return random.nextInt(max) + min;
	}
}
