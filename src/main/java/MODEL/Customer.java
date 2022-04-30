package MODEL;

import DAO.AccountDAO;
import DAO.CustomerDAO;

public class Customer {

	private String userName;
	private String passWord;
	private String phoneNum;
	private Account accountNum;

	public Customer(String userName, String passWord, String phoneNum, Account accountNum) {
		
		AccountDAO.getAccount(userName, passWord, phoneNum, accountNum);
		
		
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNum = phoneNum;
		this.accountNum = accountNum;
	}
	
	@Override
	public String toString() {
		return " Customer Information \n " +
				" Username: " + userName + "\n" +
				" Password: " + passWord + "\n" +
				" Phone Number: " + phoneNum + "\n" +
				accountNum;
	}
	
	Account getAccount() {
		
		return accountNum;
	}
	
	public String basicInfo() {
		return 	" Username: " + userName + "\n" +
				"   Phone Number: " + phoneNum;
	}
}
