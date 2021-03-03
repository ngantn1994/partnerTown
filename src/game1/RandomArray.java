package game1;

import java.util.Random;

public class RandomArray {
	private int number[];
	private int count;
	public void swap(int u, int v){
		int temp=number[u];
		number[u]=number[v];
		number[v]=temp;
	}
	
	public RandomArray(int a, int b){
		this.count = a*b;
		number = new int[count];
		for(int i=0;i<number.length/2;i++){
			number[i] = (i%20+1);
		}
		for(int i=(number.length/2);i<number.length;i++){
			number[i] = number[i-number.length/2];
		}
		Random ran = new Random();
		for(int i=0;i<number.length;i++){
			int r = ran.nextInt(number.length-1);
			swap(i,r);
		}
	}
	
	public int getNumber(int i){
		return number[i];
	}
	
	public int getLength(){
		return number.length;
	}
}
