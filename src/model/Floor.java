package model;

import java.util.ArrayList;
import java.util.Random;

public class Floor {
	int[][] floor;
	private Random gen = new Random();
	// creates our rooms
	private int R = gen.nextInt(5) + 6;

	// our spanning tree

	ArrayList<Room> Rooms;

	public Floor() {
		floor = new int[30][30];
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				floor[i][j] = 1;
			}
		}
		setRooms();
		createSpanningTree();
		tostring();
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
			
			System.out.println("ROOMS: " +  i);
			kill++;
			if(kill > 10000)
				break;
		}
	}

	// will set our spanning tree based on proximity
	private void createSpanningTree() {

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
		for (int j = 0; j < 30; j++) {
			for (int k = 0; k < 30; k++) {
				i[j][k] = floor[j][k];
			}
		}
	}
	
	public void instantiateroom(Room inbound){		
		for(int i = inbound.T; i < inbound.B; i++){
			for(int j = inbound.L; j < inbound.R; j++){
				floor[i][j] = 0;
			}
		}
	}

	public void tostring() {
		/*
		 * for (int i = 0; i < 30; i++) { System.out.println(); for (int j = 0;
		 * j < 30; j++) { System.out.print(floor[i][j]); } }
		 */
		//System.out.println("# of Rooms " + R);
	}
}