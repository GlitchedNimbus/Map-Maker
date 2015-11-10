package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

//This class populates the dungeon with rooms, halls, and creatures

public class Floor {
	int[][] floor;
	private Random gen = new Random();

	// creates our rooms
	private int R = gen.nextInt(6) + 7;

	// ArrayList to hold valid pairs and added rooms
	ArrayList<Point> nonValid = new ArrayList<Point>();
	ArrayList<Room> added;

	public Floor() {
		floor = new int[40][40];
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				floor[i][j] = 1;
			}
		}
		setRooms();
		
		// creates a unique and valid point from which to start our hall method
		Point pont = new Point(gen.nextInt(37) + 2, gen.nextInt(37) + 2);
		while (!isValid(pont.x, pont.y))
			pont = new Point(gen.nextInt(37) + 2, gen.nextInt(37) + 2);
		addHalls(pont.x, pont.y);

		connectRooms();
		removeDeadEnds(40);
		addMonsters();
	}

	// creates the number of rooms set by our R
	// This will place our rooms, as they are generated and added to R
	private void setRooms() {
		added = new ArrayList<Room>();
		// this will produce all of the squares
		Room Nroom;
		int kill = 0;
		int i = 0;
		while (i < R) {

			// very first room added
			if (i == 0) {
				Nroom = new Room();
				added.add(Nroom);
				instantiateroom(Nroom);
				i++;
			}

			// all other rooms
			else {
				boolean isclear = false;
				Nroom = new Room();
				// checks to see if it is too close to any of the other
				// rectangles that have already been placed
				for (int k = 0; k < added.size(); k++) {
					if (Nroom.tooClose(added.get(k))) {
						isclear = false;
						break;
					} else {
						isclear = true;
					}
				}
				if (isclear) {
					added.add(Nroom);
					instantiateroom(Nroom);
					i++;
				}
			}

			kill++;
			if (kill > 10000) {
				R = i;
				break;
			}
		}
	}

	public void addHalls(int x, int y) {
		int checker = gen.nextInt(4);

		if ((!isValid(x + 2, y) && !isValid(x - 2, y) && !isValid(x, y + 2) && !isValid(
				x, y - 2))
				|| (!isValid(x + 1, y) && !isValid(x - 1, y)
						&& !isValid(x, y + 1) && !isValid(x, y - 1))) {
			return;
		}

		if (checker < 1 && (isValid(x - 2, y) && isValid(x - 1, y))) {
			x--;
			floor[x][y] = 0;
			nonValid.add(new Point(x, y));
			x--;
			floor[x][y] = 0;
			nonValid.add(new Point(x, y));
			addHalls(x, y);
		}

		else if (checker < 2 && (isValid(x + 2, y) && isValid(x + 1, y))) {
			x++;
			floor[x][y] = 0;
			nonValid.add(new Point(x, y));
			x++;
			floor[x][y] = 0;
			nonValid.add(new Point(x, y));
			addHalls(x, y);

		}

		else if (checker < 4 && (isValid(x, y - 2) && isValid(x, y - 1))) {
			y--;
			floor[x][y] = 0;
			nonValid.add(new Point(x, y));
			y--;
			floor[x][y] = 0;
			nonValid.add(new Point(x, y));
			addHalls(x, y);
		}

		else if (isValid(x, y + 2) && isValid(x, y + 1)) {
			y++;
			floor[x][y] = 0;
			nonValid.add(new Point(x, y));
			y++;
			floor[x][y] = 0;
			nonValid.add(new Point(x, y));
			addHalls(x, y);
		}

		addHalls(x, y);
	}

	// connects halls to the rooms
	private void connectRooms() {
		Room temp;
		int connections;

		for (int i = 0; i < added.size(); i++) {
			ArrayList<Point> Left = new ArrayList<Point>();
			ArrayList<Point> Right = new ArrayList<Point>();
			ArrayList<Point> Top = new ArrayList<Point>();
			ArrayList<Point> Bottom = new ArrayList<Point>();

			connections = gen.nextInt(2) + 1;


			temp = added.get(i);
			int L = temp.L;
			int R = temp.R;
			int T = temp.T;
			int B = temp.B;

			for (int j = temp.L; j < temp.R; j++) {
				if (floor[B + 1][j] == 0) {
					Bottom.add(new Point(B + 1, j));
				}
			}
			for (int j = temp.L; j < temp.R; j++) {
				if (floor[T - 2][j] == 0) {
					Top.add(new Point(T - 2, j));
				}
			}
			for (int j = temp.T; j < temp.B; j++) {
				if (floor[j][L - 2] == 0) {
					Left.add(new Point(j, L - 2));
				}
			}
			for (int j = temp.T; j < temp.B; j++) {
				if (floor[j][R + 1] == 0) {
					Right.add(new Point(j, R + 1));
				}
			}

			// No nearby connections, larger search radius
			if (Left.size() == 0 || Top.size() == 0 || Right.size() == 0
					|| Bottom.size() == 0) {
				if (B + 2 < 40) {
					for (int j = temp.L; j < temp.R; j++) {
						if (floor[B + 2][j] == 0) {
							Bottom.add(new Point(B + 2, j));
						}
					}
				}

				if (T - 3 > 0) {
					for (int j = temp.L; j < temp.R; j++) {
						if (floor[T - 3][j] == 0) {
							Top.add(new Point(T - 3, j));
						}
					}
				}

				if (L - 3 > 0) {
					for (int j = temp.T; j < temp.B; j++) {
						if (floor[j][L - 3] == 0) {
							Left.add(new Point(j, L - 3));
						}
					}
				}

				if (R + 2 < 40) {
					for (int j = temp.T; j < temp.B; j++) {
						if (floor[j][R + 2] == 0) {
							Right.add(new Point(j, R + 2));
						}
					}
				}
			}

			// generates connections
			while (connections > 0) {
				Point tomp;

				for (int o = 0; o < Top.size(); o++) {
					tomp = Top.get(o);
					if (connections == 0)
						break;
					if (gen.nextInt(100) < 1) {
						floor[tomp.x + 1][tomp.y] = 0;
						floor[tomp.x + 2][tomp.y] = 0;
						connections--;
					}
				}

				for (int o = 0; o < Left.size(); o++) {
					tomp = Left.get(o);
					if (connections == 0)
						break;
					if (gen.nextInt(100) < 1) {
						floor[tomp.x][tomp.y + 1] = 0;
						floor[tomp.x][tomp.y + 2] = 0;
						connections--;
					}
				}

				for (int o = 0; o < Right.size(); o++) {
					tomp = Right.get(o);
					if (connections == 0)
						break;
					if (gen.nextInt(100) < 1) {
						floor[tomp.x][tomp.y - 1] = 0;
						floor[tomp.x][tomp.y - 2] = 0;
						connections--;
					}
				}

				for (int o = 0; o < Bottom.size(); o++) {
					tomp = Bottom.get(o);
					if (connections == 0)
						break;
					if (gen.nextInt(100) < 1) {
						floor[tomp.x - 1][tomp.y] = 0;
						floor[tomp.x - 2][tomp.y] = 0;
						connections--;
					}
				}
			}
		}
	}

	// will set our spanning tree based on proximity
	private void createSpanningTree() {
	}

	private boolean isValid(int x, int y) {
		// TODO Auto-generated method stub
		int count = 0;
		if (x < 1 || x > 38)
			return false;

		if (y < 1 || y > 38)
			return false;

		return !nonValid.contains(new Point(x, y));
	}
	
	public void removeDeadEnds(int n) {
		int count = 0;
		int o = 0;
		while (o < n) {
			o++;
			for (int y = 1; y < 39; y++) {
				for (int x = 1; x < 39; x++) {
					count = 0;
					if (floor[x][y] == 0) {
						if (floor[x + 1][y] == 1)
							count++;
						if (floor[x - 1][y] == 1)
							count++;
						if (floor[x][y + 1] == 1)
							count++;
						if (floor[x][y - 1] == 1)
							count++;

						if (count == 3)
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
			if (x != y && !ST.contains(temp = new OrderedPair(x, y))
					&& !ST.contains(temp = new OrderedPair(y, x)))
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

	public void instantiateroom(Room inbound) {
		for (int i = inbound.T; i < inbound.B; i++) {
			for (int j = inbound.L; j < inbound.R; j++) {
				floor[i][j] = 0;
			}
		}
		for (int i = inbound.T - 1; i < inbound.B + 1; i++) {
			for (int j = inbound.L - 1; j < inbound.R + 1; j++) {
				nonValid.add(new Point(i, j));
			}
		}
	}

	public void addMonsters(){
		
	}
	public void tostring() {
		  for (int i = 0; i < 40; i++) { 
			  System.out.println(); 
			 for (int j = 0; j < 40; j++) { 
				 System.out.print(floor[i][j] );
				 }
			 }
	}
}