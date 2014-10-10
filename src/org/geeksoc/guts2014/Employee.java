package org.geeksoc.guts2014;

import java.util.HashMap;

/**
 * 
 * 
 * @author Chris Bean (lastsplash)
 *
 */
public class Employee {
	/* 
	 * An employee's skill at a given job is expressed as
	 * a percentage, i.e. an int in the range 0 - 100. His
	 * skill level is stored as a HashMap<String, Integer>
	 * with the following keys:
	 * 
	 * 	- phoneCallSkill
	 * 	- textChatSkill
	 * 	- socialMediaSkill
	 * 	- emailSkill
	 */
	private HashMap<String, Integer> skills;
	
	/**
	 * Create a new Employee with a low skill level.
	 */
	public Employee() {
		/*
		 * Employee skill is set to 0 by default.
		 * 
		 * TODO: Make skills initially a random mixture of skills.
		 */
		skills = new HashMap<String, Integer>();
		
		skills.put("phoneCallSkill", 		0);
		skills.put("phoneCallSkill", 		0);
		skills.put("textChatSkill", 		0);
		skills.put("socialMediaSkill", 	0);
	}
	
	/**
	 * 
	 * 
	 * @param skills
	 */
	private Employee(HashMap<String, Integer> skills) {
		// Initialise the employee's skill level.
		this.phoneCallSkill		= skills.get("phoneCallSkill");
		this.textChatSkill		= skills.get("textChatSkill");
		this.socialMediaSkill	= skills.get("socialMediaSkill");
		this.emailSkill				= skills.get("emailSkill");
		
		
	}
	
	/**
	 * This method takes the input 
	 * 
	 * @param skills
	 * @return
	 */
	private HashMap<String, Integer> validateSkillHashMap(HashMap<String, Integer> skills) {
		return skills;	
	}

}
