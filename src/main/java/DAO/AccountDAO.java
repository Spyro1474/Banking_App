package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MODEL.Account;
import MODEL.Checking;
import MODEL.Savings;

public abstract class AccountDAO implements DAOInterface{
	
	Account getAccount(String userName) {
		Account account = new Account();
		try {
			String ac = "SELECT * FROM users FULL JOIN bank ON " + 
		"users.username = bank.username WHERE users.username = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
					.prepareStatement(ac);
			
			st.setString(1, userName);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				String passWord = rs.getString("password");
				String phoneNum = rs.getString("phoneNum");
				boolean empoloyee = rs.getBoolean("employee");
				double balance = rs.getDouble("balance");
				String accountType = rs.getString("accounttype");
				int accountNum = rs.getInt("accountNum");
				Account account;
				if (accountType.equalsIgnoreCase("checking")) {
					account = new Checking(accountNum, balance);
				} else if (accountType.equalsIgnoreCase("savings")) {
					account = new Savings(accountNum, balance);
				}
			
			
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
		
	}
	
	}

//public abstract void signup(String username, float balance, String accountType, int accountNum);
