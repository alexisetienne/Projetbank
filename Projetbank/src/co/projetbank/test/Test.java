package co.projetbank.test;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDaoCustomers.runTests();
		System.out.println("\n\n");
		
		TestDaoAccount.runTests();
		System.out.println("\n\n");

		TestDaoSavingAccount.runTests();
		System.out.println("\n\n");
		
		TestDaoCurrentAccount.runTests();
		System.out.println("\n\n");
		
		TestDaoSavingOperation.runTests();
		System.out.println("\n\n");
		
		TestDaoWithdrawal.runTests();
		System.out.println("\n\n");
		
		TestDaoPayment.runTests();
		System.out.println("\n\n");
		
	}

}


