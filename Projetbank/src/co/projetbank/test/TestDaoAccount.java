package co.projetbank.test;

import co.projetbank.dao.AccountDao;

public class TestDaoAccount {
	public static void runTests() {
		java.util.Date date_util = new java.util.Date();
		java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

		AccountDao ad = new AccountDao();		
		
		Account a1 = new Account(date_sql,1000,6);
		
		if(ad.create(a1))	System.out.println("insertion ok de " + a1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		Account a2 = ad.find(a1.getIdCust()); 		
		if(a2 == null)	System.out.println("ce client n'est pas contenu en bdd ");
		else System.out.println("client trouvé en bdd : " + a2);
		
		a1.setBalance(2290);
		if(ad.update(a1)) System.out.println("mise à jour ok " + a1);
		else System.out.println("mise à jour impossible ");
		
		if(ad.delete(a1))	System.out.println("supréssion ok " + a1);
		else System.out.println("supréssion impossible ");				
	}
}


