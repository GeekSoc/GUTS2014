package org.geeksoc.guts2014;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Job {

	private static Random random = new Random();

	// Attributes
	private  JobType jobType;
	private  String jobTypeName;
	private  int jobDifficulty;

	private int jobProgress;

	public Job() {
		List<JobType> jobTypes = Collections.unmodifiableList(Arrays
				.asList(JobType.values()));
		int rndJobType = randomNumber(0, jobTypes.size());
		jobDifficulty = randomNumber(0, 100);
		jobType = jobTypes.get(rndJobType);
		jobTypeName = jobTypes.get(rndJobType).name();
		return;
	}

	public Job(JobType jobType) {
		
		jobDifficulty = randomNumber(0, 100);
		this.jobType = jobType;
		jobTypeName = jobType.name();
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

	public boolean workDone(int workDone) {
		jobProgress += workDone;
		if(jobProgress >= jobDifficulty)System.out.println("Done");
		return jobProgress >= jobDifficulty;
	}
}
