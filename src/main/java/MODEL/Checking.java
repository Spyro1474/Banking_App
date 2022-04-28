package MODEL;

public class Checking extends Account{
	private static String accountType = "Checking";
	
	Checking(double initialDeposit) {
		super();
		this.setBalance(initialDeposit);
	}

	@Override
	public String toString() {
		return "AccountType: "+ accountType + "Account\n" +
				"AccountNumber: " +this.getAccountNumber() + "\n" +
				"Balance: " + this.getBalance() + "\n";
				
				
	}

}