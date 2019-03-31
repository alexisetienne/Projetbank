package co.projetbank.test;


import co.projetbank.dao.WithdrawalDao;
import co.projetbank.entities.*;

public class TestDaoWithdrawal {
	public static void runTests() {
		java.util.Date date_util = new java.util.Date();
		java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
		WithdrawalDao wd = new WithdrawalDao();		
		
		Withdrawal w1 = new Withdrawal(1,date_sql,3300);
		
		if(wd.create(w1))	System.out.println("insertion ok de " + w1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		Withdrawal w2 = wd.find(w1.getNumOp()); 		
		if(w2 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + w2);
		
		w1.setAmount(2100);
		if(wd.update(w1)) System.out.println("ok mise à jour " + w1);
		else System.out.println("mise à jour impossible ");
		
		if(wd.delete(w1))	System.out.println("delete ok " + w1);
		else System.out.println("delete impossible ");				
	}
	
}