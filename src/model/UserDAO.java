package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.StringPasswordField;

public class UserDAO {
	
	public static final String USERNAME = "UserName";
	public static final String PASSWORD = "Password";
	public static final String EMAIL = "Email";
	public static final String ADDRESS = "Address";
	public static final String SEX = "Sex";
	public static final String NUMOFPET = "NumOfPet";
	public static final String MONEY = "Money";
	public static final String ENERGY = "Energy";
	
	public static final String FOOD = "Food";
	public static final String ENERGY_1 = "Energy_1";
	public static final String ENERGY_5 = "Energy_5";
	
	public static final String	SELECT_PASSWORD = "SELECT Password FROM UserInformation WHERE UserName = ?";
	public static final String	SELECT_USERNAME = "SELECT UserName FROM UserInformation";
	public static final String	SELECT	= "SELECT * FROM UserInformation WHERE UserName = ?";
	public static final String	INSERT = "INSERT INTO UserInformation VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String  UPDATE_INFORMATION = "UPDATE UserInformation SET Email = ?, Address = ?, "
			+ "Sex = ? WHERE UserName = ?";
	public static final String  UPDATE_NUMOFPET = "UPDATE UserInformation SET NumOfPet = ? WHERE UserName = ?";
	public static final String  UPDATE_MONEY = "UPDATE UserInformation SET Money = ? WHERE UserName = ?";
	public static final String  UPDATE_ENERGY = "UPDATE UserInformation SET Energy = ? WHERE UserName = ?";
	public static final String  UPDATE_PASSWORD = "UPDATE UserInformation SET PASSWORD = ? WHERE UserName = ?";
	
	public static final String	SELECT_STOCK = "SELECT * FROM UserStock WHERE UserName = ?";
	public static final String	INSERT_STOCK = "INSERT INTO UserStock VALUES (?, ?, ?, ?)";
	public static final String  UPDATE_FOOD = "UPDATE UserStock SET Food = ? WHERE UserName = ?";
	public static final String  UPDATE_ENERGY_1 = "UPDATE UserStock SET Energy_1 = ? WHERE UserName = ?";
	public static final String  UPDATE_ENERGY_5 = "UPDATE UserStock SET Energy_5 = ? WHERE UserName = ?";
	
