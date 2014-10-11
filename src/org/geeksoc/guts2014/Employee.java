package org.geeksoc.guts2014;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Employee
 * 
 * @author Chris Bean (lastsplash)
 *
 */
public class Employee {
	// The total skill an employee should have, as the sum of their four skills.
	private static int MAX_SKILL = 100;
	// The HashMap for storing employee's skills.
	private HashMap<JobType, Integer> skills;
	
	/**
	 * Creates a new Employee with a random mix of skills.
	 */
	public Employee() {
		/*
		 * Employee skill is set to a random number up to 20
		 * 
		 */
		skills = new HashMap<JobType, Integer>();
		
		// TODO: test all this.
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		
		skills.put(JobType.Email, 			rand.nextInt(20));
		skills.put(JobType.Phone, 			rand.nextInt(20));
		skills.put(JobType.Text,				rand.nextInt(20));
		skills.put(JobType.SocialMedia,	rand.nextInt(20));
		
	}
	
	/**
	 * 
	 * @return WorkPacket specifying amount of work done.
	 */
	public WorkPacket work(HashMap<JobType, Integer> workPriorities) {
		/*
		 * TODO: Calculate work done.
		 * TODO: Have employee learn from experience.
		 */
		
		return new WorkPacket(0, 0, 0, 0); // TODO: proper variables
	}
	
	/**
	 * Improve an employee's skill in a given JobType
	 * by the "percentage" passed as the second paramater.
	 * 
	 * @param jobType, percentage
	 */
	public void train(JobType jobType, int percentage) {
		int trained = skills.get(jobType) + percentage;
		skills.put(jobType, (trained > MAX_SKILL) ? MAX_SKILL : trained);
	}

}
