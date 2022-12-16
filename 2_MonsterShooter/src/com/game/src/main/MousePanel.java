package com.game.src.main;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.game.src.main.Game.DIFFICULTY;
import com.game.src.main.Game.STATE;

public class MousePanel implements MouseListener {
	
	private Menu menu;
	private Difficulty difficulty;
	private GameOver gameOver;
	private Controller controller;
	private Win win;
	private Pause pause;
	
	public MousePanel(Menu menu, Difficulty difficulty, GameOver gameOver,Win win, Pause pause, Controller controller) {
		this.menu = menu;
		this.difficulty = difficulty;
		this.gameOver = gameOver;
		this.controller = controller;
		this.win = win;
		this.pause = pause;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int px = e.getX();
		int py = e.getY();
		
		if (Game.state == STATE.MENU) {
			if (px >= menu.playButton.getMinX() && px <= menu.playButton.getMaxX()) {
				if (py >= menu.playButton.getMinY() && py <= menu.playButton.getMaxY()) {
					System.out.println("PLAY BUTTON");
					Game.state = STATE.DIFF;
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
		}else if (Game.state == STATE.DIFF) {
			if (px >= difficulty.easyButton.getMinX() && px <= difficulty.easyButton.getMaxX()) {
				if (py >= difficulty.easyButton.getMinY() && py <= difficulty.easyButton.getMaxY()) {
					System.out.println("EASY BUTTON");
					Game.state = STATE.GAME;
					Game.diff = DIFFICULTY.EASY;
					controller.start();
				}
			}

			if (px >= difficulty.mediumButton.getMinX() && px <= difficulty.mediumButton.getMaxX()) {
				if (py >= difficulty.mediumButton.getMinY() && py <= difficulty.mediumButton.getMaxY()) {
					System.out.println("MEDIUM BUTTON");
					Game.state = STATE.GAME;
					Game.diff = DIFFICULTY.MEDIUM;
					controller.start();
				}
			}

			if (px >= difficulty.hardButton.getMinX() && px <= difficulty.hardButton.getMaxX()) {
				if (py >= difficulty.hardButton.getMinY() && py <= difficulty.hardButton.getMaxY()) {
					System.out.println("HARD BUTTON");
					Game.state = STATE.GAME;
					Game.diff = DIFFICULTY.HARD;
					controller.start();
				}
			}
		}else if (Game.state == STATE.GAMEOVER) {
			if (px >= gameOver.tryAgainButton.getMinX() && px <= gameOver.tryAgainButton.getMaxX()) {
				if (py >= gameOver.tryAgainButton.getMinY() && py <= gameOver.tryAgainButton.getMaxY()) {
					System.out.println("TRY AGAIN BUTTON");
					Game.state = STATE.GAME;
					controller.reset();
					controller.start();
				}
			}

			if (px >= gameOver.menuButton.getMinX() && px <= gameOver.menuButton.getMaxX()) {
				if (py >= gameOver.menuButton.getMinY() && py <= gameOver.menuButton.getMaxY()) {
					System.out.println("MENU BUTTON");
					Game.state = STATE.MENU;
					Game.diff = DIFFICULTY.BASE;
					controller.reset();
				}
			}

			if (px >= gameOver.quitButton.getMinX() && px <= gameOver.quitButton.getMaxX()) {
				if (py >= gameOver.quitButton.getMinY() && py <= gameOver.quitButton.getMaxY()) {
					System.out.println("QUIT BUTTON");
					System.exit(1);
				}
			}
		}else if (Game.state == STATE.WIN) {
			if (px >= win.menuButton.getMinX() && px <= win.menuButton.getMaxX()) {
				if (py >= win.menuButton.getMinY() && py <= win.menuButton.getMaxY()) {
					System.out.println("MENU BUTTON");
					Game.state = STATE.MENU;
					Game.diff = DIFFICULTY.BASE;
					controller.reset();
				}
			}

			if (px >= win.quitButton.getMinX() && px <= win.quitButton.getMaxX()) {
				if (py >= win.quitButton.getMinY() && py <= win.quitButton.getMaxY()) {
					System.out.println("QUIT BUTTON");
					System.exit(1);
				}
			}
		}else if (Game.state == STATE.PAUSE) {
			if (px >= pause.continueButton.getMinX() && px <= pause.continueButton.getMaxX()) {
				if (py >= pause.continueButton.getMinY() && py <= pause.continueButton.getMaxY()) {
					System.out.println("CONTINUE BUTTON");
					Game.state = STATE.GAME;
				}
			}

			if (px >= pause.helpButton.getMinX() && px <= pause.helpButton.getMaxX()) {
				if (py >= pause.helpButton.getMinY() && py <= pause.helpButton.getMaxY()) {
					System.out.println("Help BUTTON");
					Game.state = STATE.MENU;
					Game.diff = DIFFICULTY.BASE;
					controller.reset();
				}
			}

			if (px >= pause.menuButton.getMinX() && px <= pause.menuButton.getMaxX()) {
				if (py >= pause.menuButton.getMinY() && py <= pause.menuButton.getMaxY()) {
					System.out.println("QUIT BUTTON");
					Game.state = STATE.MENU;
					Game.diff = DIFFICULTY.BASE;
					controller.reset();
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
