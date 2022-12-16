package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameOver {
	
	public Rectangle tryAgainButton = new Rectangle(125,150,250,100);
	public Rectangle menuButton = new Rectangle(150,300,200,100);
	public Rectangle quitButton = new Rectangle(150,450,200,100);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("GAME OVER", 90, 100);
		(g2d).draw(tryAgainButton);
		(g2d).draw(menuButton);
		(g2d).draw(quitButton);
		
		g.drawString("Try Again", tryAgainButton.x+10, tryAgainButton.y+65);
		g.drawString("Menu", menuButton.x+50, menuButton.y+65);
		g.drawString("Quit", quitButton.x+50, quitButton.y+65);
		
	}
}


