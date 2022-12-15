package com.game.src.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	private boolean running = false;
	private Thread thread;
	
	private Tank tank;
	private Controller controller;
	private Menu menu;
	private Difficulty difficulty;
	
	//Grass right-left area size : 70px each 
	public static final int GRASS = 70;
	private BufferedImage backImg = null;
	private String backPath = "/Arena.jpg";
	
	public static enum STATE{
		MENU,
		GAME,
		DIFF
	};
	
	public static enum DIFFICULTY{
		BASE,
		EASY,
		MEDIUM,
		HARD
	};
	
	public static STATE state = STATE.MENU;
	public static DIFFICULTY diff = DIFFICULTY.BASE;
	
	public void init() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		backImg = loader.loadImage(backPath);
		
		controller = new Controller();
		tank = new Tank(218, 300,controller);
		menu = new Menu();
		difficulty = new Difficulty();
		
		requestFocus();
		addKeyListener(new KeyboardPanel(tank,controller,this));
		addMouseListener(new MousePanel(menu,difficulty));
		
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		if(!running) {
			return;
		}
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
		
	}
	
	@Override
	public void run() {
		
		init();
		
		// FPS
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis()-timer > 1000) {
				timer+=1000;
				System.out.println(updates + " Ticks, Fps "+frames );
				updates = 0;
				frames = 0;
			}
		}
		
		stop();
	}
	
	private void tick() {
		
		if(state == STATE.GAME && diff != DIFFICULTY.BASE) {
			//difficulty.tick();
			tank.tick();
			controller.tick();
		}else if(state == STATE.MENU) {
			//menu.tick();
		}
		
		
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////
		
		g.drawImage(backImg, 0, 0, null);
		
		if(state == STATE.DIFF) {
			difficulty.render(g);
		}else if(state == STATE.MENU) {
			menu.render(g);
		}else if(state == STATE.GAME) {
			tank.render(g);
			controller.render(g);
		}
		
		
		/////////////////////////////////
		g.dispose();
		bs.show();
	}



}
