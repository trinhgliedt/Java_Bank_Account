import java.util.Random;
import java.text.NumberFormat;
//Create a BankAccount class.
public class BankAccount {
//The class should have the following attributes: (string) account number, (double) checking balance, (double) savings balance.
//Users should not be able to set any of the attributes from the class.
	private String accountNo ="";
	private double checkingBal;
	private double savingsBal;
	//Create a class member (static) that has the number of accounts created thus far.
	private static int noOfAccounts;
	//Create a class member (static) that tracks the total amount of money stored in every account created.
	private static double allAccountsBal;
	
	 //In the constructor, call the private method from above so that each user has a random ten digit account.
	public BankAccount() {
		this.createBankAccount();
		System.out.println("New account created! Account number: " + accountNo);
		//In the constructor, be sure to increment the account count.
		noOfAccounts++;
	}
	
	//Create a private method that returns a random ten digit account number.
	public String createBankAccount() {
		
		Random r = new Random();
		// run loop 10 times to create 10 digits
		for (int i=1; i<=10; i++) {
			// generate random number from 1 to 9. 
			accountNo += Integer.toString(r.nextInt(9));
		}
		return accountNo;
	}
	
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	//Create a getter method for the user's checking account balance.
	public String getChkgBal() {
		return formatter.format(checkingBal);
	}
	
	//Create a getter method for the user's saving account balance.
	public String getSvngsBal() {
		return formatter.format(savingsBal);
	}

	//Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
	public void makeDeposit(String typeOfAcct, double amount) {
		if (typeOfAcct == "C") {
			checkingBal += amount;
			allAccountsBal += amount;
			System.out.println(formatter.format(amount) + " has been deposited to your checking account!");
		}
		else if (typeOfAcct == "S") {
			savingsBal += amount;
			allAccountsBal += amount;
			System.out.println(formatter.format(amount) + " has been deposited to your savings account!");
		}
	}
	
	//Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
	public void makeWithdrawal(String typeOfAcct, double amount) {
		if (typeOfAcct == "C") {
			if (checkingBal >= amount) {
				checkingBal -= amount;
				allAccountsBal -= amount;
				System.out.println(formatter.format(amount) + " has been withdrawn from your checking account!");
			}
			else {System.out.println("Withdrawal unsuccessful due to non-sufficient fund in the checking account.");}
		}
		else if (typeOfAcct == "S") {
			if (savingsBal >= amount) {
				savingsBal -= amount;
				allAccountsBal -= amount;
				System.out.println(formatter.format(amount) + " has been withdrawn from your savings account!");
			}
			else {System.out.println("Withdrawal unsuccessful due to non-sufficient fund in the savings account.");}
		}
	}
	
	//Create a method to see the total money from the checking and saving.
	public static void viewAllAcctsTotalBal() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		System.out.println("Total balance for all accounts: " + formatter.format(allAccountsBal));
	}

	public void viewOneAcctTotalBal() {
		double totalCheckingSavings = checkingBal + savingsBal;
		System.out.println("Total checking and savings balance for this account: " + formatter.format(totalCheckingSavings));
	}
	
	public static int getNoOfAccts() {
		return noOfAccounts;
	}
}
