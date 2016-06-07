package com.abc;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
	Customer oscar = null;
	Customer bill = null;
	Customer scott = null;

	@Before
	public void setUp(){
		oscar = new Customer("Oscar").openAccount(new CheckingAccount(Account.CHECKING, 100.00));

		bill = new Customer("Bill").openAccount(new CheckingAccount(Account.CHECKING, 100.00));
		bill.openAccount(new SavingsAccount(Account.SAVINGS, 200.00));

		scott = new Customer("Scott").openAccount(new CheckingAccount(Account.CHECKING, 100.00));
		scott.openAccount(new SavingsAccount(Account.SAVINGS, 200.00));
		scott.openAccount(new MaxiSavingsAccount(Account.MAXI_SAVINGS, 300.00));
	}

	@Test
	public void testOneAccount(){
		assertEquals(1, oscar.getNumberOfAccounts());
	}

	@Test
	public void testTwoAccount(){
		assertEquals(2, bill.getNumberOfAccounts());
	}

	@Ignore
	public void testThreeAcounts() {
		assertEquals(3, scott.getNumberOfAccounts());
	}

	@After
	public void tearDown(){
		oscar = null;
		bill = null;
		scott = null;
	}

}
