package org.geeksoc.guts2014;
//this class is accessible from all states
public class Options {
	private boolean music = true;
	
	public void setMusic(boolean sound) {
		music = sound;
	}
	
	public boolean isMusicOn() {
		return music;
	}
}
