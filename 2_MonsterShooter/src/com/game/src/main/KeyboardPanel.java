package com.game.src.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardPanel implements KeyListener{

	Tank tank;
	Controller controller;
	boolean fire = false; 
	
	public KeyboardPanel(Tank tank, Controller controller) {
		this.tank = tank;
		this.controller = controller;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			
			tank.setvx(5);
			
		}else if(key == KeyEvent.VK_LEFT) {

			tank.setvx(-5);
			
		}else if(key == KeyEvent.VK_UP) {

			tank.setvy(-5);
			
		}else if(key == KeyEvent.VK_DOWN) {

			tank.setvy(5);
			
		}else if(key == KeyEvent.VK_SPACE && !fire) {
			fire = true;
			controller.addEntity(new Bullet(tank.getX(), tank.getY()));
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {

			tank.setvx(0);
			
		}else if(key == KeyEvent.VK_LEFT) {

			tank.setvx(0);
			
		}else if(key == KeyEvent.VK_UP) {
			
			tank.setvy(0);
			
		}else if(key == KeyEvent.VK_DOWN) {

			tank.setvy(0);
			
		}else if(key == KeyEvent.VK_SPACE) {
			
			fire = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
