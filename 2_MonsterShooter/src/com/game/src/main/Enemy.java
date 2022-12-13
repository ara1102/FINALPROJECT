package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.tree.FixedHeightLayoutCache;

public class Enemy implements Entity {

	private double x, y;
	private BufferedImage enemyImg;
	private String enemyPath = "/spritesheet.png";
	private int width;
	private int height;
	private Random rand = new Random();
	
	public Enemy(double x, double y) {
		this.x = x;
		this.y = y;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		enemyImg = loader.loadImage(enemyPath, 87 ,253 , 58,64);
		
		width = enemyImg.getWidth();
		height= enemyImg.getHeight();
	}
	
	public void tick() {
		y += 20;
		
		if(y > Main.HEIGHT) {
			y = 0;
			x = rand.nextInt(Main.WIDTH-Game.GRASS-Game.GRASS-64)+Game.GRASS;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(enemyImg, (int)x, (int)y, null);
	}
	
	public double getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

	@Override
	public double getX() {
		return x;
	}
}
