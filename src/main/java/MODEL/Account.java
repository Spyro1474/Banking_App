package MODEL;

import DAO.CustomerDAO;

public class Account {
	
	private Double balance;
	private int accountNum;
	private static int numberOfAccounts = 1;
	
	public Account() {
		accountNum = numberOfAccounts++;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getAccountNumber() {
		
		return accountNum;
	}
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("you have withdrawn " + amount + " dollars");
		System.out.println("you now have a balance of " + balance);
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.updateAccount(balance, accountNum);
	}
	public void deposit(double amount) {
		balance += amount;
		System.out.println("you have deposited " + amount + " dollars");
		System.out.println("you now have a balance of " + balance);
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.updateAccount(balance, accountNum);
	}
}
