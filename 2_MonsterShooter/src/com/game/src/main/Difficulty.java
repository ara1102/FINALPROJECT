package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Difficulty {

	public Rectangle easyButton = new Rectangle(150,150,200,100);
	public Rectangle mediumButton = new Rectangle(150,300,200,100);
	public Rectangle hardButton = new Rectangle(150,450,200,100);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Select Difficulty", 60, 100);
		(g2d).draw(easyButton);
		(g2d).draw(mediumButton);
		(g2d).draw(hardButton);
		
		g.drawString("Easy", easyButton.x+45, easyButton.y+65);
		g.drawString("Medium", mediumButton.x+5, mediumButton.y+65);
		g.drawString("Hard", hardButton.x+45, hardButton.y+65);
		
		
		
		
	}
}
