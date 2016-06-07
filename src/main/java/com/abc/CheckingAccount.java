package com.abc;

import java.util.ArrayList;
import java.util.List;

public class CheckingAccount implements Account{

	public final int accountType;

	public List<Transaction> transactions;

	public double accountBalance;

	public CheckingAccount(int accountType, double accountBalance) {
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
		return accountBalance * 0.001;
	}
}
