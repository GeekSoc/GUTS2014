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
		 * Employee skill is set to 0 by default.
		 * 
		 * TODO: Make skills initially a random mixture of skills.
		 */
		skills = new HashMap<JobType, Integer>();
		
		// TODO: test all this.
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		
		skills.put(JobType.Email, rand.nextInt(100));
		skills.put(JobType.Phone, rand.nextInt(100));
		skills.put(JobType.Text, rand.nextInt(100));
		skills.put(JobType.SocialMedia, rand.nextInt(100));
		
		int totalSkill = totalOfHashMapValues(skills);
		
		if (totalSkill != MAX_SKILL) {
			int divisor = MAX_SKILL/totalSkill;
			
			for (Map.Entry<JobType, Integer> entry : skills.entrySet()) {
				skills.put(entry.getKey(), entry.getValue() / divisor); 
			}
			
			totalSkill = totalOfHashMapValues(skills);
			
			/*
			 * If the total skill is still not equal to MAX_SKILL, then,
			 * somewhat lazily, just add enough skill to phone skill such
			 * that the total skill is 100.
			 * 
			 * TODO: something better.
			 */
			if (totalSkill != MAX_SKILL) {
				skills.put(JobType.Phone, skills.get(JobType.Phone) + MAX_SKILL - totalSkill);
			}
		}
	}
	
	/**
	 * 
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
		skills.put(jobType, skills.get(jobType) + percentage);
	}
	
	/**
	 * Get the total of the values in a HashMap with the generics
	 * <JobType, Integer>
	 * 
	 * @param map
	 * @return total
	 */
	private int totalOfHashMapValues(HashMap<JobType, Integer> map) {
		int total = 0;
		for (int value : skills.values()) {
			total += value;
		}
		return total;
	}

}
