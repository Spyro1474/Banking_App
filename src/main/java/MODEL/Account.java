package MODEL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAO.AccountDAO;
import DAO.CustomerDAO;

public class Account {
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	CustomerDAO customerDAO = new CustomerDAO();
	
	public String userName = "";
	public Double balance;
	public int accountNum;
	//public int accountNum = CustomerDAO.getAccountNum(userName);
	public static int numberOfAccounts = 1;
	
	public Account() {
		
		accountNum = numberOfAccounts++;
		//accountNum = CustomerDAO.getAccountNum(userName);
		
		
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getAccountNumber() {
		CustomerDAO.getAccountNum(userName);
		return accountNum;
	}
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public void withdraw(double amount) {
		boolean valid = false;
		while (!valid) {
		try {
			balance -= amount;
			if (balance < 0) {
				balance += amount;
				System.out.println("you do not have enough funds");
				logger.info("user did not have enough funds");
				break;
		} else {
			System.out.println("you have withdrawn " + amount + " dollars");
			System.out.println("you now have a balance of " + balance);
			CustomerDAO customerDAO = new CustomerDAO();
			customerDAO.updateAccount(balance, accountNum);
			logger.info("user withdrew from their account");
			valid = true;
		}
		} catch (Exception e) {
		}
		}
	}
	public void deposit(double amount) {
		balance += amount;
		System.out.println("you have deposited " + amount + " dollars");
		System.out.println("you now have a balance of " + balance);
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.updateAccount(balance, accountNum);
	}
}
