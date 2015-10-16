package model;

import java.util.Random;

public class Room {

	
// our vertex for the room, central
private class Vertex {
	int[] vertex = new int[2];

	Vertex(int i, int j){
		vertex[0] = i;
		vertex[1] = j;
	}	
	public int getrow(){
		return vertex[1];
	}
	public int getcol(){
		return vertex[0];
	}
	
	public void setrow(int i){
		vertex[1] = i;
	}
	public void setcol(int i){
		vertex[0] = i;
	}
	
	

}

	public int RoomNumber;
	private Vertex vertex;

	private Random generator = new Random();

	public int width;
	public int height;
	
	public int T;
	public int R;
	public int B;
	public int L;
	
	public Room(){
		width = generator.nextInt(2)+2;
		height = generator.nextInt(2)+2;

		int i = (25 - width);
		int j = (25 - height);
		
		int a = generator.nextInt(i) + (width) + 1;
		int b = generator.nextInt(j) + (height) + 1;
		
		vertex = new Vertex(a, b);

		T = b - height;
		B = b + height + 1;
		L = a - width;
		R = a + width + 1;
	}
	
	public void setRN(int i){
		RoomNumber = i;
	}
	
	public void setVertex(int i, int j){
		vertex.setrow(i);
		vertex.setcol(j);
	}
	
	public int getVertexrow(){
		return vertex.getrow();
	}
	
	public int getVertexCol(){
		return vertex.getcol();
	}

	//checks borders
	public boolean tooClose(Room room) {
		if(L <= room.R + 1 && R+1 >= room.L && T <= room.B + 1 && B+1 >= room.T){			
		return true;
		}
		return false;
	}
}
