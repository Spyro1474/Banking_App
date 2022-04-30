package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAO implements DAOInterface{
	
	
	public static void createAnAccount(String userName, String passWord, String phoneNum, String accountType, boolean employee, double initialDeposit) {
		try {
			if(checkUsername(userName)) {
				String addAccount = "INSERT INTO Users " +
								 "VALUES (?, ?, ?, ?);";
				PreparedStatement st = ConnectionManager.getConnection()
													    .prepareStatement(addAccount, Statement.RETURN_GENERATED_KEYS);
				st.setString(1, userName);
				st.setString(2, passWord);
				st.setString(3, phoneNum);
				st.setBoolean(4, employee);
				st.executeUpdate();
				
				ResultSet rs = st.getGeneratedKeys();
				
				String addAccount2 = "INSERT INTO Bank " +
						 			"VALUES (?, ?, ?) returning accountNum;";
		PreparedStatement st2 = ConnectionManager.getConnection()
											    .prepareStatement(addAccount2, Statement.RETURN_GENERATED_KEYS);
		st2.setString(1, userName);
		st2.setDouble(2, initialDeposit);
		st2.setString(3, accountType);
		st2.executeUpdate();
		
		ResultSet rs2 = st.getGeneratedKeys();
		if(rs.next()) {
			
		}
		
		
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	public static void getAccountNum(String userName) {
		
		try {
			String query = "SELECT accountNum FROM bank WHERE bank.username = ?";
			PreparedStatement st = ConnectionManager.getConnection()
					.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, userName);
			
			st.executeQuery();
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	} 
		
	public boolean checkValidLogin(String userName, String passWord) {
		try {
			String query = "SELECT * " +
					 	   "FROM Users " +
					 	   "WHERE username = ? " +
					 	   "AND passcode = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
				    								.prepareStatement(query);
			st.setString(1, userName);
			st.setString(2, passWord);
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean checkUsername(String userName) {
		try {
			String query = "SELECT * FROM Users " +
						   "WHERE username = ?;";
			
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(query);
			st.setString(1, userName);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return false;
			} // end if
			
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		
		return false;
	} // end checkUsername()

	
	

	public boolean deleteAccount(String userName) {
		try {
			String delete = "SELECT * FROM users FULL JOIN bank ON " +
		"users.username = bank.username WHERE users.username = ?;";
			
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(delete);
			st.setString(1, userName);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return false;
			} // end if
			
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		return false;
		
		
	} // end delete()
		

	public boolean updateAccount(double balance, int accountNum) {
		try {
			String update = "UPDATE bank SET balance = ? WHERE accountnum = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
					.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);

			
			st.setInt(2, accountNum);
			st.setDouble(1, balance);
			st.executeUpdate();
			
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()) {
			
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		return true;

	}
	public static void getAccountNum(int accountNum) {
		// TODO Auto-generated method stub
		
	} 
		
}

