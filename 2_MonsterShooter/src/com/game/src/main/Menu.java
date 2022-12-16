package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Menu {
	
	BufferedImage titleImg,backImg,playImg, helpImg, quitImg;
	String titlePath = "/monster shooter.png";
	String backPath = "/background menu.png";
	String playPath = "/play.png";
	String helpPath = "/help (1).png";
	String quitPath = "/quit.png";
	public Rectangle playButton = new Rectangle(190,160,130,70);
	public Rectangle helpButton = new Rectangle(190,310,130,70);
	public Rectangle quitButton = new Rectangle(190,465,130,70);

	public Menu() {
		BufferedImageLoader loader = new BufferedImageLoader();
		titleImg = loader.loadImage(titlePath);
		backImg = loader.loadImage(backPath);
		playImg = loader.loadImage(playPath);
		helpImg = loader.loadImage(helpPath);
		quitImg = loader.loadImage(quitPath);
	}

	
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("InaiMathi", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		//g.drawString("Monster Shooter", 50, 100);
		g.drawImage(backImg,0, 0, null);
		g.drawImage(titleImg, 55, 50, null);
		g.drawImage(playImg, 210, 170, null);
		g.drawImage(helpImg, 210, 320, null);
		g.drawImage(quitImg, 210, 470, null);
//		(g2d).draw(playButton);
//		(g2d).draw(helpButton);
//		(g2d).draw(quitButton);
//		
		//g.drawString("Play", playButton.x+50, playButton.y+65);
		//g.drawString("Help", helpButton.x+50, helpButton.y+65);
		//g.drawString("Quit", quitButton.x+50, quitButton.y+65);
		
		
		
		
	}
}
