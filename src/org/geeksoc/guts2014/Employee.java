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
	// The maximum skill of an employee in any category
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
	public WorkPacket work() {
		WorkPacket wp = new WorkPacket();
		
		/*
		 * TODO: Calculate work done.
		 * TODO: Have employee learn from experience.
		 */
		
		return wp;
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
