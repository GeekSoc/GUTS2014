package org.geeksoc.guts2014;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;

/**
 * Employee
 * 
 * @author Chris Bean (lastsplash)
 *
 */
@SuppressWarnings("serial")
public class Employee extends Circle {
	// The total maximum skill an employee should have, as the sum of their four
	// skills.
	private final int workRateDivisor = 2;
	private static int MAX_SKILL = 100;
	// Maximum skill bonus that experience can give
	private static int MAX_XP_BONUS = 10;
	// Maximum number of workers per room
	private static int MAX_NUM_WORKERS = 5;
	// The HashMap for storing employee's skills.
	private HashMap<JobType, Integer> skills;
	// HashMap for storing the total amount of work done by employee on each job,
	// i.e. his experience as a percentage of jobs done. e.g. <JobType.Email,
	// 50000> means the employee has dealt with 500 emails.
	private HashMap<JobType, Integer> experience;
	private boolean moving;
	private WorkerSpace home;
	// Minimum wage
	private float minimumWage = 6;

	/**
	 * Creates a new Employee with a random mix of skills.
	 */
	public Employee(WorkerSpace home) {
		super(-100,-100,10);
		this.home = home;
		/*
		 * Employee skill is set to a random number from 1 to 20
		 */
		skills = new HashMap<JobType, Integer>();
		experience = new HashMap<JobType, Integer>();

		// TODO: test all this.
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (JobType jobType : JobType.values()) {
			skills.put(jobType, rand.nextInt(20)+1);
			experience.put(jobType, 0);
		}
		System.out.println(skills.toString());
	}
	
	public WorkPacket work() {
		HashMap<JobType, Integer> workPriorities = new HashMap<JobType, Integer>();
		
		for (JobType jobType : JobType.values()) {
			workPriorities.put(jobType, 0);
		}
		
		return work(workPriorities);
	}

	/**
	 * 
	 * Work priority passed in range 0 - 100 please
	 * 
	 * @return WorkPacket specifying amount of work done.
	 */
	public WorkPacket work(HashMap<JobType, Integer> workPriorities) {
		HashMap<JobType, Integer> workDone = new HashMap<JobType, Integer>();

		for (Entry<JobType, Integer> entry : workPriorities.entrySet()) {
			JobType jobType = entry.getKey();
			int priority = entry.getValue();

			/*
			 * skill in range 1 - 100, priority in range 0 - 100. Divide by 100 to
			 * keep numbers at the right size.
			 */
			int jobDone = (skills.get(jobType) * priority) / (MAX_SKILL*workRateDivisor);
			workDone.put(jobType, jobDone);
			// Add to experience
			experience.put(jobType, experience.get(jobType) + jobDone);
			
			// Get paid!
			// WHY MUST I DIVIDE BY 4? HAHAHAHA I DON'T KNOW. :@
			Main.cash -= getWage()/4;
		}
		
		for (JobType jobType : JobType.values()) {
			Main.cash += workDone.get(jobType) * Main.rep / 100;
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
	
	/**
	 * Returns that employee's wage in £ / in-game minute.
	 * 
	 * @return wage
	 */
	public float getWage() {
		float wage = 0;
		
		// Hourly wage - an extra £2 per hour for 10 skill
		wage = minimumWage + totalSkill() / 100 * 2;
		// Per in-game minute
		wage /= 60;
		
		return wage;
	}
	
	private int totalSkill() {
		int totalSkill = 0;
		for (int skill : skills.values()) {
			totalSkill += skill;
		}
		return totalSkill;
	}

	public void render(Graphics g) {
		int max = 0;
		JobType best = null;
		JobType next = null;
		for(JobType jt: JobType.values()){
			if(skills.get(jt) >= max){
				best = jt;
				max= skills.get(jt);
			}
		}
		max= 0;
		for(JobType jt: JobType.values()){
			if(!(jt==best)&&skills.get(jt) >= max){
				next = jt;
				max= skills.get(jt);
			}
		}
		
		g.setAntiAlias(true);
		g.setColor(best.color);
		g.fill(this);
		g.setColor(next.color);
		g.setLineWidth(4);
		g.draw(this);
		
	}

	public void move(int i, int j) {
		if(!moving){
		this.setCenterX(i);
		this.setCenterY(j);
		}
	}

	public void update(GameContainer cont) {
		int workercount = 0;
		
		if(cont.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(this.contains(cont.getInput().getAbsoluteMouseX(),cont.getInput().getAbsoluteMouseY())){
				moving = true;
			}
		}
		
		if(moving){
			this.setCenterX(cont.getInput().getAbsoluteMouseX());
			this.setCenterY(cont.getInput().getAbsoluteMouseY());
		}
		
		for (Employee emp:Workspace.instance.employees) {
			if(emp.moving) {
				workercount++;
			}
		}
		
		for (Room s2:Workspace.instance.rooms) {
			for (Employee emp:s2.getWorkers()){
				if(emp.moving) {
					workercount++;
				}
			}
		}
		
		if(moving&&!cont.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			for(Room sec:Workspace.instance.rooms){
				if(sec.rectangle.contains(this.getCenterX(), this.getCenterY()) && sec.getWorkerCount()+workercount <= MAX_NUM_WORKERS){
					ArrayList<Employee> tmp = new ArrayList<Employee>();
					tmp.add(this);
					home.transferWorkers(sec,tmp);
					home = sec;
					moving = false;
					return;
				}
			}
			if(Workspace.instance.bin2.contains(this.getCenterX(), this.getCenterY())){
				ArrayList<Employee> tmp = new ArrayList<Employee>();
				tmp.add(this);
				home.removeWorkers(tmp);
				this.home = null;
				return;
			}
			ArrayList<Employee> tmp = new ArrayList<Employee>();
			tmp.add(this);
			home.transferWorkers(Workspace.instance,tmp);
			home = Workspace.instance;
			moving = false;
			
		}
		
	}

}
