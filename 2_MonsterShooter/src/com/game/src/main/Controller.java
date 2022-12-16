package com.game.src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.game.src.main.Game.DIFFICULTY;
import com.game.src.main.Game.STATE;

public class Controller extends JPanel {

	private LinkedList<EntityA> entitiesA = new LinkedList<EntityA>();
	private LinkedList<EntityB> entitiesB = new LinkedList<EntityB>();
	private Tank tank = new Tank(218, 300, this);

	EntityA entityA;
	EntityB entityB;
	private int spawn_count = 0;
	private int spawn_killed = 0;
	private int enemy_killed=0;
	Random rand = new Random();

	public Controller() {

	}

	public void tick() {

		if (tank.getHealth() == 0) {
			Game.state = STATE.GAMEOVER;
		}
		
		if(enemy_killed == 0) {
			Game.state = STATE.WIN;
		}
		
		tank.tick();

		for (int i = 0; i < entitiesA.size(); i++) {
			entityA = entitiesA.get(i);

			entityA.tick();
		}

		for (int i = 0; i < entitiesB.size(); i++) {
			entityB = entitiesB.get(i);

			entityB.tick();
		}

		if (spawn_killed == 5) {
			spawn_killed = 0;
			spawn_count = 0;
			addEnemy(5);
		}

	}

	public void render(Graphics g) {

		tank.render(g);
		g.drawRect(10, 10, 50, 200);
		g.setColor(Color.RED);
		g.fillRect(10, 10, 50, tank.getHealth() * 2);
		g.drawString(Integer.toString(enemy_killed), 400, 10);

		for (int i = 0; i < entitiesA.size(); i++) {

			entityA = entitiesA.get(i);
			entityA.render(g);
		}

		for (int i = 0; i < entitiesB.size(); i++) {

			entityB = entitiesB.get(i);
			entityB.render(g);
		}

	}

	public void addEntity(EntityA e) {
		entitiesA.add(e);
	}

	public void removeEntity(EntityA e) {
		entitiesA.remove(e);
	}

	public void addEntity(EntityB e) {
		entitiesB.add(e);
	}

	public void removeEntity(EntityB e) {
		entitiesB.remove(e);
		spawn_killed += 1;
	}
	
	public void countKilled() {
		enemy_killed--;
	}

	public LinkedList<EntityA> getEntitiesA() {
		return entitiesA;
	}

	public LinkedList<EntityB> getEntitiesB() {
		return entitiesB;
	}

	public EntityB getEntityB(int index) {
		return entitiesB.get(index);
	}

	public int getEntitiesASize() {
		return entitiesA.size();
	}

	public int getEntitiesBSize() {
		return entitiesB.size();
	}

	public void start() {

		if (Game.diff == DIFFICULTY.EASY) {

			enemy_killed = 10;
			addEnemy(10);

		} else if (Game.diff == DIFFICULTY.MEDIUM) {

			enemy_killed = 100;
			addEnemy(10);

		} else if (Game.diff == DIFFICULTY.HARD) {

			enemy_killed = 40;
			addEnemy(15);

		}

	}

	public void reset() {

		entitiesA.removeAll(entitiesA);
		entitiesB.removeAll(entitiesB);
		this.spawn_count = 0;
		this.spawn_killed = 0;
		this.enemy_killed=0;
		tank.reset();

	}

	public Tank getTank() {
		return tank;

	}

	public void addEnemy(int spawn_count) {
		for (int i = 0; i < spawn_count; i++) {

			addEntity(new Enemy(rand.nextInt((Main.WIDTH - Game.GRASS - Game.GRASS - 64)) + Game.GRASS,
					rand.nextInt(136) - 200, this));

			this.spawn_count++;
		}
	}
}
