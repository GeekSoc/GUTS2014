package org.geeksoc.guts2014;

import java.util.HashMap;

import org.geeksoc.guts2014.controls.Slider;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Section extends WorkerSpace {

	private Workspace ws;
	public HashMap<JobType, Integer> priority = new HashMap<JobType, Integer>();
	private Slider eslider, sslider, pslider, tslider;

	public Section(Workspace ws) {
		this.ws = ws;
		eslider = new Slider();
		sslider = new Slider();
		pslider = new Slider();
		tslider = new Slider();
	}

	public void update(GameContainer cont) {
		updatePriorities();
		WorkPacket wp = calculateWorkDone();
		ws.submitWork(wp);
		eslider.update(cont.getInput());
		sslider.update(cont.getInput());
		pslider.update(cont.getInput());
		tslider.update(cont.getInput());
	}

	private void updatePriorities() {

		if (eslider.getValue() + pslider.getValue() + sslider.getValue()
				+ tslider.getValue() > 100) {
			eslider.setValue(eslider.getValue() - 1);
			pslider.setValue(pslider.getValue() - 1);
			sslider.setValue(sslider.getValue() - 1);
			tslider.setValue(tslider.getValue() - 1);
		}

		priority.put(JobType.Email, eslider.getValue());
		priority.put(JobType.SocialMedia, sslider.getValue());
		priority.put(JobType.Phone, pslider.getValue());
		priority.put(JobType.Text, tslider.getValue());
	}

	private WorkPacket calculateWorkDone() {
		WorkPacket sp = new WorkPacket();
		for (Employee e : this.workers) {
			WorkPacket wp = e.work(priority);
			// WorkPacket wp = new WorkPacket();
			sp.combine(wp);
		}
		System.out.print("Work done. Phone: " + sp.getWorkDone(JobType.Phone)
				+ ". Text: " + sp.getWorkDone(JobType.Text) + ". Social Media: "
				+ sp.getWorkDone(JobType.SocialMedia) + ". Email: "
				+ sp.getWorkDone(JobType.Email));
		;
		return sp;
	}

	public void render(Graphics g, int x, int y) {
		eslider.render(g, x + 10, y + 10);
		sslider.render(g, x + 10, y + 20);
		pslider.render(g, x + 10, y + 30);
		tslider.render(g, x + 10, y + 40);
	}

}
