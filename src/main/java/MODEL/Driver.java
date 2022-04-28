package MODEL;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.CustomerDAO;
import DAO.DAOInterface;

public class Driver {
	Scanner scan = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit;
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.runMenu();
		String username;
		String passcode;
		String accountType;
		boolean employee;
		DAOInterface customer = new CustomerDAO();

	}
	public void runMenu() {
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			preformAction(choice);
		}
	}
	private void preformAction(int choice) {
		switch(choice) {
			case 0:
				System.out.println("thank you for using our program");
				System.exit(0);
				break;
			case 1:
				createAnAccount();
				break;
			case 2:
				makeADeposit();
				break;
			case 3:
				makeAwithdrawl();
				break;
			case 4:
				listBalances();
				break;
				default:
					System.out.println("Unkown Error");
		}
	}
	private void listBalances() {
		int account = selectAccount();
		try {
		if(account >= 0) {
			System.out.println(bank.getCustomer(account).getAccount());
		}
		} catch (NumberFormatException e) {
			account = 0;
		}
	}
	private void makeAwithdrawl() {
		int account = selectAccount();
		if(account >=0) {
		System.out.println("how much would you like to withdraw?");
		double amount = 0;
		try {
			amount = Double.parseDouble(scan.nextLine());
		}
		catch (NumberFormatException e) {
			amount = 0;
		}
		bank.getCustomer(account).getAccount().withdraw(amount);
		}
	}
	private void makeADeposit() {
		int account = selectAccount();
		if(account >=0) {
		System.out.println("how much would you like to deposit?");
		double amount = 0;
		try {
			amount = Double.parseDouble(scan.nextLine());
		}
		catch (NumberFormatException e) {
			amount = 0;
		}
		bank.getCustomer(account).getAccount().deposit(amount);
		}
	}
	private int selectAccount() {
		ArrayList<Customer> customers = bank.getCustomers();
		if(customers.size() <= 0) {
			System.out.println("no customers at your bank");
			return -1;
		}
		System.out.println("Please Select The Account : ");
		for(int i = 0; i < customers.size(); i++) {
			System.out.println((i+1) + ") " + customers.get(i).basicInfo());
		}
		int account = 0;
		try {
			account = Integer.parseInt(scan.nextLine())-1;
		}
		catch (NumberFormatException e) {
			account = -1;
		}
		if(account > customers.size()) {
			System.out.println("invalid account selected");
			account = -1;
		}
		return account;
	}
	private void createAnAccount() {
		String userName, passWord, phoneNum, accountType = "", emplloyee;
		//CustomerDAO.createAnAccount(userName, passWord, phoneNum, accountType, employee);
		double initialDeposit = 0;
		boolean valid = false;
		while(!valid) {
			System.out.println("Please enter an Account Type(Checking/Savings");
			accountType = scan.nextLine();
			if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")) {
				valid = true;
			}
			else {
				System.out.println("INVALID INPUT Please enter an Account Type(Checking/Savings");
			}
		}
		System.out.println("Please enter Username");
		userName = scan.nextLine();
		System.out.println("Please enter Password");
		passWord = scan.nextLine();
		System.out.println("Please enter Your Phone Number");
		phoneNum = scan.nextLine();
		valid = false;
		while(!valid) {
			System.out.println("Please enter an initial deposit");
			try {
				initialDeposit = Double.parseDouble(scan.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Deposit must be a number");
			}
			if(accountType.equalsIgnoreCase("checking")) {
				if(initialDeposit <= 1) {
					System.out.println("minimum $1 deposit");
				} else {
					valid = true;
				}
			} else if(accountType.equalsIgnoreCase("savings")) {
				if(initialDeposit <= 1) {
					System.out.println("Minimum $1 deposit");
				} else {
					valid = true;
				}
			}
		}
		Account account;
		if(accountType.equalsIgnoreCase("checking")) {
			account = new Checking(initialDeposit);
			
		} else {
			account = new Savings(initialDeposit);
		}
		Customer customer = new Customer(userName, passWord, phoneNum, account);
		bank.addCustomer(customer);
	}
	private int getInput() {
		int choice = -1;
		do {
			System.out.println("Enter Your Choice:");
		try {
			choice = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("invalid selection");
		}
		if(choice < 0 || choice > 4) {
			System.out.println("choice outside of range");
		}
	} while (choice < 0 || choice > 4);
		return choice; 
}
	private void printMenu() {
		System.out.println("Please make a selection");
		System.out.println("1. Create an Account");
		System.out.println("2. Make a deposit");
		System.out.println("3. Make a Withdrawl");
		System.out.println("4. list account balance");
		System.out.println("0. Exit");
	}
	private void printHeader() {
		System.out.println("Welcome to my bank");
	}
}
