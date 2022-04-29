package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MODEL.Customer;


public class BankDAO implements DAOInterface{
	
	private static Connection conn = ConnectionManager.getConnection();
		
		public ArrayList <Customer> getCustomers() {
			
			try {
				
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery("select * from Users left join Bank on users.username = bank.username;");
				ArrayList <Customer> customer = new ArrayList <Customer>();
				
				while (rs.next()) {
					
					String userName = rs.getString("username");
					String passWord = rs.getString("passcode");
					String phoneNum = rs.getString("phoneNum");
					double balance = rs.getDouble("balance");
					String accountType = rs.getString("accounttype");
					int accountNum = rs.getInt("accountnum");
					
					customer.add(new Customer(userName, passWord, phoneNum, balance, accountType, accountNum, null));
					
				} return customer;
				
			} catch (SQLException e) {
				e.printStackTrace();
		} return null;
	}
		

		@Override
		public boolean checkValidLogin(String username, String password) {
			// TODO Auto-generated method stub
			return false;
		}

}
