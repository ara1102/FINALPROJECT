package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton = new Rectangle(150,150,200,100);
	public Rectangle helpButton = new Rectangle(150,300,200,100);
	public Rectangle quitButton = new Rectangle(150,450,200,100);
	//JButton playButton,helpButton, exitButton;

	public Menu() {
		//playButton = new JButton("PLAY");
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Monster Shooter", 50, 100);
		(g2d).draw(playButton);
		(g2d).draw(helpButton);
		(g2d).draw(quitButton);
		
		g.drawString("Play", playButton.x+50, playButton.y+65);
		g.drawString("Help", helpButton.x+50, helpButton.y+65);
		g.drawString("Quit", quitButton.x+50, quitButton.y+65);
		
		
		
		
	}
}
