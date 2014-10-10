package org.geeksoc.guts2014;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Section extends WorkerSpace{
	
	private Workspace ws;
	public HashMap<JobType,Integer> priority;

	public Section(Workspace ws){
		this.ws = ws;
	}
	
	public void update(){
		WorkPacket wp = calculateWorkDone();
		ws.submitWork(wp);
	}

	private WorkPacket calculateWorkDone() {
		WorkPacket sp = new WorkPacket();
		for(Employee e:this.workers){
			//WorkPacket wp = e.work(priority);
			WorkPacket wp = new WorkPacket();
			sp.combine(wp);
		}
		return sp;
	}

	
	

}
