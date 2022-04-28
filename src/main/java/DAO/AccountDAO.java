package DAO;

public abstract class AccountDAO implements DAOInterface{

	@Override
	public boolean checkValidLogin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	public abstract void signup(String username, float balance, String accountType, int accountNum);
	
	
	
	}

}
