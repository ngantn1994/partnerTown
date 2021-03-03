package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserPetDAO {
	
	public static final String STOCKID = "StockID";
	public static final String VISIBLE = "Visible";
	public static final String USERNAME = "UserName";
	public static final String PETNAME = "PetName";
	public static final String PETID = "PetID";
	public static final String CURRENTLV = "CurrentLv";
	public static final String MAXLV = "MaxLv";
	public static final String HP = "HP";
	public static final String SP = "SP";
	public static final String HAPPY = "Happy";
	public static final String WC = "WC";
	
	public static final String	SELECTALL	= "SELECT * FROM UserPet WHERE UserName = ?";
	public static final String	INSERT = "INSERT INTO UserPet VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String	UPDATE_NAME = "UPDATE UserPet SET PetName = ? WHERE StockID = ?";
	public static final String	UPDATE_LEVEL = "UPDATE UserPet SET CurrentLv = ? WHERE StockID = ?";
	public static final String	UPDATE_HP = "UPDATE UserPet SET HP = ? WHERE StockID = ?";
	public static final String	UPDATE_SP = "UPDATE UserPet SET SP = ? WHERE StockID = ?";
	public static final String	UPDATE_HAPPY = "UPDATE UserPet SET Happy = ? WHERE StockID = ?";
	public static final String	UPDATE_WC = "UPDATE UserPet SET WC = ? WHERE StockID = ?";
	public static final String	UPDATE_VISIBLE = "UPDATE UserPet SET Visible = ? WHERE StockID = ?";
	public static final String	DELETE	= "DELETE FROM UserPet WHERE StockID = ?";
	
	public static final String[] DEFAULT_NAME = {"Toto", "Titi", "Tata", "Tutu"};
	
	private Connection connection;
	
	private static UserPetDAO dao = new UserPetDAO();
	
	public static UserPetDAO getInstance() {
		return dao;
	}
	
	private UserPetDAO () {
		connection = SQLConnection.getInstance();
	}
	
	public List<UserPet> getAllUserPet(String username) {
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement(SELECTALL);
				statement.setString(1, username.toLowerCase());

				ResultSet resultSet = statement.executeQuery();

				List<UserPet> pets = new ArrayList<UserPet>();
				
				while (resultSet.next()) {
					UserPet pet = new UserPet();
					pet.setStockID(resultSet.getInt(STOCKID));
					pet.setVisible(resultSet.getBoolean(VISIBLE));
					pet.setUserName(resultSet.getString(USERNAME));
					pet.setPetName(resultSet.getString(PETNAME));
					pet.setPetID(resultSet.getInt(PETID));
					pet.setCurrentLv(resultSet.getInt(CURRENTLV));
					pet.setMaxLv(resultSet.getInt(MAXLV));
					pet.setHP(resultSet.getInt(HP));
					pet.setSP(resultSet.getInt(SP));
					pet.setHappy(resultSet.getInt(HAPPY));
					pet.setWC(resultSet.getInt(WC));
					
					pets.add(pet);
				}
				return pets;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Can not Connect to SQL Server.");
		}
		return null;
	}
	
	public void newPet(int petType, String userName){		
		if (connection != null) {
			try {	
				PetTypeDAO petTypeDao = PetTypeDAO.getInstance();
			
				Random ran = new Random();
				int r = ran.nextInt(DEFAULT_NAME.length-1);
			
				PreparedStatement statement = connection.prepareStatement(INSERT);
				
				statement.setBoolean(1, true);
				statement.setString(2, userName);
				statement.setString(3, DEFAULT_NAME[r]);
				statement.setInt(4, petType);
				statement.setInt(5, 1);
				statement.setInt(6, petTypeDao.getNumOfLevel(petType));
				statement.setInt(7, 5);
				statement.setInt(8, 1);
				statement.setInt(9, 5);
				statement.setInt(10, 3);
				
				statement.execute();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateName(UserPet pet){
		if(connection != null && pet != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_NAME);

				statement.setString(1, pet.getPetName());
				
				statement.setInt(2, pet.getStockID());
				
				statement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateLevel(UserPet pet){
		if(connection != null && pet != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_LEVEL);

				statement.setInt(1, pet.getCurrentLv());
				
				statement.setInt(2, pet.getStockID());
				
				statement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateHP(UserPet pet){
		if(connection != null && pet != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_HP);

				statement.setInt(1, pet.getHP());
				
				statement.setInt(2, pet.getStockID());
				
				statement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateSP(UserPet pet){
		if(connection != null && pet != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_SP);

				statement.setInt(1, pet.getSP());
				
				statement.setInt(2, pet.getStockID());
				
				statement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateHappy(UserPet pet){
		if(connection != null && pet != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_HAPPY);

				statement.setInt(1, pet.getHappy());
				
				statement.setInt(2, pet.getStockID());
				
				statement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateWC(UserPet pet){
		if(connection != null && pet != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_WC);

				statement.setInt(1, pet.getWC());
				
				statement.setInt(2, pet.getStockID());
				
				statement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateVisible(UserPet pet){
		if(connection != null && pet != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_VISIBLE);

				statement.setBoolean(1, pet.getVisible());
				
				statement.setInt(2, pet.getStockID());
				
				statement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(UserPet pet) {
		if (connection != null && pet != null) {
			try {
				PreparedStatement statement = connection.prepareStatement(DELETE);
				
				statement.setInt(1, pet.getStockID());
				
				statement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
