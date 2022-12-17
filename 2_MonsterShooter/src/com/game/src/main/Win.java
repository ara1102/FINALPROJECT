package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Win {
	
	BufferedImage winImg;
	String winPath = "/win.png" ;
	public Rectangle menuButton = new Rectangle(194,360,125,65);
	//public Rectangle quitButton = new Rectangle(0,0,200,100);
	
	public Win() {
		BufferedImageLoader loader = new BufferedImageLoader();
		winImg = loader.loadImage(winPath);
	}
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		//g.drawString("YOU WON", 125, 100);
		g.drawImage(winImg, 0, 0, null);
		(g2d).draw(menuButton);
		//(g2d).draw(quitButton);
//		
		//g.drawString("Menu", menuButton.x+35, menuButton.y+65);
		//g.drawString("Quit", quitButton.x+50, quitButton.y+65);
	}
		
}