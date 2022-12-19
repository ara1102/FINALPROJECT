package com.game.src.opt;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.loader.BufferedImageLoader;

public class Difficulty {
	
	BufferedImage backImg, selectImg, easyImg, mediumImg, hardImg;
	String selectPath = "/select2.png";
	String backPath = "/background menu.png";
	String easyPath = "/easy.png";
	String mediumPath = "/medium.png";
	String hardPath = "/hard.png";
	
	public Rectangle easyButton = new Rectangle(210,170,80,60);
	public Rectangle mediumButton = new Rectangle(200,320,110,60);
	public Rectangle hardButton = new Rectangle(210,470,80,65);
	
	public Difficulty() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		backImg = loader.loadImage(backPath);
		selectImg = loader.loadImage(selectPath);
		easyImg = loader.loadImage(easyPath);
		mediumImg = loader.loadImage(mediumPath);
		hardImg = loader.loadImage(hardPath);
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(backImg, 0, 0, null);
		g.drawImage(selectImg, 55, 100, null);
		g.drawImage(easyImg, 220, 180, null);
		g.drawImage(mediumImg, 210, 330, null);
		g.drawImage(hardImg, 220, 480, null);
	
	}
		
}