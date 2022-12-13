package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet implements Entity{
	
	private double x;
	private double y;
	private BufferedImage bulletImg;
	private String bulletPath = "/shotRed.png"; 

	public Bullet(double x, double y) {
		
		this.x = x+20;
		this.y = y-21;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		bulletImg = loader.loadImage(bulletPath);
		
	}
	
	public void tick() {
		y -= 10;
	}
	
	public void render(Graphics g) {
		g.drawImage(bulletImg, (int)x, (int)y, null);
	}
	
	public double getY() {
		return y;
	}

	@Override
	public double getX() {
		return x;
	}
}

