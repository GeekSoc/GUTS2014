package org.geeksoc.guts2014;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {
	
	private AppGameContainer game;

	public Game(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		Options options = new Options();
		this.addState(new Menu(options));
		this.addState(new RunningState(options));
	}

}
