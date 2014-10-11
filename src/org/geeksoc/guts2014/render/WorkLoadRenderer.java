package org.geeksoc.guts2014.render;

import org.geeksoc.guts2014.Workload;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class WorkLoadRenderer {

	public static void render(Graphics g, Workload w, int x, int y) {
		int e, s, p, t;
		e = w.emails.size();
		s = w.socials.size();
		p = w.phones.size();
		t = w.texts.size();

		g.setColor(Color.blue);
		for (int i = 0; i < e; i++) {
			g.fillOval(x, y - (i * 4), 3, 3);
		}

		g.setColor(Color.green);
		for (int i = 0; i < s; i++) {
			g.fillOval(x + 10, y - (i * 4), 3, 3);
		}

		g.setColor(Color.orange);
		for (int i = 0; i < p; i++) {
			g.fillOval(x + 20, y - (i * 4), 3, 3);
		}

		g.setColor(Color.red);
		for (int i = 0; i < t; i++) {
			g.fillOval(x + 30, y - (i * 4), 3, 3);
		}
	}

}
