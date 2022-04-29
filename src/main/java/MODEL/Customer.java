package MODEL;

public class Customer {

	private String userName;
	private String passWord;
	private String phoneNum;
	private Account account;

	public Customer(String userName, String passWord, String phoneNum, Account account) {
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNum = phoneNum;
		this.account = account;
	}
	
	@Override
	public String toString() {
		return " Customer Information \n " +
				" Username: " + userName + "\n" +
				" Password: " + passWord + "\n" +
				" Phone Number: " + phoneNum + "\n" +
				account;
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
