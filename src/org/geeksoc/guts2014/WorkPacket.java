package org.geeksoc.guts2014;

import java.util.HashMap;
import java.util.Map.Entry;

public class WorkPacket {
	/*
	 * Work done is expressed as a percentage of one job. e.g. <JobType.Phone,
	 * 250> means that two and half phone calls have been dealt with.
	 * <JobType.Email, 75> means 75% of an email has been written.
	 */
	private HashMap<JobType, Integer> workDone;
	
	private static final HashMap<JobType, Integer> empty;
    static
    {
        empty = new HashMap<JobType, Integer>();
        empty.put(JobType.Email,0);
        empty.put(JobType.Phone,0);
        empty.put(JobType.SocialMedia,0);
        empty.put(JobType.Text,0);
    }

	/**
	 * Creates a new WorkPacket, initialised with the amount of work done on each
	 * job. If a JobType is missed out of the workDone HashMap then the value for
	 * that JobType is initialised to 0.
	 * 
	 * @param workDone
	 */
	public WorkPacket(HashMap<JobType, Integer> workDone) {
		/*
		 * If there are as many key-value pairs in the HashMap as there are values
		 * for JobType, then the HashMap includes the work done for all jobs, so we
		 * can assign it to this instance's workDone field.
		 * 
		 * Or else we "fix" it by setting to 0 the work done for all JobTypes not
		 * mentioned in the HashMap.
		 */
		if (!(workDone.size() == JobType.values().length)) {
			// Tell the user why some workDone has inexplicably been set to 0.
			System.err
					.println("An invalid HashMap has been passed to the constructor of WorkPacket.");
			for (JobType jobType : JobType.values()) {
				if (workDone.get(jobType) == null) {
					workDone.put(jobType, 0);
					System.err.println("Work done on " + jobType.name()
							+ " is missing from HashMap and has therefore been set to 0.");
				}
			}
		}

		this.workDone = workDone; //bad form chris you numpty
	}
	
	public WorkPacket(){
		this(empty);
	}
	
	public WorkPacket(int e, int p, int t, int s){
		this(empty);
		  workDone.put(JobType.Email,e);
		  workDone.put(JobType.Phone,p);
		  workDone.put(JobType.SocialMedia,s);
		  workDone.put(JobType.Text,t);
	}

	public void combine(WorkPacket wp) {
		for (Entry<JobType, Integer> entry : workDone.entrySet()) {
			JobType jobType = entry.getKey();
			
			workDone.put(jobType, workDone.get(jobType) + wp.getWorkDone(jobType));
		}
	}
	
	public int size() {
		return workDone.size();
	}

	/**
	 * Returns the work done on a job by an employee. The value returned is
	 * expressed as a percentage of one job. For example,
	 * 
	 * @param jobType
	 * @return workDone
	 */
	public int getWorkDone(JobType jobType) {
		return workDone.get(jobType);
	}

}
