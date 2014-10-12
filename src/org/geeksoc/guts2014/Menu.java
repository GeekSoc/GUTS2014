package org.geeksoc.guts2014;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
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
	
	private GameContainer c;
	
	private static int buttonWidth = 300;
	private static int buttonHeight = 50;
	private RoundedRectangle startButton;
	private RoundedRectangle musicButton;
	private RoundedRectangle FSButton;
	private RoundedRectangle rButton;
	private Color buttonColor;
	private Color textColor;
	private boolean clicked = false;
	private int mouseX = 0;
	private int mouseY = 0;
	// These aren't being used.
	//private Options options;
	//private Animation phone;
	private Music Sound_1;
	private Image mpic;
	
	public Menu(/*Options o*/) {
		//options = o;
	}

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		try {
			Main.loadResources();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			c=container;
			reiniti(c);
		}
	
	private void reiniti(GameContainer container) throws SlickException {
		int x1 = (container.getWidth() / 4) - (buttonWidth / 2);
		
		startButton = new RoundedRectangle(x1, 100, buttonWidth, buttonHeight, 20);
		musicButton = new RoundedRectangle(x1, 200, buttonWidth, buttonHeight, 20);
		rButton = new RoundedRectangle(x1,300,buttonWidth,buttonHeight, 20);
		FSButton = new RoundedRectangle(x1, 400, buttonWidth, buttonHeight, 20);
		Sound_1= new Music("res/sound/background.ogg");
		Sound_1.loop(1.0f, 1.0f);
		buttonColor = new Color(240, 240, 240);
		textColor = new Color( 0, 120, 173);
		
		mpic = new Image("res/img/menu_pic.png");
		
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
			else if (mouseX < musicButton.getMaxX()
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
			else if(mouseX < rButton.getMaxX()
					&& mouseX > rButton.getMinX()
					&& mouseY < rButton.getMaxY()
					&& mouseY > rButton.getMinY()) {
				toggleResolution();
			}
			else if (mouseX < FSButton.getMaxX()
					&& mouseX > FSButton.getMinX()
					&& mouseY < FSButton.getMaxY()
					&& mouseY > FSButton.getMinY()) {
				container.setFullscreen(!container.isFullscreen());
				
			}
			clicked = false;
		}
		if(container.getInput().isKeyPressed(Keyboard.KEY_ESCAPE)){
			container.setFullscreen(false);
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
		
		g.setColor(new Color(255, 255, 255));
		Rectangle r = new Rectangle(0, 0, container.getWidth(),
				container.getHeight());
		g.fill(r);
		
		g.setAntiAlias(true);
		
		g.scale(1, 1);
		g.setFont(Main.font);
		g.setColor(buttonColor);
		g.fill(startButton);
		g.fill(musicButton);
		g.fill(rButton);
		g.fill(FSButton);
		
		g.setColor(textColor);
		Canvas c = new Canvas();
		FontMetrics metrics = c.getFontMetrics(Main.fontBase);
		g.drawString("Start", startButton.getCenterX()
				-metrics.stringWidth("Start")/2, startButton.getCenterY()-5);
		g.drawString("Toggle Music", musicButton.getCenterX()
				-metrics.stringWidth("Toogle Music")/2, musicButton.getCenterY()-5);
		g.drawString("Adapt resolution", rButton.getCenterX()
				-metrics.stringWidth("Addapt resolution")/2, rButton.getCenterY()-5);
		g.drawString("Full Screen", FSButton.getCenterX()
				-metrics.stringWidth("Full Screen")/2, FSButton.getCenterY()-5);
		
		mpic.draw(container.getWidth()/2 , container.getHeight()/4, container.getHeight()/2, container.getHeight()/2 );
			
	}
	
	public void toggleResolution() throws SlickException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		Main.game.setDisplayMode(width, height, false);
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
