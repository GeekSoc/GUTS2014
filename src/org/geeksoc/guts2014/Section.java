package org.geeksoc.guts2014;

import java.util.ArrayList;
import java.util.HashMap;

import org.geeksoc.guts2014.controls.Slider;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.RoundedRectangle;

public class Section extends WorkerSpace {

	private Workspace ws;
	public HashMap<JobType, Integer> priority = new HashMap<JobType, Integer>();
	private Slider eslider, sslider, pslider, tslider;
	public RoundedRectangle rectangle;
	// To count up in milliseconds
	private int deltaCounter;

	public Section(Workspace ws) {
		this.ws = ws;
		eslider = new Slider();
		sslider = new Slider();
		pslider = new Slider();
		tslider = new Slider();
	}

	public void update(GameContainer cont,int delta) {
		for(Employee e: this.workers){
			e.update(cont);
		}

		updatePriorities();

		deltaCounter += delta;
		
		int speed = ws.instance.gt.getSpeed();
		if (speed == 0) {
			speed = 1;
		}
		
		if (deltaCounter >= 1000/speed) {
			
			if (JobFactory.isRunning) {
				WorkPacket wp = calculateWorkDone();
				ws.submitWork(wp);
			}
			deltaCounter = 0;
		}

		eslider.update(cont.getInput());
		sslider.update(cont.getInput());
		pslider.update(cont.getInput());
		tslider.update(cont.getInput());
		this.update();
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
		return sp;
	}

	public void render(Graphics g, int x, int y) {

		g.setColor(new Color(0x41, 0x69, 0xe1));
		eslider.render(g, x + 10, y + 10);
		g.setColor(new Color(0x9a, 0xcd, 0x32));
		sslider.render(g, x + 10, y + 25);
		g.setColor(new Color(0xf4, 0xa4, 0x60));
		pslider.render(g, x + 10, y + 40);
		g.setColor(new Color(0xfa, 0x80, 0x72));
		tslider.render(g, x + 10, y + 55);

	}

}
