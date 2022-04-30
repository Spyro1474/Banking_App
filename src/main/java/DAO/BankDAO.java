package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankDAO implements DAOInterface{

	public boolean checkValidLogin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean ExitProgram() {//this is only for debugging and will reset the database 
		try {
			String Exit = "TRUNCATE Users, Bank RESTART IDENTITY;";
			PreparedStatement st = ConnectionManager.getConnection()
					.prepareStatement(Exit, Statement.RETURN_GENERATED_KEYS);

			
			st.executeUpdate();
			
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()) {
			
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		return true;

	}
	
	

}
