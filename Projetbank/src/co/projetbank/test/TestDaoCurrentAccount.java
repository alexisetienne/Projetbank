package co.projetbank.test;

import co.projetbank.dao.*;
import co.projetbank.entities.CurrentAccount;


public class TestDaoCurrentAccount {
	public static void runTests() {
		// teste pour la classe CurrentAccoun
		java.util.Date date_util = new java.util.Date();
		java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
		CurrentAccountDao cd = new CurrentAccountDao();
		
		CurrentAccount d1 = new CurrentAccount(10,1200,date_sql,10);

		
		
	    //Teste insertion d'un découvert sur le CurrentAccount ?
		
		if(cd.create(d1))	System.out.println("insertion ok de " + d1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		CurrentAccount d2 = cd.find(d1.getIdCust()); 		
		if(d2 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + d2);
		
		d1.setBalance(2290);
		if(cd.update(d1)) System.out.println("ok mise à jour " + d1);
		else System.out.println("mise à jour impossible ");
		
		if(cd.delete(d1))	System.out.println("delete ok " + d1);
		else System.out.println("delete impossible ");	
		
}
}
