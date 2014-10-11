package org.geeksoc.guts2014.controls;

import org.geeksoc.guts2014.GameTime;
import org.geeksoc.guts2014.RunningState;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

public class TimeControls implements GMouseListener {

	Rectangle pause1;
	Rectangle pause2;
	Polygon play;
	Polygon fast;
	Polygon faster;

	public TimeControls() {
		RunningState.instance.registerMouseListener(this);
	}

	public void setcoords(int x, int y) {
		pause1 = new Rectangle(x, y + 5, 5, 20);
		pause2 = new Rectangle(x + 10, y + 5, 5, 20);
		play = new Polygon();
		play.addPoint(x + 20, y + 5);
		play.addPoint(x + 20, y + 25);
		play.addPoint(x + 35, y + 15);

		fast = new Polygon();
		fast.addPoint(x + 40, y + 5);
		fast.addPoint(x + 45, y + 10);
		fast.addPoint(x + 45, y + 5);
		fast.addPoint(x + 55, y + 15);
		fast.addPoint(x + 45, y + 25);
		fast.addPoint(x + 45, y + 20);
		fast.addPoint(x + 40, y + 25);

		faster = new Polygon();
		faster.addPoint(x + 60, y + 5);
		faster.addPoint(x + 65, y + 10);
		faster.addPoint(x + 65, y + 5);
		faster.addPoint(x + 70, y + 10);
		faster.addPoint(x + 70, y + 5);
		faster.addPoint(x + 80, y + 15);
		faster.addPoint(x + 70, y + 25);
		faster.addPoint(x + 70, y + 20);
		faster.addPoint(x + 65, y + 25);
		faster.addPoint(x + 65, y + 20);
		faster.addPoint(x + 60, y + 25);
	}

	public void render(Graphics g, GameContainer container) {
		g.setColor(Color.black);
		if (GameTime.getSpeed() == 0)
			g.setColor(new Color(230, 230, 230));
		g.fill(pause1);
		g.fill(pause2);
		g.setColor(Color.black);
		if (GameTime.getSpeed() == 1)
			g.setColor(new Color(230, 230, 230));

		g.fill(play);
		g.setColor(Color.black);
		if (GameTime.getSpeed() == 2)
			g.setColor(new Color(230, 230, 230));

		g.fill(fast);
		g.setColor(Color.black);
		if (GameTime.getSpeed() == 5)
			g.setColor(new Color(230, 230, 230));

		g.fill(faster);
		g.setColor(Color.black);
	}

	@Override
	public void onClick(int x, int y) {
		System.out.println("Derp");
		if (pause1.contains(x, y) || pause2.contains(x, y)) {
			GameTime.setSpeed(0);
			System.out.println("Derp");
		} else if (play.contains(x, y)) {
			GameTime.setSpeed(1);

		} else if (fast.contains(x, y)) {
			GameTime.setSpeed(2);
		} else if (faster.contains(x, y)) {
			GameTime.setSpeed(5);
		}

	}

}
