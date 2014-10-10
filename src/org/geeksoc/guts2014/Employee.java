package org.geeksoc.guts2014;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * 
 * @author Chris Bean (lastsplash)
 *
 */
public class Employee {
	// The total skill an employee should have, as the sum of their four skills.
	private static int MAX_SKILL = 100;
	private HashMap<JobType, Integer> skills;
	
	/**
	 * Create a new Employee with a low skill level.
	 */
	public Employee() {
		/*
		 * Employee skill is set to 0 by default.
		 * 
		 * TODO: Make skills initially a random mixture of skills.
		 */
		skills = new HashMap<JobType, Integer>();
		
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		
		skills.put(JobType.Email, 			rand.nextInt(100));
		skills.put(JobType.Phone, 			rand.nextInt(100));
		skills.put(JobType.Text,				rand.nextInt(100));
		skills.put(JobType.SocialMedia,	rand.nextInt(100));
		
		int totalSkill = totalOfHashMapValues(skills);
		
		if (totalSkill != MAX_SKILL) {
			int divisor = MAX_SKILL/totalSkill;
			
			for (Map.Entry<JobType, Integer> entry : skills.entrySet()) {
				skills.put(entry.getKey(), entry.getValue() / divisor); 
			}
			
			totalSkill = totalOfHashMapValues(skills);
		}
	}
	
	private int totalOfHashMapValues(HashMap<JobType, Integer> map) {
		int total = 0;
		for (int value : skills.values()) {
			total += value;
		}
		return total;
	}

}
