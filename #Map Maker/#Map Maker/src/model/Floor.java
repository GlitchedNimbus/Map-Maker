package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Floor {
	int[][] floor;
	private Random gen = new Random();
	
	// creates our rooms
	private int R = gen.nextInt(6) + 7;
	
	// ArrayList to hold valid pairs and history of points
	ArrayList<Point> nonValid = new ArrayList<Point>();
	Stack<Point> history = new Stack<Point>();
	boolean done;
	// our spanning tree

	ArrayList<Room> Rooms;

	public Floor() {
		floor = new int[40][40];
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				floor[i][j] = 1;
			}
		}
		setRooms();
		addHalls(1,1);
		//removeDeadEnds(10);
		//createSpanningTree();
		// addEdges(gen.nextInt(12), (gen.nextInt(3)+1));
	}

	// creates the number of rooms set by our R
	// This will place our rooms, as they are generated and added to R
	private void setRooms() {
	ArrayList<Room> added = new ArrayList<Room>();
		// this will produce  all of the squares
		Room Nroom;
		int kill = 0;
		int i = 0;
		while(i < R){
			
			//very first room added
			if(i == 0){
				Nroom = new Room();
				added.add(Nroom);
				instantiateroom(Nroom);
				i++;
			}
			
			//all other rooms
			else{
				boolean isclear = false;
				Nroom = new Room();
				//checks to see if it is too close to any of the other rectangles that have already been placed
				for(int k = 0; k < added.size(); k++){
					if(Nroom.tooClose(added.get(k))){
						isclear = false;
						break;
					}
					else{
						isclear = true;
					}
				}
				if(isclear){
				added.add(Nroom);
				instantiateroom(Nroom);
				i++;
				}
			}
			
			kill++;
			if(kill > 10000){
				R = i;
				break;
			}
		}
	}

	// will set our spanning tree based on proximity
	private void createSpanningTree() {
	}
	
	public void addHalls(int x, int y){
	int checker = gen.nextInt(4);
	
	if((!isValid(x + 2,y) && !isValid(x - 2,y) && !isValid(x,y + 2) && !isValid(x,y - 2))
	|| (!isValid(x + 1,y) && !isValid(x - 1,y) && !isValid(x,y + 1) && !isValid(x,y - 1))){
		if(history.size() == 0){
			return;
			}
		else
			addHalls(history.peek().x,history.pop().y);
		}
	
	if(checker < 1 && (isValid(x - 2,y) && isValid(x - 1,y))){
		x--;
		floor[x][y] = 0;
		nonValid.add(new Point (x,y));
		x--;
		floor[x][y] = 0;
		nonValid.add(new Point (x,y));
		history.push(new Point (x,y));
		}
	
	else if(checker < 2 && (isValid(x + 2,y) && isValid(x + 1,y))){
		x++;
		floor[x][y] = 0;
		nonValid.add(new Point (x,y));
		x++;
		floor[x][y] = 0;
		nonValid.add(new Point (x,y));
	
	history.push(new Point (x,y));
		}
	
	else if(checker < 3 && (isValid(x,y - 2) && isValid(x,y - 1))){
		y--;
		floor[x][y] = 0;
		nonValid.add(new Point (x,y));
		y--;
		floor[x][y] = 0;
		nonValid.add(new Point (x,y));
		history.push(new Point (x,y));
		}
	
	else if(isValid(x,y + 2) && isValid(x,y + 1)){
		y++;
		floor[x][y] = 0;
		nonValid.add(new Point (x,y));
		y++;
		floor[x][y] = 0;
		nonValid.add(new Point (x,y));
		history.push(new Point (x,y));
			}	
	
	addHalls(x,y);
	}
	

	private boolean isValid(int x, int y) {
		// TODO Auto-generated method stub
		int count = 0;
		if(x < 1 || x > 38)
			return false;
		
		if(y < 1 || y > 38)
			return false;
		
		//3x3 square around check
		for(int i = x - 1; i < x + 1; i++){
			for(int j = y - 1; j < y + 1; j++){	
				if(floor[x][y] == 0){
					if(floor[x + 1][y] == 1)
						count++;
					if(floor[x - 1][y] == 1)
						count++;
					if(floor[x][y + 1] == 1)
						count++;
					if(floor[x][y - 1] == 1)
						count++;
					
					if(count > 1)
						return false;
					}
			}
		}
		return !nonValid.contains(new Point(x,y));
	}

	public void removeDeadEnds(int n){
		int count = 0;
		int o = 0;
		while(o < n){
			o++;
			for(int y = 1; y < 39; y++){
			for(int x = 1; x < 39; x++){
				count = 0;
				if(floor[x][y] == 0){
					if(floor[x + 1][y] == 1)
						count++;
					if(floor[x - 1][y] == 1)
						count++;
					if(floor[x][y + 1] == 1)
						count++;
					if(floor[x][y - 1] == 1)
						count++;
					
					if(count == 3)
					floor[x][y] = 1;
				}
			}
			}
		}
	}

	public void addEdges(int R, int E) {
		// this will add a random edge to our rooms as long as the two rooms are
		// not directly connected
		R = 7;
		OrderedPair one = new OrderedPair(1, 2);
		OrderedPair two = new OrderedPair(2, 3);
		OrderedPair three = new OrderedPair(3, 4);
		OrderedPair four = new OrderedPair(4, 5);
		OrderedPair five = new OrderedPair(5, 6);
		OrderedPair six = new OrderedPair(6, 7);

		ArrayList<OrderedPair> ST = new ArrayList<OrderedPair>();
		ST.add(one);
		ST.add(two);
		ST.add(three);
		ST.add(four);
		ST.add(five);
		ST.add(six);

		int[] roomnum = { 1, 2, 3, 4, 5, 6, 7 };

		int i = ST.size();
		OrderedPair temp;
		while (i + E > ST.size()) {
			int x = gen.nextInt(R);
			int y = gen.nextInt(R);
			if (x != y && !ST.contains(temp = new OrderedPair(x, y)) && !ST.contains(temp = new OrderedPair(y, x)))
				ST.add(temp = new OrderedPair(x, y));
		}
	}

	public void getGrid(int[][] i) {
		for (int j = 0; j < 40; j++) {
			for (int k = 0; k < 40; k++) {
				i[j][k] = floor[j][k];
			}
		}
	}
	
	public void instantiateroom(Room inbound){		
		for(int i = inbound.T; i < inbound.B; i++){
			for(int j = inbound.L; j < inbound.R; j++){
				floor[i][j] = 0;
				nonValid.add(new Point(i,j));
			}
		}
	}

	public void tostring() {
		/*
		 * for (int i = 0; i < 40; i++) { System.out.println(); for (int j = 0;
		 * j < 40; j++) { System.out.print(floor[i][j]); } }
		 */
		//System.out.println("# of Rooms " + R);
	}
}