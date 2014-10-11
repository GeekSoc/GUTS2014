package org.geeksoc.guts2014;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class RunningState extends BasicGameState {
	
	Workspace ws;

	private int id;
	
	public RunningState(int idee) {
		id=idee;
	}

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		ws = new Workspace();
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		ws.render(container, game, g);
		
	}

	public int getID() {
		return 1;
	}

}
