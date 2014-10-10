package org.geeksoc.guts2014;

import java.util.ArrayList;

public class WorkerSpace {
	
	ArrayList<Employee> workers;
	
	public WorkerSpace(){
		workers = new ArrayList<Employee>();
	}
	
	public void addWorkers(ArrayList<Employee> w){
		workers.addAll(w);
	}
	
	public void removeWorkers(ArrayList<Employee> w){
		workers.removeAll(w);
	}
	
	public void transferWorkers(WorkerSpace ws, ArrayList<Employee> w){
		ws.addWorkers(w);
		this.removeWorkers(w);
	}

}
