package com.game.src.main;

import java.util.LinkedList;

public class Physics {

	public static boolean Collision(EntityA entityA, LinkedList<EntityB>entitiesB) {
		for(int i=0; i<entitiesB.size(); i++) {
			
			if(entityA.getBounds().intersects(entitiesB.get(i).getBounds())) {
				return true;
			};
		}
		return false;
	}
	
	public static boolean Collision(EntityB entityB, LinkedList<EntityA>entitiesA) {
		for(int i=0; i<entitiesA.size(); i++) {
			
			if(entityB.getBounds().intersects(entitiesA.get(i).getBounds())) {
				return true;
			};
		}
		return false;
	}
}
