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
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}

	public void setX(double x2) {
		this.x=x2;
	}
}
