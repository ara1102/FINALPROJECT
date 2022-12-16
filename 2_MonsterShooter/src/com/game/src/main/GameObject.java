package com.game.src.main;

import java.awt.Rectangle;

public class GameObject {

	public double x,y;
	
	public GameObject(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public Rectangle getBounds(int width, int height) {
		return new Rectangle((int)x,(int)y, width,height);
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x=x;
	}
}
