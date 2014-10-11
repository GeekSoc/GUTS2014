package org.geeksoc.guts2014;

import org.newdawn.slick.Color;

public enum JobType {
	Phone(Color.orange), Email(Color.blue), SocialMedia(Color.green), Text(Color.red);
	
	
	public Color color;
	JobType(Color c){
		this.color = c;
	}
}
