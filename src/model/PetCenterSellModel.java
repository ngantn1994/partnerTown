package model;

import java.util.ArrayList;
import java.util.List;

public class PetCenterSellModel {
	
	private UserDAO userdao;
	private UserPetDAO petdao;
	private String userName;
	
	public PetCenterSellModel(User user) {
		super();
		userdao = UserDAO.getInstance();
		petdao = UserPetDAO.getInstance();
		userName = user.getUsername();
	}
	
	public List<UserPet> getUserPets() {
		return petdao != null ? getPets(userName) : null;
	}
	
	public void deleteUserPet(UserPet pet) {
		if(petdao != null && pet != null) {
			petdao.delete(pet);
		}
	}
	
	public List<UserPet> getPets(String userName){
		List<UserPet> all = petdao.getAllUserPet(userName);
		List<UserPet> pets = new ArrayList<UserPet>();
		for(int i = 0;i<all.size();i++){
			if(all.get(i).getVisible()){
				pets.add(all.get(i));
			}
		}
		return pets;
	}

	private int getPrice(UserPet pet){
		int temp = pet.getCurrentLv();
		switch(temp) {
		case 1:
			return 250;
		case 2:
			return 800;
		case 3:
			return 1500;
		case 4:
			return 2500;
		case 5:
			return 5000;
		default:
			return 0;
		}
	}
	
	public void sell (UserPet pet, User user){
		petdao.delete(pet);
		user.incMoney(getPrice(pet));
		userdao.updateMoney(user);
	}
	
}
