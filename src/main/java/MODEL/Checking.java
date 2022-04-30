package MODEL;

import DAO.AccountDAO;

public class Checking extends Account{
	private static String accountType = "Checking";
	
	Checking(double initialDeposit) {
		super();
		this.setBalance(initialDeposit);
	}

	public Checking(int accountNum, double balance) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\nAccountType: "+ accountType + " Account\n" +
				"AccountNumber: " +this.getAccountNumber() + "\n" +
				"Balance: " + this.getBalance() + "\n";
				
				
	}

}
