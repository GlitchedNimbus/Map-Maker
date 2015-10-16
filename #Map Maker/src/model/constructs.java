package model;
public enum constructs {
		   WALL(0),FLOOR(1),CHEST(2),ENEMY(3),
		   UP_STAIRS(4),DOWN_STAIRS(5);
		   
private int value;

constructs(int val){
value = val;
}

public int getValue(){
return value;
}
}
