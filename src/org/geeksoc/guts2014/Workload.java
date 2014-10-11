package org.geeksoc.guts2014;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Workload {

	public static final HashMap<JobType, Integer> empty;
    static
    {
        empty = new HashMap<JobType, Integer>();
        empty.put(JobType.Email,0);
        empty.put(JobType.Phone,0);
        empty.put(JobType.SocialMedia,0);
        empty.put(JobType.Text,0);
    }
	
	private JobFactory jf;
	public Queue<Job> emails = new LinkedList<Job>();
	public Queue<Job> phones = new LinkedList<Job>();
	public Queue<Job> texts = new LinkedList<Job>();
	public Queue<Job> socials = new LinkedList<Job>();
	private WorkPacket global = new WorkPacket();
	private int loop;

	public Workload(JobFactory jf) {
		this.jf = jf;
	}

	public void update() {
		while (!jf.getJobQueue().isEmpty()) {
			Job j = jf.getJobQueue().poll();
			switch (j.getJobType()) {
			case Email:
				emails.add(j);
				break;
			case Phone:
				phones.add(j);
				break;
			case Text:
				texts.add(j);
				break;
			case SocialMedia:
				socials.add(j);
				break;
			}
		}
		if (!emails.isEmpty()
				&& emails.peek().workDone(global.getWorkDone(JobType.Email))) {
			emails.poll();
		}
		if (!phones.isEmpty()
				&& phones.peek().workDone(global.getWorkDone(JobType.Phone))) {
			phones.poll();
		}
		if (!texts.isEmpty()
				&& texts.peek().workDone(global.getWorkDone(JobType.Text))) {
			texts.poll();
		}
		if (!socials.isEmpty()
				&& socials.peek().workDone(global.getWorkDone(JobType.SocialMedia))) {
			socials.poll();
		}
		
		if(loop>5){
		if (emails.size()>50){
			Main.rep -= 1;
		}
		if (phones.size()>50){
			Main.rep -= 1;
		}
		if (texts.size()>50){
			Main.rep -= 1;
		}
		if (socials.size()>50){
			Main.rep -= 1;
		}
		
		if (emails.isEmpty()){
			Main.rep += 1;
		}
		if (phones.isEmpty()){
			Main.rep += 1;
		}
		if (texts.isEmpty()){
			Main.rep += 1;
		}
		if (socials.isEmpty()){
			Main.rep += 1;
		}
		
		if (Main.rep<0)Main.rep = 0;
		if (Main.rep>100) Main.rep=100;
		
		}
		//System.out.println(global.getWorkDone().toString());
		global = new WorkPacket();;
		
		loop++;
	}

	public void submit(WorkPacket wp) {
		global.combine(wp);
		// Print number of jobs done in this iteration.
		System.out.println("Global work done this iteration. Phone: "
				+ wp.getWorkDone(JobType.Phone) + ". Text: "
				+ wp.getWorkDone(JobType.Text) + ". Social Media: "
				+ wp.getWorkDone(JobType.SocialMedia) + ". Email: "
				+ wp.getWorkDone(JobType.Email));
		// Print number of jobs in queue.
		System.out.println("Jobs remaining at the end of this iteration. Phone: "
				+ phones.size() + ". Text: " + texts.size() + ". Social Media: "
				+ socials.size() + ". Email: " + emails.size());
	}
}
