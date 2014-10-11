package org.geeksoc.guts2014;

import java.util.HashMap;
import java.util.Map.Entry;
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
		 */
		skills = new HashMap<JobType, Integer>();

		// TODO: test all this.
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		skills.put(JobType.Email, rand.nextInt(20));
		skills.put(JobType.Phone, rand.nextInt(20));
		skills.put(JobType.Text, rand.nextInt(20));
		skills.put(JobType.SocialMedia, rand.nextInt(20));

	}

	/**
	 * 
	 * Work priority passed in range 0 - 100 please
	 * 
	 * @return WorkPacket specifying amount of work done.
	 */
	public WorkPacket work(HashMap<JobType, Integer> workPriorities) {
		/*
		 * TODO: Have employee learn from experience.
		 */
		
		HashMap<JobType, Integer> workDone = new HashMap<JobType, Integer>();

		for (Entry<JobType, Integer> entry : workPriorities.entrySet()) {
			JobType jobType = entry.getKey();
			int priority = entry.getValue();

			/*
			 * skill in range 0 - 100, priority in range 0 - 100. Divide by 100 to
			 * keep numbers at the right size.
			 */
			workDone.put(jobType, (skills.get(jobType) * priority) / 100);
		}

		return new WorkPacket(workDone);
	}

	/**
	 * Improve an employee's skill in a given JobType by the "percentage" passed
	 * as the second parameter.
	 * 
	 * @param jobType
	 *          , percentage
	 */
	public void train(JobType jobType, int percentage) {
		int trained = skills.get(jobType) + percentage;
		skills.put(jobType, (trained > MAX_SKILL) ? MAX_SKILL : trained);
	}

}
