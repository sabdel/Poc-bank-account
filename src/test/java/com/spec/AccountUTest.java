package com.spec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.bank.dao.Account;
import com.bank.services.ServiceAccount;
import com.bank.services.ServiceAccountImpt;

@RunWith(JUnit4.class)
public class AccountUTest {
	


	private ServiceAccount sAccount = new ServiceAccountImpt();

	/**
	 * should_fail_when_there_is_no_account
	 *
	 */

	@Test(expected = IllegalArgumentException.class)
	public void should_fail_when_there_is_no_Account() {
		final BigDecimal aDepositOf100 = BigDecimal.valueOf(100.0);
		final Account expectedAccount = sAccount.deposit(null, aDepositOf100, null);
	}
 
	/**
	 * should_fail_when_there_is_no_amount
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void should_fail_when_there_is_no_amount() {
		final Account account = new Account();
		final Account expectedAccount = sAccount.deposit(account, null, null);
	}
	@Test
	public void should_return_statement_balance_100_when_i_deposit_100() {
		final BigDecimal aDepositOf100 = BigDecimal.valueOf(100.0);
		final Account account = new Account();
		final Account expectedAccount = sAccount.deposit(account, aDepositOf100, null);
		assertNotNull(expectedAccount);
		assertEquals(0, expectedAccount.getBalance().compareTo(aDepositOf100));
	}

	/**
	 * should_return_statement_balance_100_when_i_deposit_100.
	 *
	 */
	@Test
	public void should_return_statement_balance_100_when_i_deposit_100_today() {
		final BigDecimal aDepositOf100 = BigDecimal.valueOf(100.0);
		final Account account = new Account();
		final Account expectedAccount = sAccount.deposit(account, aDepositOf100, null, LocalDateTime.now());
		assertNotNull(expectedAccount);
		assertEquals(0, expectedAccount.getBalance().compareTo(aDepositOf100));
	}
}
