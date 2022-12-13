package com.game.src.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

	private List<Entity> entities = new ArrayList<Entity>();
	
	Entity entity;
	Random rand = new Random();
	
	public Controller() {
	
		addEntity(new Enemy(rand.nextInt((Main.WIDTH-Game.GRASS-Game.GRASS-64))+Game.GRASS, 0));
		
	}
	
	public void tick() {
		
		 for(int i=0; i< entities.size(); i++) {
			 entity = entities.get(i);
			 
			 if(entity.getY()<0) {
				 removeEntity(entity);
			 }
			 
			 entity.tick();
		 }
	}
	
	public void render(Graphics g) {
		
		 for(int i=0; i< entities.size(); i++) {
			 
			 entity = entities.get(i);
			 entity.render(g);
		 }
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void removeEntity(Entity e) {
		entities.remove(e);
	}
}
	
	
	