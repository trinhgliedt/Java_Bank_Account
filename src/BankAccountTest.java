
public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acct1 = new BankAccount();
		
		acct1.makeDeposit("C", 500);
		acct1.makeDeposit("S", 1000);
		acct1.makeWithdrawal("C", 200);
		acct1.makeWithdrawal("S", 300);
//		System.out.print(acct1.getChkgBal());
//		System.out.print(acct1.getSvngsBal());
		acct1.viewOneAcctTotalBal();
		
		BankAccount acct2 = new BankAccount();
		acct2.makeDeposit("C", 300);
		acct2.makeDeposit("S", 200);
		acct2.viewOneAcctTotalBal();
		
		BankAccount.viewAllAcctsTotalBal();
		System.out.print("Total number of accounts: " + BankAccount.getNoOfAccts());
	}

}
