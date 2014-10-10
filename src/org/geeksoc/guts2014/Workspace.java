package org.geeksoc.guts2014;

import java.util.ArrayList;

public class Workspace extends WorkerSpace {
	
	Workload wl;
	ArrayList<Section> sections;
	
	public void update(){
		for(Section s : sections){
			s.update();
		}
		
	}

	public void submitWork(WorkPacket wp) {
		//wl.submit(wp)
		
	}

}
