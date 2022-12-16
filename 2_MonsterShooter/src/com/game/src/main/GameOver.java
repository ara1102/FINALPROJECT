package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class GameOver {
	
	BufferedImage gameOverImg;
	String gameOverPath = "/game over.png" ;
	public Rectangle tryAgainButton = new Rectangle(122,266,257,78);
	public Rectangle menuButton = new Rectangle(159,392,190,87);
	
	public GameOver() {
		BufferedImageLoader loader = new BufferedImageLoader();
		gameOverImg = loader.loadImage(gameOverPath);
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawImage(gameOverImg, 0, 0, null);
//		(g2d).draw(tryAgainButton);
//		(g2d).draw(menuButton);
		//(g2d).draw(quitButton);
		
		//g.drawString("Try Again", tryAgainButton.x+10, tryAgainButton.y+65);
		//g.drawString("Menu", menuButton.x+50, menuButton.y+65);
		//g.drawString("Quit", quitButton.x+50, quitButton.y+65);
		
	}
}

