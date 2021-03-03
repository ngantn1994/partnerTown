package model;

import java.util.List;

import view.StringPasswordField;

public class LogInModel {

	private UserDAO userDAO;
	private UserPetDAO petDAO;
	private String username;
	private User user;
	private List<UserPet> pets;
	private UserStock stock;
	
	public LogInModel(){
		super();
		userDAO = UserDAO.getInstance();
		petDAO = UserPetDAO.getInstance();
	}

	public boolean checkLogIn(String username, StringPasswordField password){
		if(userDAO.logIn(username, password)){
			this.username = username.toLowerCase();
			this.user = userDAO.getUser(username);
			this.pets = petDAO.getAllUserPet(username);
			this.stock = userDAO.getStock(username);
			return true;
		} else {
			return false;
		}
	}
	
	public String getUsername() {
		return username;
	}

	public User getUser() {
		return user;
	}

	public List<UserPet> getPets() {
		return pets;
	}

	public UserStock getStock(){
		return stock;
	}

}
