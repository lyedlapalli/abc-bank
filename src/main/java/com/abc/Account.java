package com.abc;

public interface Account {
	
	public final static int CHECKING = 0;

	public final static int SAVINGS = 1;

	public final static int MAXI_SAVINGS = 2;
	
	public void deposit(double amount);
	
	public void withdraw(double amount);
	
	public double interestEarned();
}
