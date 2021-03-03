package game2;

import java.util.Random;

public class Game2Model {
	
	private int value1;
	private int value2;
	private int sum;
	private Random ran;
	
	private static Game2Model model = new Game2Model();
	
	public static Game2Model getInstance(){
		return model;
	}
	
	private Game2Model(){
		ran = new Random();
	}
	
	public void newEquation(){
		value1 = ran.nextInt(9) + 1;
		value2 = ran.nextInt(9) + 1;
		
		sum = value1 + value2;
	}

	public int getValue1() {
		return value1;
	}

	public int getValue2() {
		return value2;
	}

	public int getSum() {
		return sum;
	}

	public boolean check(int s){
		if (s == sum){
			return true;
		} else {
			return false;
		}
	}

}
