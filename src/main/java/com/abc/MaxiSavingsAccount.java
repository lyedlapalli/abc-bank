package com.abc;

import java.util.ArrayList;
import java.util.List;

public class MaxiSavingsAccount implements Account {

	public final int accountType;

	public List<Transaction> transactions;

	public double accountBalance;

	public MaxiSavingsAccount(int accountType, double accountBalance) {
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.transactions = new ArrayList<Transaction>();
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(amount,"CR"));
			accountBalance = accountBalance + amount;
		}
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			if(amount > accountBalance){
				throw new IllegalArgumentException("amount must be greater than zero");
			}else{
				transactions.add(new Transaction(amount,"DB"));
				accountBalance = accountBalance - amount;
			}
		}
	}

	public double interestEarned() {
		if (accountBalance <= 1000)
			return accountBalance * 0.02;
		if (accountBalance <= 2000)
			return 20 + (accountBalance-1000) * 0.05;
		return 70 + (accountBalance-2000) * 0.1;
	}
}