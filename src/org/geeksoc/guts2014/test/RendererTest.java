package org.geeksoc.guts2014.test;

import org.geeksoc.guts2014.Game;
import org.geeksoc.guts2014.Menu;
import org.geeksoc.guts2014.RunningState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class RendererTest {
	
	public static void main(String[] args) throws SlickException{
		AppGameContainer game = new AppGameContainer(new StateBasedGame("geeksoc"){
			@Override
			public void initStatesList(GameContainer container) throws SlickException {
				this.addState(new RunningState(1));
			}
			
		});
		
		game.start();
	}

}
