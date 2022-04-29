package MODEL;

public class Account {
	
	public Double balance;
	public int accountNumber;
	public static int numberOfAccounts = 1;
	
	public Account() {
		accountNumber = numberOfAccounts++;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getAccountNumber() {
		
		return accountNumber;
	}
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("you have withdrawn " + amount + " dollars");
		System.out.println("you now have a balance of " + balance);
	}
	public void deposit(double amount) {
		balance += amount;
		System.out.println("you have deposited " + amount + " dollars");
		System.out.println("you now have a balance of " + balance);
	}
}
