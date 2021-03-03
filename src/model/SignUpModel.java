package model;

public class SignUpModel {
	
	private UserDAO userDAO;
	
	public SignUpModel(){
		super();
		userDAO = UserDAO.getInstance();
	}

	public void signUp(User user){
		userDAO.signUp(user);
		userDAO.createNewStock(user);
	}
	
	public boolean checkAvaible(String username){
		if(userDAO.checkAvaible(username)){
			return true;
		} else {
			return false;
		}
	}
	
}
