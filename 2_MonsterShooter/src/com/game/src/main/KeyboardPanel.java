package com.game.src.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.src.main.Game.STATE;

public class KeyboardPanel implements KeyListener{

	Tank tank;
	Controller controller;
	Game game;
	boolean fire = false; 
	
	public KeyboardPanel(Tank tank, Controller controller, Game game) {
		this.tank = tank;
		this.controller = controller;
		this.game= game;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (game.state == STATE.GAME) {
			if (key == KeyEvent.VK_RIGHT) {

				tank.setvx(5);

			} else if (key == KeyEvent.VK_LEFT) {

				tank.setvx(-5);

			} else if (key == KeyEvent.VK_UP) {

				tank.setvy(-5);

			} else if (key == KeyEvent.VK_DOWN) {

				tank.setvy(5);

			} else if (key == KeyEvent.VK_SPACE && !fire) {
				fire = true;
				controller.addEntity(new Bullet(tank.getX(), tank.getY(), controller));
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (game.state == STATE.GAME) {
			if (key == KeyEvent.VK_RIGHT) {

				tank.setvx(0);

			} else if (key == KeyEvent.VK_LEFT) {

				tank.setvx(0);

			} else if (key == KeyEvent.VK_UP) {

				tank.setvy(0);

			} else if (key == KeyEvent.VK_DOWN) {

				tank.setvy(0);

			} else if (key == KeyEvent.VK_SPACE) {

				fire = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
