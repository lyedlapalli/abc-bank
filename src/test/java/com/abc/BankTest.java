package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankTest {
	private static final double DOUBLE_DELTA = 1e-15;

	@Test
	public void customerSummary() {
		Bank bank = new Bank();
		CheckingAccount checkingAccount = new CheckingAccount(Account.CHECKING, 0.0);
		Customer john = new Customer("John").openAccount(checkingAccount);
		bank.addCustomer(john);

		assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
	}

	@Test
	public void checkingAccount() {
		Bank bank = new Bank();
		CheckingAccount checkingAccount = new CheckingAccount(Account.CHECKING, 0.0);
		Customer bill = new Customer("Bill").openAccount(checkingAccount);
		bank.addCustomer(bill);

		checkingAccount.deposit(100.0);
		assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
		String customer = bank.getFirstCustomer();

		assertEquals(customer, "Bill");
	}

	@Test
	public void savings_account() {
		Bank bank = new Bank();
		SavingsAccount savingsAccount = new SavingsAccount(Account.SAVINGS, 0.0);
		bank.addCustomer(new Customer("Bill").openAccount(savingsAccount));
		savingsAccount.deposit(1500.0);
		assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
	}

	@Test
	public void maxi_savings_account() {
		Bank bank = new Bank();
		MaxiSavingsAccount maxSavingAccount = new MaxiSavingsAccount(Account.MAXI_SAVINGS, 100.00);
		bank.addCustomer(new Customer("Bill").openAccount(maxSavingAccount));

		maxSavingAccount.deposit(3000.0);

		assertEquals(180, bank.totalInterestPaid(), DOUBLE_DELTA);
	}

}
