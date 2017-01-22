package com.jw.trip.utils;

public class Inventory {
	
	private boolean Sword;
	private boolean Hammer;
	private boolean Lasergun;
	
	public Inventory() {

	}
	
	public boolean hasSword() {
		return Sword;
	}
	public void setSword(boolean sword) {
		Sword = sword;
	}
	public boolean hasHammer() {
		return Hammer;
	}
	public void setHammer(boolean hammer) {
		Hammer = hammer;
	}
	public boolean hasLasergun() {
		return Lasergun;
	}
	public void setLasergun(boolean lasergun) {
		Lasergun = lasergun;
	}

}
