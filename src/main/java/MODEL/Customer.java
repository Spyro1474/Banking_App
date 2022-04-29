package MODEL;

public class Customer {

	public String userName;
	public String passWord;
	public String phoneNum;
	public double balance;
	public String accountType;
	public int accountNum;
	public Account account;

	public Customer(String userName, String passWord, String phoneNum, double balance, String accountType, int accountNum, Account account) {
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNum = phoneNum;
		this.balance = balance;
		this.accountType = accountType;
		this.accountNum = accountNum;
		this.account = account;
	}
	
	
	
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", passWord=" + passWord + ", phoneNum=" + phoneNum + ", balance="
				+ balance + ", accountType=" + accountType + ", accountNum=" + accountNum + ", account=" + account
				+ "]";
	}



	Account getAccount() {
		return account;
	}
	
	public String basicInfo() {
		return 	" Username: " + userName + "\n" +
				" Password: " + passWord + "\n" +
				" Phone Number: " + phoneNum + "\n" +
				" Account Number: " + account.getAccountNumber();
	}
}
