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
	// The total maximum skill an employee should have, as the sum of their four
	// skills.
	private static int MAX_SKILL = 100;
	// Maximum skill bonus that experience can give
	private static int MAX_XP_BONUS = 10;
	// The HashMap for storing employee's skills.
	private HashMap<JobType, Integer> skills;
	// HashMap for storing the total amount of work done by employee on each job,
	// i.e. his experience as a percentage of jobs done. e.g. <JobType.Email,
	// 50000> means the employee has dealt with 500 emails.
	private HashMap<JobType, Integer> experience;

	/**
	 * Creates a new Employee with a random mix of skills.
	 */
	public Employee() {
		/*
		 * Employee skill is set to a random number up to 20
		 */
		skills = new HashMap<JobType, Integer>();
		experience = new HashMap<JobType, Integer>();

		// TODO: test all this.
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (JobType jobType : JobType.values()) {
			skills.put(jobType, rand.nextInt(20));
			experience.put(jobType, 0);
		}
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
			int jobDone = (skills.get(jobType) * priority) / MAX_SKILL;
			workDone.put(jobType, jobDone);
			// Add to experience
			experience.put(jobType, experience.get(jobType) + jobDone);
		}

		return new WorkPacket(workDone);
	}

	/**
	 * Improve an employee's skill in a given JobType by the "percentage" passed
	 * as the second parameter.
	 * 
	 * @param jobType, percentage
	 */
	public void train(JobType jobType, int percentage) {
		int trained = skills.get(jobType) + percentage;
		skills.put(jobType, (trained > MAX_SKILL) ? MAX_SKILL : trained);
	}
	
	public int getSkill(JobType jobType) {
		int skillLevel = skills.get(jobType);
		int experienceLevel = experience.get(jobType);
		// Weight the experience level far lower than skillLevel.
		experienceLevel /= 1000;
		if (experienceLevel > MAX_XP_BONUS) {
			experienceLevel = MAX_XP_BONUS;
		}
		
		// Employees get an experience bonus for their skill
		return skillLevel + experienceLevel;
	}

}
