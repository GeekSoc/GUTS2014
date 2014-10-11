package org.geeksoc.guts2014;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Music;

public class Menu extends BasicGameState {

	private static int buttonWidth = 300;
	private static int buttonHeight = 50;
	private RoundedRectangle startButton;
	private RoundedRectangle musicButton;
	private RoundedRectangle FSButton;
	private Color buttonColor;
	private Color textColor;
	private boolean clicked = false;
	private int mouseX = 0;
	private int mouseY = 0;
	private Options options;
	private Animation phone;
	private Music Sound_1;

	public Menu(Options o) {
		options = o;
	}

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {

		int x1 = (container.getWidth() / 2) - (buttonWidth / 2);
		startButton = new RoundedRectangle(x1, 100, buttonWidth, buttonHeight, 20);
		musicButton = new RoundedRectangle(x1, 200, buttonWidth, buttonHeight, 20);
		FSButton = new RoundedRectangle(x1, 300, buttonWidth, buttonHeight, 20);
		Sound_1= new Music("res/sound/background.ogg");
		Sound_1.loop(1.0f, 1.0f);
		buttonColor = new Color(150, 134, 192);
		textColor = new Color(102, 84, 149);
		//Fuck off wit hte annoying music for now :(
		//Image phone1 = new Image("res/img/phone.gif");
		//Image phone2 = new Image("res/img/phone2.gif");
		//Image phone3 = new Image("res/img/phone3.gif");
		//Image[] phones = new Image[]{phone1,phone2,phone3};
		//phone = new Animation(phones,1);
		
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
			if (mouseX < musicButton.getMaxX()
					&& mouseX > musicButton.getMinX()
					&& mouseY < musicButton.getMaxY()
					&& mouseY > musicButton.getMinY()) {
				if (Sound_1.playing()) {
					Sound_1.stop();
				}
				else {
					Sound_1.loop();
				}
				
			}
			if (mouseX < FSButton.getMaxX()
					&& mouseX > FSButton.getMinX()
					&& mouseY < FSButton.getMaxY()
					&& mouseY > FSButton.getMinY()) {
				container.setFullscreen(true);
				
			}
			clicked = false;
		}

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		/*g.drawAnimation(phone, 10, 10);
		for(int x = 0; x<20; x++){
			for(int y = 0; y<15; y++){
				g.drawAnimation(phone, (x*60)+10, (y*40)+10);
			}
		}*/
		
		g.setColor(new Color(255, 239, 168));
		Rectangle r = new Rectangle(0, 0, container.getWidth(),
				container.getHeight());
		g.fill(r);
		
		g.setAntiAlias(true);
		
		g.scale(1, 1);
		g.setColor(buttonColor);
		g.fill(startButton);
		g.setColor(textColor);
		g.drawString("Start", startButton.getCenterX()-20, startButton.getCenterY()-5);
		
		g.setColor(buttonColor);
		g.fill(musicButton);
		g.setColor(textColor);
		g.drawString("Toggle Music", musicButton.getCenterX()-50, musicButton.getCenterY()-5);
		
		g.setColor(buttonColor);
		g.fill(FSButton);
		g.setColor(textColor);
		g.drawString("Full Screen", FSButton.getCenterX()-50, FSButton.getCenterY()-5);
		
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
