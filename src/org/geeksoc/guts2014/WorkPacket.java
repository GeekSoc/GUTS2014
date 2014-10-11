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


		this.setWorkDone(workDone);
		
	}
	
	public WorkPacket(){
		this(0,0,0,0);
		
	}
	
	public WorkPacket(int e, int p, int t, int s){
		this(new HashMap<JobType, Integer>(){/**
			 * 
			 */
			private static final long serialVersionUID = 6137594892801277374L;

		{
			put(JobType.Email,0);
		  put(JobType.Phone,0);
		  put(JobType.SocialMedia,0);
		  put(JobType.Text,0);};});
		 
	}

	public void combine(WorkPacket wp) {
		for (Entry<JobType, Integer> entry : getWorkDone().entrySet()) {
			JobType jobType = entry.getKey();
			
			getWorkDone().put(jobType, getWorkDone().get(jobType) + wp.getWorkDone(jobType));
		}
	}
	
	public int size() {
		return getWorkDone().size();
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

	public HashMap<JobType, Integer> getWorkDone() {
		return workDone;
	}

	public void setWorkDone(HashMap<JobType, Integer> workDone) {
		this.workDone = workDone;
	}
	

}
