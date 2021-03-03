package controller;

import java.util.List;

import model.User;
import model.UserPet;
import model.UserPetDAO;
import model.UserStock;

public class Information {
	
	private User user;
	private List<UserPet> pets;
	private UserStock stock;
	
	private static Information information = new Information();
	
	private Information(){
		user = LogInController.getUser();
		pets = LogInController.getPets();
		stock = LogInController.getStock();
		for(int i=0; i<pets.size(); i++){
			pets.get(i).decHP();
			UserPetDAO.getInstance().updateHP(pets.get(i));
		}
	}
	
	public User getUser(){
		return user;
	}
	
	public List<UserPet> getPets(){
		return pets;
	}
	
	public UserStock getStock(){
		return stock;
	}
	
	public void setPets(List<UserPet> pets){
		this.pets = pets;
	}
	
	public static Information getInstance(){
		return information;
	}

}
