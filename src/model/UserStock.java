package model;

public class UserStock {

	private String username;
	private int milk;
	private int grape;
	private int mango;
	public UserStock() {
		super();
	}
	public UserStock(String username, int milk, int grape, int mango) {
		super();
		this.username = username;
		this.milk = milk;
		this.grape = grape;
		this.mango = mango;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	
	public int getMilk() {
		return milk;
	}
	public void setMilk(int milk) {
		this.milk = milk;
	}
	public int getGrape() {
		return grape;
	}
	public void setGrape(int grape) {
		this.grape = grape;
	}
	public int getMango() {
		return mango;
	}
	public void setMango(int mango) {
		this.mango = mango;
	}
	
	public void incMilk(){
		milk++;
	}
	public boolean decMilk(){
		if(milk>0){
			milk--;
			return true;
		} else {
			return false;
		}
	}
	public void incGrape(){
		grape++;
	}
	public boolean decGrape(){
		if(grape>0){
			grape--;
			return true;
		} else {
			return false;
		}
	}
	public void incMango(){
		mango++;
	}
	public boolean decMango(){
		if(mango>0){
			mango--;
			return true;
		} else {
			return false;
		}
	}
}
