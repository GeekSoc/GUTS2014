package org.geeksoc.guts2014;

import java.util.HashMap;

import org.geeksoc.guts2014.controls.Slider;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Section extends WorkerSpace {

	private Workspace ws;
	public HashMap<JobType, Integer> priority;
	private Slider eslider;

	public Section(Workspace ws) {
		this.ws = ws;
		eslider = new Slider(100,100);
	}

	public void update(GameContainer cont) {
		WorkPacket wp = calculateWorkDone();
		ws.submitWork(wp);
		eslider.update(cont.getInput());
	}

	private WorkPacket calculateWorkDone() {
		WorkPacket sp = new WorkPacket();
		for (Employee e : this.workers) {
			WorkPacket wp = e.work(priority);
			// WorkPacket wp = new WorkPacket();
			sp.combine(wp);
		}
		return sp;
	}

	public void render(Graphics g) {
		eslider.render(g);
	}

}
