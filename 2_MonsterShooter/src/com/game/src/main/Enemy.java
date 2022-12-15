package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.tree.FixedHeightLayoutCache;

public class Enemy extends GameObject implements EntityB {

	private BufferedImage enemyImg;
	private String enemyPath = "/spritesheet.png";
	private Random rand = new Random();
	private Controller controller;
	
	public Enemy(double x, double y, Controller controller) {
		super(x, y);
		this.controller=controller;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		if(Game.diff == Game.diff.EASY) {
			enemyImg = loader.loadImage(enemyPath, 87 ,253 , 58,64);
		}else if(Game.diff == Game.diff.MEDIUM) {
			enemyImg = loader.loadImage(enemyPath, 255 ,170 , 58,64);
		}else if(Game.diff == Game.diff.HARD) {
			enemyImg = loader.loadImage(enemyPath, 507 ,170 , 58,64);
		}
	}
	
	public void tick() {
		y += 1;
		
		if(y > Main.HEIGHT) {
			y = 0;
			x = rand.nextInt(Main.WIDTH-Game.GRASS-Game.GRASS-64)+Game.GRASS;
		}
		
		for(int i=0; i< controller.getEntitiesASize(); i++){
			EntityA tempEntityA = controller.getEntitiesA().get(i);
			
			if(Physics.Collision(this, tempEntityA)) {
				controller.removeEntity(tempEntityA);
				controller.removeEntity(this);
			}
		}

	}
	
	public void render(Graphics g) {
		g.drawImage(enemyImg, (int)x, (int)y, null);
	}
	
	public double getY() {
		return y;
	}

	@Override
	public double getX() {
		return x;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, enemyImg.getWidth(),enemyImg.getHeight());
	}

}
