package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Pause {
	
	BufferedImage pauseImg;
	String pausePath = "/pause menu.jpg";
	public Rectangle continueButton = new Rectangle(145,188,211,80);
	public Rectangle menuButton = new Rectangle(175,310,135,80);
	//public Rectangle menuButton = new Rectangle(150,450,200,100);
	
	public Pause() {
		BufferedImageLoader loader = new BufferedImageLoader();
		pauseImg = loader.loadImage(pausePath);
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		//g.drawString("PAUSED", 90, 100);
		g.drawImage(pauseImg, 0, 0, null);
		(g2d).draw(continueButton);
		(g2d).draw(menuButton);
		//(g2d).draw(menuButton);
		
		//g.drawString("Continue", continueButton.x+10, continueButton.y+65);
		//g.drawString("Help", menuButton.x+50, menuButton.y+65);
		//g.drawString("Menu", menuButton.x+50, menuButton.y+65);
		
	}
}
