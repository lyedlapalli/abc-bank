package com.abc;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Account> accounts;

	public Customer(String name) {
		System.out.println("Ading customer...");
		this.name = name;
		this.accounts = new ArrayList<Account>();
	}

	public String getName() {
		return name;
	}

	public Customer openAccount(Account account) {
		accounts.add(account);
		return this;
	}

	public int getNumberOfAccounts() {
		return accounts.size();
	}

	public double totalInterestEarned() {
		double total = 0;
		for (Account a : accounts)
			total += a.interestEarned();
		return total;
	}

	public String getStatement() {
		String statement = null;
		statement = "Statement for " + name + "\n";
		double total = 0.0;
		for (Account a : accounts) {
			statement += "\n" + statementForAccount(a) + "\n";
			total += getAccountBalance(a);
		}
		statement += "\nTotal In All Accounts " + toDollars(total);
		return statement;
	}

	private String statementForAccount(Account a) {
		String s = "";

		if(a instanceof CheckingAccount){
			s += "Checking Account\n";
			s = "Total " + toDollars(((CheckingAccount) a).accountBalance);
			return s;
		}else if(a instanceof SavingsAccount){
			s += "Savings Account\n";
			s = "Total " + toDollars(((SavingsAccount) a).accountBalance);
			return s;
		}else{
			s += "Maxi Savings Account\n";
			s = "Total " + toDollars(((MaxiSavingsAccount) a).accountBalance);
			return s;
		}

	}

	private double getAccountBalance(Account a) {
		if(a instanceof CheckingAccount){
			return ((CheckingAccount) a).accountBalance;
		}else if(a instanceof SavingsAccount){
			return ((SavingsAccount) a).accountBalance;
		}else{
			return ((MaxiSavingsAccount) a).accountBalance;
		}
	}

	private String toDollars(double d){
		return String.format("$%,.2f", abs(d));
	}
}
