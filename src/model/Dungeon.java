package model;

import java.util.Random;

public class Dungeon {
	/*
	 * [a][b][c] 
	 * a = rows
	 * b = columns
	 * c = floors
	 */
	private Random generator = new Random();

	Floor[] Dungeon;
	
	
	Dungeon(int i){
		Dungeon = new Floor[i]; 
		addAllFloors(i);
	}
	
	public void addAllFloors(int i){
		while(i > 0){
			Dungeon[i] = new Floor();
			i--; 
		}
	}

}
