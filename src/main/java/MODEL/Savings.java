package MODEL;

public class Savings extends Account{
	private static String accountType = "Savings";

	Savings(double initialDeposit) {
		super();
		this.setBalance(initialDeposit);
	}

	public Savings(int accountNum, double balance) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\nAccountType: "+ accountType + " Account\n" +
				"AccountNumber: " +this.getAccountNumber() + "\n" +
				"Balance: " + this.getBalance() + "\n";
				
	}
}
