package org.geeksoc.guts2014;

import java.util.HashMap;

public class WorkPacket {
	/*
	 * Work done is expressed as a percentage of one job. e.g. <JobType.Phone,
	 * 250> means that two and half phone calls have been dealt with.
	 * <JobType.Email, 75> means 75% of an email has been written.
	 */
	private HashMap<JobType, Integer> workDone;

	/**
	 * Creates a new WorkPacket, initialised with the amount of work done on each
	 * job.
	 * 
	 * @param phoneWorkDone
	 * @param textWorkDone
	 * @param socialMediaWorkDone
	 * @param emailWorkDone
	 */
	public WorkPacket(int phoneWorkDone, int textWorkDone,
			int socialMediaWorkDone, int emailWorkDone) {

		workDone.put(JobType.Phone, phoneWorkDone);
		workDone.put(JobType.Text, textWorkDone);
		workDone.put(JobType.SocialMedia, socialMediaWorkDone);
		workDone.put(JobType.Email, emailWorkDone);
	}

	public WorkPacket() {
		this(0,0,0,0);
	}

	public void combine(WorkPacket wp) {
		// TODO Auto-generated method stub

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
