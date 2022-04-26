package MODEL;

public class Savings extends Account{
	private static String accountType = "Savings";

	Savings(double initialDeposit) {
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
