package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MODEL.Account;

public abstract class AccountDAO implements DAOInterface{
	
	
	public Account getBalance(String userName, double balance) {
		
		
		try {
			String query = "SELECT * FROM BANK WHERE username =?";
			PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
			
			st.setString(1, userName);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				Account account = new Account();
				account.balance = rs.getDouble("balance");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} 
		
	public void setBalance(String userName, double balance) {
		try {
			String query = "SELECT * FROM BANK WHERE username =?";
			PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
			
			st.setString(1, userName);
			ResultSet rs = st.executeQuery();
			st.setDouble(2, balance);
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	
	
	

	@Override
	public boolean checkValidLogin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
		
	}
		
}
	


