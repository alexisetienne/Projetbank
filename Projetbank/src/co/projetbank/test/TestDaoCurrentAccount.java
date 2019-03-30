package co.projetbank.test;

import co.projetbank.dao.CurrentAccountDao;

public class TestDaoCurrentAccount {
	public static void runTests() {
		// teste pour la classe CurrentAccoun
		CurrentAccountDao cd = new CurrentAccountDao();
		
		CurrentAccount d1 = new CurrentAccount(1000);

		
		
	    //Teste insertion d'un découvert sur le CurrentAccount ?
		
	    if(cd.create(d1))	System.out.println("insertion ok de " + d1);
		else System.out.println("insertion impossible, ce découvert est déja créer en BDD ");
		
	    d1.setOverdraft(2000);
		if(cd.update(d1)) System.out.println("mise à jour ok " + d1);
		else System.out.println("mise à jour impossible ");
		
		if(cd.delete(d1))	System.out.println("supréssion ok " + d1);
		else System.out.println("supréssion impossible ");
		
}
}
