package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Difficulty {
	
	BufferedImage backImg, selectImg, easyImg, mediumImg, hardImg;
	String selectPath = "/select2.png";
	//String backPath = "/background menu.png";
	String backPath = "/Arena.jpg";
	//String easyPath = "/easy.png";
	String easyPath = "/medium.png";
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
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		//g.drawString("Select Difficulty", 60, 100);
		
		g.drawImage(backImg, 0, 0, null);
		g.drawImage(selectImg, 55, 100, null);
		g.drawImage(easyImg, 220, 180, null);
		g.drawImage(mediumImg, 210, 330, null);
		g.drawImage(hardImg, 220, 480, null);
		
		
		(g2d).draw(easyButton);
		(g2d).draw(mediumButton);
		(g2d).draw(hardButton);
		
		//g.drawString("Easy", easyButton.x+45, easyButton.y+65);
		//g.drawString("Medium", mediumButton.x+5, mediumButton.y+65);
		//g.drawString("Hard", hardButton.x+45, hardButton.y+65);
		
		
	}
		
}