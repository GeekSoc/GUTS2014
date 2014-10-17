package org.geeksoc.guts2014;

public final class GameTime {

	private static int hours = 0, minutes = 0, speed = 0, ms = 0;

	private GameTime() {
	}

	public static void setTime(int h, int m) {
		hours = h;
		minutes = m;
	}

	public static void incrementTime(int delta) {
		ms += delta;
		if (ms > 1000) {
			ms = ms - 1000;
			minutes += speed;
			if (minutes > 59) {
				hours += 1;
				minutes = 0;
			}
			if (hours == 24) {
				hours = 0;
			}
		}
	}

	public static String toStringHack() {
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

	public static void setSpeed(int s) {
		speed = s;
		
	}

	public static int getSpeed() {
		return speed;
	}
	
	public static boolean isPaused() {
		return speed == 0;
	}

}
