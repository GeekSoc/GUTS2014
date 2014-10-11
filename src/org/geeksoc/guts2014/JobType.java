package org.geeksoc.guts2014;

import org.newdawn.slick.Color;

public enum JobType {
	Phone(new Color(0xf4, 0xa4, 0x60)), Email(new Color(0x41, 0x69, 0xe1)), SocialMedia(new Color(0x9a, 0xcd, 0x32)), Text(new Color(0xfa, 0x80, 0x72));
	
	
	public Color color;
	JobType(Color c){
		this.color = c;
	}
}
