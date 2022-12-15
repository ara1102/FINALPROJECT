package com.game.src.main;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.game.src.main.Game.STATE;

public class MousePanel implements MouseListener {

	//public Rectangle playButton = new Rectangle(150,150,200,100);
	//public Rectangle helpButton = new Rectangle(150,300,200,100);
	//public Rectangle quitButton = new Rectangle(150,450,200,100);
	
	private Menu menu;
	private Difficulty difficulty;
	
	public MousePanel(Menu menu, Difficulty difficulty) {
		this.menu = menu;
		this.difficulty = difficulty;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int px = e.getX();
		int py = e.getY();
		
		if (Game.state == Game.state.MENU) {
			if (px >= menu.playButton.getMinX() && px <= menu.playButton.getMaxX()) {
				if (py >= menu.playButton.getMinY() && py <= menu.playButton.getMaxY()) {
					System.out.println("PLAY BUTTON");
					Game.state = Game.state.DIFF;
				}
			}

			if (px >= menu.helpButton.getMinX() && px <= menu.helpButton.getMaxX()) {
				if (py >= menu.helpButton.getMinY() && py <= menu.helpButton.getMaxY()) {
					System.out.println("HELP BUTTON");
					// Game.state = Game.state.GAME;
				}
			}

			if (px >= menu.quitButton.getMinX() && px <= menu.quitButton.getMaxX()) {
				if (py >= menu.quitButton.getMinY() && py <= menu.quitButton.getMaxY()) {
					System.out.println("QUIT BUTTON");
					// Game.state = Game.state.GAME;
					System.exit(1);
				}
			}
		}else if (Game.state == Game.state.DIFF) {
			if (px >= difficulty.easyButton.getMinX() && px <= difficulty.easyButton.getMaxX()) {
				if (py >= difficulty.easyButton.getMinY() && py <= difficulty.easyButton.getMaxY()) {
					System.out.println("EASY BUTTON");
					Game.state = Game.state.GAME;
					Game.diff = Game.diff.EASY;
				}
			}

			if (px >= difficulty.mediumButton.getMinX() && px <= difficulty.mediumButton.getMaxX()) {
				if (py >= difficulty.mediumButton.getMinY() && py <= difficulty.mediumButton.getMaxY()) {
					System.out.println("MEDIUM BUTTON");
					Game.state = Game.state.GAME;
					Game.diff = Game.diff.MEDIUM;
				}
			}

			if (px >= difficulty.hardButton.getMinX() && px <= difficulty.hardButton.getMaxX()) {
				if (py >= difficulty.hardButton.getMinY() && py <= difficulty.hardButton.getMaxY()) {
					System.out.println("HARD BUTTON");
					Game.state = Game.state.GAME;
					Game.diff = Game.diff.HARD;
				}
			}
		}
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
