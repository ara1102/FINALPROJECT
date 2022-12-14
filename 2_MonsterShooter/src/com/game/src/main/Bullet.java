package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject implements EntityA{
	
	private BufferedImage bulletImg;
	private String bulletPath = "/shotRed.png"; 
	private Controller controller;

	public Bullet(double x, double y, Controller controller) {
		
		super(x+20,y-21);
		this.controller = controller;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		bulletImg = loader.loadImage(bulletPath);
		
	}
	
	public void tick() {
		y -= 10;
		
		if(Physics.Collision(this, controller.getEntitiesB())) {
			System.out.println("collision");
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(bulletImg, (int)x, (int)y, null);
	}
	
	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, bulletImg.getWidth(), bulletImg.getHeight());
	}
}

