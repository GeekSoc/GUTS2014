package org.geeksoc.guts2014;

import java.util.LinkedList;
import java.util.Queue;

public class Workload {
	
	private JobFactory jf;
	public Queue<Job> emails = new LinkedList<Job>();
	public Queue<Job> phones = new LinkedList<Job>();
	public Queue<Job> texts = new LinkedList<Job>();
	public Queue<Job> socials = new LinkedList<Job>();

	public Workload(JobFactory jf){
		this.jf = jf;
	}
	
	public void update(){
		while(!jf.getJobQueue().isEmpty()){
			Job j= jf.getJobQueue().poll();
			switch(j.getJobType()){
			case Email: emails.add(j);break;
			case Phone: phones.add(j);break;
			case Text: texts.add(j);break;
			case SocialMedia: socials.add(j);break;
			}
		}
	}

}
