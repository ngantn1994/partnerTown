package model;

public class UserPet {
	
	private int stockID;
	private boolean visible;
	private String userName;
	private String petName;
	private int petID;
	private int currentLv;
	private int maxLv;
	private int HP;
	private int SP;
	private int happy;
	private int WC;
	
	public UserPet(){
		super();
	}
	
	public UserPet(int stockID, boolean visible, String userName, String petName, int petID, int currentLv, int hP, int sP,
			int happy, int wC) {
		super();
		this.stockID = stockID;
		this.visible = visible;
		this.userName = userName;
		this.petName = petName;
		this.petID = petID;
		this.currentLv = currentLv;
		HP = hP;
		SP = sP;
		this.happy = happy;
		WC = wC;
	}

	public int getStockID() {
		return stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	
	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetID() {
		return petID;
	}

	public void setPetID(int petID) {
		this.petID = petID;
	}

	public int getCurrentLv() {
		return currentLv;
	}

	public void setCurrentLv(int currentLv) {
		this.currentLv = currentLv;
	}
	
	public void incLevel(){
		if(currentLv<maxLv){
			currentLv++;
		}
	}
	
	public int getMaxLv() {
		return maxLv;
	}

	public void setMaxLv(int maxLv) {
		this.maxLv = maxLv;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public void incHP(){
		if(HP<5){
			HP=5;
		}
	}
	
	public void decHP(){
		if(HP>0){
			HP--;
		} else {
			setVisible(false);
		}
	}
	
	public int getSP() {
		return SP;
	}

	public void setSP(int sP) {
		SP = sP;
	}
	
	public void incSP() {
		SP++;
		if(SP%10==0){
			incLevel();
		}
	}

	public int getHappy() {
		return happy;
	}

	public void setHappy(int happy) {
		this.happy = happy;
	}
	
	public void incHappy(){
		if(happy<5){
			happy++;
		}
	}
	
	public void decHappy(){
		if(happy>0){
			happy--;
		} else {
			setVisible(false);
		}
	}

	public int getWC() {
		return WC;
	}

	public void setWC(int wC) {
		WC = wC;
	}
	
	public void incWC(){
		WC = 3;
	}
	
	public void decWC(){
		if(WC>0){
			WC--;
		} else {
			decHappy();
		}
	}
}
