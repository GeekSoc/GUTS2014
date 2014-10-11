package org.geeksoc.guts2014;

public class GameTime {

	int hours, minutes, speed;
	private int ms;
	private JobFactory jf;

	public GameTime(JobFactory jf, int h, int m) {
		this.jf = jf;
		hours = h;
		minutes = m;
		speed = 1;
	}

	public void incrementTime(int delta) {
		ms += delta;
		if (ms > 1000) {
			ms = ms - 1000;

			minutes += speed;
			if (minutes > 60) {
				hours += 1;
				minutes = 0;
			}
			if (hours == 24) {
				hours = 0;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (hours < 10) {
			sb.append(0);
		}
		sb.append(hours + ":");
		if (minutes < 10) {
			sb.append(0);
		}
		sb.append(minutes);
		return sb.toString();
	}

	public void setSpeed(int i) {
		speed = i;
		if (speed == 0) {
			jf.stopJobCreation();
		} else {
			if(!JobFactory.isRunning){
			jf.startJobCreation();
			}
			jf.setLambda(i);
		}

	}

	public int getSpeed() {
		return speed;
	}

}
