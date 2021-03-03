package model;

public class PetType {
	
	private int petID;
	private int levels;
	private int price;
	private String description;
	
	public PetType() {
		super();
	}

	public PetType(int iD, int levels, int price) {
		super();
		petID = iD;
		this.levels = levels;
		this.price = price;
	}

	public int getID() {
		return petID;
	}

	public void setID(int iD) {
		petID = iD;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}

}
