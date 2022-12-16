package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pause {

	public Rectangle continueButton = new Rectangle(125,150,250,100);
	public Rectangle helpButton = new Rectangle(150,300,200,100);
	public Rectangle menuButton = new Rectangle(150,450,200,100);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("PAUSED", 90, 100);
		(g2d).draw(continueButton);
		(g2d).draw(helpButton);
		(g2d).draw(menuButton);
		
		g.drawString("Continue", continueButton.x+10, continueButton.y+65);
		g.drawString("Help", helpButton.x+50, helpButton.y+65);
		g.drawString("Menu", menuButton.x+50, menuButton.y+65);
		
	}
}
