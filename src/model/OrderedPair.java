package model;
class OrderedPair{
	//	
	int orderedpair [] = new int[2];
		
		OrderedPair(int i, int j){
		orderedpair[0] = i;
		orderedpair[1] = j;
		}
		
		public int getrow(){
			return orderedpair[0];
		}
		public int getcol(){
			return orderedpair[1];
		}
	}