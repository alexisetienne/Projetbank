package co.projetbank.test;

import co.projetbank.dao.PaymentDao;
import co.projetbank.entities.*;

public class TestDaoPayment {
	
		public static void runTests() {
			java.util.Date date_util = new java.util.Date();
			java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
			PaymentDao pd = new PaymentDao();		
			
			Payment p1 = new Payment(1,date_sql,3300);
			
			if(pd.create(p1))	System.out.println("insertion ok de " + p1);
			else System.out.println("insertion impossible, client avec cet id existe déjà ");
					
			Payment p2 = pd.find(p1.getNumOp()); 		
			if(p2 == null)	System.out.println("ce client n'est pas contenu en base ");
			else System.out.println("client trouvé en base : " + p2);
			
			p1.setAmount(2100);
			if(pd.update(p1)) System.out.println("ok mise à jour " + p1);
			else System.out.println("mise à jour impossible ");
			
			if(pd.delete(p1))	System.out.println("delete ok " + p1);
			else System.out.println("delete impossible ");				
		}
		
}