	private Connection connection;
	
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		return dao;
	}
	
	private UserDAO () {
		connection = SQLConnection.getInstance();
	}
	
	public boolean logIn(String username, StringPasswordField password){
		if(connection != null){
			try {
				
				PreparedStatement statement = connection.prepareStatement(SELECT_PASSWORD);
				statement.setString(1, username.toLowerCase());

				ResultSet resultSet = statement.executeQuery();
				
				if(!resultSet.isBeforeFirst()){
					resultSet.close();
		            statement.close();
					return false;
				}
				resultSet.next();
				String temp = resultSet.getString(PASSWORD);
			
				if(temp != null){
					if(password.isMatch(temp)){
						resultSet.close();
			            statement.close();
						return true;
					} else {
						resultSet.close();
			            statement.close();
						return false;
					}	
				}
				resultSet.close();
	            statement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return false;
		}
		return false;
	}
	
	public boolean checkAvaible(String username){
		if(connection != null){
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_USERNAME);

				ResultSet resultSet = statement.executeQuery();
				
				if(!resultSet.isBeforeFirst()){
					resultSet.close();
		            statement.close();
					return true;
				}
				
				while(resultSet.next()){
					if(username.equalsIgnoreCase(resultSet.getString(USERNAME))){
						resultSet.close();
			            statement.close();
						return false;
					}
				}
				resultSet.close();
	            statement.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return false;
		}
		return false;
	}
	
	public User getUser(String username) {
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT);
				statement.setString(1, username.toLowerCase());

				ResultSet resultSet = statement.executeQuery();
				
				if(resultSet.isBeforeFirst()){
					resultSet.next();
				}
				
				User user = new User();
				user.setUsername(resultSet.getString(USERNAME));
				user.setPassword(resultSet.getString(PASSWORD));
				user.setEmail(resultSet.getString(EMAIL));
				user.setAddress(resultSet.getString(ADDRESS));
				user.setSex(resultSet.getBoolean(SEX));
				user.setNumOfPet(resultSet.getInt(NUMOFPET));
				user.setMoney(resultSet.getInt(MONEY));
				user.setEnergy(resultSet.getInt(ENERGY));
				
				resultSet.close();
	            statement.close();
				
				return user;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Can not Connect to SQL Server.");
		}
		return null;
	}
	
	public void signUp(User user){
		if(connection != null && user != null){
			try {
				PreparedStatement statement = connection.prepareStatement(INSERT);
				
				statement.setString(1, user.getUsername().toLowerCase());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getEmail());
				statement.setString(4, user.getAddress());
				statement.setBoolean(5, user.isSex());
				statement.setInt(6, user.getNumOfPet());
				statement.setInt(7, user.getMoney());
				statement.setInt(8, user.getEnergy());
				
				statement.execute();

	            statement.close();
	            
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createNewStock(User user){
		if(connection != null && user != null){
			try {
				PreparedStatement statement = connection.prepareStatement(INSERT_STOCK);
				
				statement.setString(1, user.getUsername().toLowerCase());
				statement.setInt(2, 0);
				statement.setInt(3, 0);
				statement.setInt(4, 0);
				
				statement.execute();

	            statement.close();
	            
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateInformation(User user){
		if(connection != null && user != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_INFORMATION);

				statement.setString(1, user.getEmail());
				statement.setString(2, user.getAddress());
				statement.setBoolean(3, user.isSex());
				
				statement.setString(4, user.getUsername());
				
				statement.execute();
				
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateNumOfPet(User user){
		if(connection != null && user != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_NUMOFPET);

				statement.setInt(1, user.getNumOfPet());
				
				statement.setString(2, user.getUsername());
				
				statement.execute();
				
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateMoney(User user){
		if(connection != null && user != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_MONEY);

				statement.setInt(1, user.getMoney());
				
				statement.setString(2, user.getUsername());
				
				statement.execute();
				
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateEnergy(User user){
		if(connection != null && user != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_ENERGY);

				statement.setInt(1, user.getEnergy());
				
				statement.setString(2, user.getUsername());
				
				statement.execute();
				
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updatePassword(User user){
		if(connection != null && user != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_PASSWORD);

				statement.setString(1, user.getPassword());
				
				statement.setString(2, user.getUsername());
				
				statement.execute();
				
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateFood(UserStock stock){
		if(connection != null && stock != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_FOOD);

				statement.setInt(1, stock.getMilk());
				
				statement.setString(2, stock.getUserName());
				
				statement.execute();
				
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateEnergy1(UserStock stock){
		if(connection != null && stock != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_ENERGY_1);

				statement.setInt(1, stock.getGrape());
				
				statement.setString(2, stock.getUserName());
				
				statement.execute();
				
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateEnergy5(UserStock stock){
		if(connection != null && stock != null){
			try {
				PreparedStatement statement = connection.prepareStatement(UPDATE_ENERGY_5);

				statement.setInt(1, stock.getMango());
				
				statement.setString(2, stock.getUserName());
				
				statement.execute();
				
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public UserStock getStock(String username){
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_STOCK);
				statement.setString(1, username);

				ResultSet resultSet = statement.executeQuery();
				
				while(resultSet.next()){
				
					UserStock stock = new UserStock();
					stock.setUserName(resultSet.getString(USERNAME));
					stock.setMilk(resultSet.getInt(FOOD));
					stock.setGrape(resultSet.getInt(ENERGY_1));
					stock.setMango(resultSet.getInt(ENERGY_5));
					return stock;
				}
				resultSet.close();
	            statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Can not Connect to SQL Server.");
		}
		return null;
	}
}
