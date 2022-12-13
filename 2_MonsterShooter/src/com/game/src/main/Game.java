package com.game.src.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	private boolean running = false;
	private Thread thread;
	
	private Tank tank;
	private Controller controller;
	
	//Grass right-left area size : 70px each 
	public static final int GRASS = 70;
	private BufferedImage backImg = null;
	private String backPath = "/Arena.jpg";
	
	public void init() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		backImg = loader.loadImage(backPath);
		
		tank = new Tank(218, 300);
		controller = new Controller();
		
		requestFocus();
		addKeyListener(new KeyboardPanel(tank,controller));
		
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
		
		tank.tick();
		controller.tick();
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
		
		tank.render(g);
		controller.render(g);
		
		/////////////////////////////////
		g.dispose();
		bs.show();
	}



}
