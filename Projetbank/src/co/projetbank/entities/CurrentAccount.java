package co.projetbank.entities;

import java.util.Date;

public class CurrentAccount extends Account {
private double Overdraft ;

	
	public CurrentAccount(int idCust, double balance, Date dateCreation, double Overdraft) {
		super(idCust, balance, dateCreation);
		this.Overdraft = Overdraft ;
		
}

	@Override
	public String toString() {
		return "CurrentAccount [CurrentAccount=" +super.toString()+"Overdraft = "+ Overdraft + "]";
	}

	public double getOverdraft() {
		return Overdraft ;
	}
	public void setOverdraft(double Overdraft) {
		this.Overdraft = Overdraft ;	
				
}
}


