package org.geeksoc.guts2014;

import java.util.ArrayList;

public class WorkerSpace {

	ArrayList<Employee> workers;
	ArrayList<Employee> newWorkers;
	ArrayList<Employee> oldWorkers;

	public WorkerSpace() {
		workers = new ArrayList<Employee>();
		newWorkers = new ArrayList<Employee>();
		oldWorkers = new ArrayList<Employee>();
	}

	public void addWorkers(ArrayList<Employee> w) {
		
		newWorkers.addAll(w);
	}

	public void removeWorkers(ArrayList<Employee> w) {
		oldWorkers.addAll(w);
	}

	public void transferWorkers(WorkerSpace ws, ArrayList<Employee> w) {
		ws.addWorkers(w);
		this.removeWorkers(w);
	}

	public int getWorkerCount() {
		return workers.size();
	}
	
public ArrayList<Employee> getWorkers() {
		return workers;
	}

	public void update(){
		workers.removeAll(oldWorkers);
		workers.addAll(newWorkers);
		oldWorkers.clear();
		newWorkers.clear();
	}

}
