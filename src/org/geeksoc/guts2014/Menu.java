package org.geeksoc.guts2014;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Music;

public class Menu extends BasicGameState {

	private static int buttonWidth = 300;
	private static int buttonHeight = 50;
	private Rectangle startButton;
	private boolean clicked = false;
	private int mouseX = 0;
	private int mouseY = 0;
	private Options options;

	public Menu(Options o) {
		options = o;
	}

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {

		int x1 = (container.getWidth() / 2) - (buttonWidth / 2);
		startButton = new Rectangle(x1, 100, buttonWidth, buttonHeight);
		Music Sound_1 = new Music("res/sound/background.ogg");
		Sound_1.loop(1.0f, 1.0f);

	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

		if (clicked) {

			// if start is clicked change to running state
			if (mouseX < startButton.getMaxX()
					&& mouseX > startButton.getMinX()
					&& mouseY < startButton.getMaxY()
					&& mouseY > startButton.getMinY()) {
				game.enterState(1);
			}
			clicked = false;
		}

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		g.fill(startButton);

	}

	public void mouseClicked(int button, int x, int y, int clickCount) {
		mouseX = x;
		mouseY = y;
		clicked = true;
	}

	public int getID() {
		return 0;
	}

}
