package co.projetbank.test;

import co.projetbank.dao.*;
import co.projetbank.entities.Customer;
import co.projetbank.entities.SavingsAccount;

public class TestDaoSavingAccount {
	public static void runTests() {
		java.util.Date date_util = new java.util.Date();
		java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
		SavingsAccountDao sd = new SavingsAccountDao();
		Customer c3 = new Customer(1,"artur");
		
		SavingsAccount s1 = new SavingsAccount(10,1200,date_sql,10, c3);

		
		
	    //Teste insertion d'un découvert sur le CurrentAccount ?
		
		if(sd.create(s1))	System.out.println("insertion ok de " + s1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		SavingsAccount s2 = sd.find(s1.getIdCust()); 		
		if(s2 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + s2);
		
		s1.setBalance(2290);
		if(sd.update(s1)) System.out.println("ok mise à jour " + s1);
		else System.out.println("mise à jour impossible ");
		
		if(sd.delete(s1))	System.out.println("delete ok " + s1);
		else System.out.println("delete impossible ");	
		

}
}
