package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetTypeDAO {
	
	public static final String PETID = "PetID";
	public static final String NUMOFLV = "NumOfLv";
	public static final String PRICE = "Price";
	public static final String DESCRIPTION = "Descrip";

	public static final String SELECT = "SELECT * FROM PetType WHERE PetID = ?";
	public static final String SELECT_ALL = "SELECT * FROM PetType";
	public static final String SELECT_ID = "SELECT PetID FROM PetType";
	
	private Connection connection;
	
	private static PetTypeDAO dao = new PetTypeDAO();
	
	public static PetTypeDAO getInstance() {
		return dao;
	}
	
	private PetTypeDAO () {
		connection = SQLConnection.getInstance();
	}
	
	public List<PetType> getAll(){
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_ALL);

				ResultSet resultSet = statement.executeQuery();

				List<PetType> types = new ArrayList<PetType>();
				
				while (resultSet.next()) {
					PetType type = new PetType();
					type.setID(resultSet.getInt(PETID));
					type.setLevels(resultSet.getInt(NUMOFLV));
					type.setPrice(resultSet.getInt(PRICE));
					type.setDescription(resultSet.getString(DESCRIPTION));
					
					types.add(type);
				}
				return types;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Can not Connect to SQL Server.");
		}
		return null;
	}
	
	public PetType getPetType(int petID) {
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT);
				statement.setInt(1, petID);

				ResultSet resultSet = statement.executeQuery();
				
				resultSet.next();

				PetType petType = new PetType();
				
				petType.setID(petID);
				petType.setLevels(resultSet.getInt(NUMOFLV));
				petType.setPrice(resultSet.getInt(PRICE));
				petType.setDescription(resultSet.getString(DESCRIPTION));
				
				return petType;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Can not Connect to SQL Server.");
		}
		return null;
	}
	
	public List<Integer> getAllID(){
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_ID);

				ResultSet resultSet = statement.executeQuery();

				List<Integer> ids = new ArrayList<Integer>();
				
				while (resultSet.next()) {
					ids.add(resultSet.getInt(PETID));
				}
				return ids;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Can not Connect to SQL Server.");
		}
		return null;
	}
	
	public int getNumOfLevel(int petID){
		PetType petType = getPetType(petID);
		return petType.getLevels();
	}
	
	public int getPrice(int petID){
		PetType petType = getPetType(petID);
		return petType.getPrice();
	}
	
	public String getDescription(int petID){
		PetType petType = getPetType(petID);
		return petType.getDescription();
	}
}