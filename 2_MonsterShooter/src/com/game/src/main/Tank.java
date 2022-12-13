package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tank implements Entity{
	
	private double x;
	private double y;
	private BufferedImage tankImg;
	private String tankPath = "/tankcrop.png"; 
	
	private double vx = 0;
	private double vy = 0;
	
	//
	public Tank(double x, double y) {
		
		this.x = x;
		this.y = y;
		
		//untuk ngeload gambar dari path
		BufferedImageLoader loader = new BufferedImageLoader();
		tankImg = loader.loadImage(tankPath);
		
	}
	
	public void tick() {
		x+=vx;
		y+=vy;

		// Outer Border
		if(x<=Game.GRASS) {
			x=Game.GRASS;
		}
		
		if(y<=0) {
			y=0;
		}
		
		if(x >= Main.WIDTH - tankImg.getWidth() - Game.GRASS) {
			x = Main.WIDTH - tankImg.getWidth() - Game.GRASS;
		}
		
		if( y >= Main.HEIGHT - tankImg.getHeight()) {
			y = Main.HEIGHT - tankImg.getHeight();
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(tankImg, (int)x, (int)y, null);
	}
	
	public double getX() {
		return x;
	} 
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setvx(double vx) {
		this.vx  = vx;
	}
	
	public void setvy(double vy) {
		this.vy  = vy;
	}
}
