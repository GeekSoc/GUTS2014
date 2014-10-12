package org.geeksoc.guts2014;

import java.util.ArrayList;

public class WorkerSpace {

	ArrayList<Employee> employees;
	ArrayList<Employee> newWorkers;
	ArrayList<Employee> oldWorkers;

	public WorkerSpace() {
		employees = new ArrayList<Employee>();
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
		return employees.size();
	}
	
	public float getTotalWages() {
		float t = 0;
		for(Employee emp: employees) {
			t+=emp.getWage();
		}
		return t;
	}

	public ArrayList<Employee> getWorkers() {
		return employees;
	}

	public void update() {
		employees.removeAll(oldWorkers);
		employees.addAll(newWorkers);
		oldWorkers.clear();
		newWorkers.clear();
	}

}
