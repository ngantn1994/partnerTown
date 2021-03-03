package game3;

import java.util.Random;

public class Game3Model {
	
	private int value;
	private Random ran;
	
private static Game3Model model = new Game3Model();

	public static Game3Model getInstance(){
		return model;
	}
	
	private Game3Model(){
		ran = new Random();
	}
	
	public void newEquation(){
		value = ran.nextInt(3);
	}

	public int getValue() {
		return value;
	}

	public boolean check(int s){
		if (s == value){
			return true;
		} else {
			return false;
		}
	}

}
