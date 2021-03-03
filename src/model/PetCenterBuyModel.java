package model;

import java.util.List;

public class PetCenterBuyModel {
	
	private PetTypeDAO dao;
	private UserDAO userdao;
	private UserPetDAO petdao;
	
	public PetCenterBuyModel(){
		super();
		userdao = UserDAO.getInstance();
		dao = PetTypeDAO.getInstance();
		petdao = UserPetDAO.getInstance();
	}
	
	public List<PetType> getPetTypes() {
		return dao != null ? dao.getAll() : null;
	}
	
	public List<Integer> getAllID(){
		return dao != null ? dao.getAllID() : null;
	}
	
	public void buy(int id, User user){
		user.decMoney(dao.getPrice(id));
		userdao.updateMoney(user);
		petdao.newPet(id, user.getUsername());
	}

}
