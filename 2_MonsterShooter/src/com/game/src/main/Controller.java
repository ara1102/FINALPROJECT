package com.game.src.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class Controller extends JPanel {

	private LinkedList<EntityA> entitiesA = new LinkedList<EntityA>();
	private LinkedList<EntityB> entitiesB = new LinkedList<EntityB>();
	private Tank tank= new Tank(218, 300,this);;
	
	EntityA entityA;
	EntityB entityB;
	Random rand = new Random();
	
	public Controller() {
		
	}
	
	public void tick() {
		
		tank.tick();
		
		 for(int i=0; i< entitiesA.size(); i++) {
			 entityA = entitiesA.get(i);
			 
			 entityA.tick();
		 }
		 
		 for(int i=0; i< entitiesB.size(); i++) {
			 entityB = entitiesB.get(i);
			 
			 entityB.tick();
		 }
		 
	}
	
	public void render(Graphics g) {
		
		tank.render(g);
		
		 for(int i=0; i< entitiesA.size(); i++) {
			 
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
	}
	
	public LinkedList<EntityA> getEntitiesA(){
		return entitiesA;	
	}
	
	public LinkedList<EntityB> getEntitiesB(){
		return entitiesB;	
	}
	
	public int getEntitiesASize(){
		return entitiesA.size();	
	}
	
	public int getEntitiesBSize(){
		return entitiesB.size();	
	}
	
	public void start() {
		
		if(Game.diff == Game.diff.EASY) {
			
			addEntity(new Enemy(rand.nextInt((Main.WIDTH-Game.GRASS-Game.GRASS-64))+Game.GRASS, 0,this));
			
		}else if(Game.diff == Game.diff.MEDIUM) {
			
			addEntity(new Enemy(rand.nextInt((Main.WIDTH-Game.GRASS-Game.GRASS-64))+Game.GRASS, 0,this));
			
		}else if(Game.diff == Game.diff.HARD) {
			
			addEntity(new Enemy(rand.nextInt((Main.WIDTH-Game.GRASS-Game.GRASS-64))+Game.GRASS, 0,this));
			
		}
		
	}
	
	public Tank getTank() {
		return tank;
		
	}
}
	
	
	