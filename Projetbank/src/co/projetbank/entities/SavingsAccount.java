package co.projetbank.entities;

import java.util.Date;

public class SavingsAccount extends Account {
	
	private double InterestRate ;
	
		
	
	public SavingsAccount(int idCust, double balance, Date dateCreation, double InterestRate) {
		super(idCust, balance, dateCreation);
		this.InterestRate = InterestRate ;
		
}
	@Override
	public String toString() {
		return "SavingsAccount ["+super.toString()+"interest rate :" + InterestRate + "]";
	}

	public double getInterestRate() {
		return InterestRate ;
	}
	public void setInterestRate(double InterestRate) {
		this.InterestRate = InterestRate ;	
				
}
}
