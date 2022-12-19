package com.game.src.opt;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.loader.BufferedImageLoader;

public class Menu {
	
	BufferedImage titleImg,backImg,playImg, helpImg, quitImg;
	String titlePath = "/monster shooter.png";
	String backPath = "/background menu.png";
	String playPath = "/play.png";
	String helpPath = "/help.png";
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

		g.drawImage(backImg,0, 0, null);
		g.drawImage(titleImg, 55, 50, null);
		g.drawImage(playImg, 210, 170, null);
		g.drawImage(helpImg, 210, 320, null);
		g.drawImage(quitImg, 210, 470, null);
		
	}
}
