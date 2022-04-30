package MODEL;

import java.util.ArrayList;
import java.util.Scanner;
import DAO.CustomerDAO;
import DAO.DAOInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {
	Scanner scan = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit;
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
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
				logIn();
				break;
			case 3:
				makeADeposit();
				break;
			case 4:
				makeAwithdrawl();
				break;
			case 5:
				transferFunds();
				break;
			case 6:
				listBalances();
				break;
				default:
					System.out.println("Unkown Error");
		}
	}
	private void transferFunds() {
		int account1 = selectAccount();
		int account2 = selectAccount();
		if(account1 >= 0 || account2 >= 0) {
			System.out.println("how much would you like to transfer?");
			double amount = 0;
			try {
				amount = Double.parseDouble(scan.nextLine());
			}
			catch (NumberFormatException e) {
				amount = 0;
			}
			bank.getCustomer(account1).getAccount().withdraw(amount);
			bank.getCustomer(account2).getAccount().deposit(amount);
			logger.info("user transfered from their account");
		}
	}
	private void logIn() {
		int account = selectAccount();
		
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
		logger.info("user withdrew from their account");
		}
	}
	private void makeADeposit() {
		int account = selectAccount();
		if(account >=0) {
		System.out.println("How Much Would You Like To Deposit?");
		double amount = 0;
		try {
			amount = Double.parseDouble(scan.nextLine());
		}
		catch (NumberFormatException e) {
			amount = 0;
		}
		bank.getCustomer(account).getAccount().deposit(amount);
		logger.info("user deposited into their account");
		} 
	}
     
	private int selectAccount() {
		ArrayList<Customer> customers = bank.getCustomers();
		if(customers.size() <= 0) {
			System.out.println("No Customers At Your Bank");
			return -1;
		}
		System.out.println("Please Select The Account : ");
		for(int i = 0; i < customers.size(); i++) {
			System.out.println((i+1) + ")" + customers.get(i).basicInfo());
		}
		int account = 0;
		try {
			account = Integer.parseInt(scan.nextLine())-1;
		}
		catch (NumberFormatException e) {
			account = -1;
		}
		if(account > customers.size()) {
			System.out.println("Invalid Account Selected");
			account = -1;
		}
		return account;
	}
	private void createAnAccount() {
		String userName, passWord, phoneNum, accountType = "";
		double initialDeposit = 0;
		boolean employee = false;
		boolean valid = false;
		while(!valid) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Are You An Employee true/false");
			employee = scan.nextBoolean();
			if (employee == true) {
				System.out.println("you are an employee");
			} else {
				System.out.println("you are NOT an employee");
				} valid = true;
			}
			valid = false;
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
		System.out.println("Please Enter Username");
		userName = scan.nextLine();
		System.out.println("Please Enter Password");
		passWord = scan.nextLine();
		System.out.println("Please Enter Your Phone Number");
		phoneNum = scan.nextLine();
		valid = false;
		while(!valid) {
			System.out.println("Please Enter An Initial Deposit");
			try {
				initialDeposit = Double.parseDouble(scan.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Deposit must be a number");
			} CustomerDAO.createAnAccount(userName, passWord, phoneNum, accountType, employee, initialDeposit);
			
			if(accountType.equalsIgnoreCase("checking")) {
				if(initialDeposit <= 0) {
					System.out.println("Minimum $1 Deposit");
				} else {
					valid = true;
				}
			} else if(accountType.equalsIgnoreCase("savings")) {
				if(initialDeposit <= 0) {
					System.out.println("Minimum $1 Deposit");
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
		logger.info("user created an account");
	}
	private int getInput() {
		int choice = -1;
		do {
			System.out.println("\n" + "Enter Your Choice:");
		try {
			choice = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid Selection");
		}
		if(choice < 0 || choice > 6) {
			System.out.println("Choice Outside Of Range");
		}
	} while (choice < 0 || choice > 6);
		return choice; 
}
	private void printMenu() {
		System.out.println("Please Make A Selection: " + "\n");
		System.out.println("1. Create An Account: ");
		System.out.println("2. Log Into An Existing Account: ");
		System.out.println("3. Make A Deposit: ");
		System.out.println("4. Make A Withdrawl: ");
		System.out.println("5. Transfer Funds : ");
		System.out.println("6. List Accounts: ");
		System.out.println("0. Exit: ");
	}
	private void printHeader() {
		System.out.println("Welcome To My Bank" + "\n");
	}
}
