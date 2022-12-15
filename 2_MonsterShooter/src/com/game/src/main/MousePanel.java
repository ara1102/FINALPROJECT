package com.game.src.main;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePanel implements MouseListener {
	
	private Menu menu;
	private Difficulty difficulty;
	private Controller controller;
	
	public MousePanel(Menu menu, Difficulty difficulty, Controller controller) {
		this.menu = menu;
		this.difficulty = difficulty;
		this.controller = controller;
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
					controller.start();
				}
			}

			if (px >= difficulty.mediumButton.getMinX() && px <= difficulty.mediumButton.getMaxX()) {
				if (py >= difficulty.mediumButton.getMinY() && py <= difficulty.mediumButton.getMaxY()) {
					System.out.println("MEDIUM BUTTON");
					Game.state = Game.state.GAME;
					Game.diff = Game.diff.MEDIUM;
					controller.start();
				}
			}

			if (px >= difficulty.hardButton.getMinX() && px <= difficulty.hardButton.getMaxX()) {
				if (py >= difficulty.hardButton.getMinY() && py <= difficulty.hardButton.getMaxY()) {
					System.out.println("HARD BUTTON");
					Game.state = Game.state.GAME;
					Game.diff = Game.diff.HARD;
					controller.start();
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
