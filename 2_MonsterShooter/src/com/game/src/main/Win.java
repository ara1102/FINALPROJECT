package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Win {
	
	public Rectangle menuButton = new Rectangle(150,200,200,100);
	public Rectangle quitButton = new Rectangle(150,350,200,100);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("YOU WON", 125, 100);
		(g2d).draw(menuButton);
		(g2d).draw(quitButton);
		
		g.drawString("Menu", menuButton.x+35, menuButton.y+65);
		g.drawString("Quit", quitButton.x+50, quitButton.y+65);
	}
		
}
