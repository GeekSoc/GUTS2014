package org.geeksoc.guts2014;

import java.util.ArrayList;

import org.geeksoc.guts2014.controls.GMouseListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class RunningState extends BasicGameState {

	public static RunningState instance;
	private Workspace w;
	private ArrayList<GMouseListener> mouseListeners;

	public RunningState() {
		instance = this;
		mouseListeners = new ArrayList<GMouseListener>();

		w = new Workspace();
	}

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {

	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		w.update(delta);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		w.render(container, game, g);

	}

	public int getID() {
		return id;
	}

	public void registerMouseListener(GMouseListener g) {
		mouseListeners.add(g);
	}

	public void mouseClicked(int button, int x, int y, int clickCount) {
		for (GMouseListener g : mouseListeners) {
			g.onClick(x, y);

		}
	}

}
