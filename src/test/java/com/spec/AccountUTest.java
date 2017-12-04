package com.spec;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.bank.domain.Account;
import com.bank.domain.StatementItem;
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
		sAccount.deposit(null, aDepositOf100, null);
	}

	/**
	 * should_fail_when_there_is_no_amount
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void should_fail_when_there_is_no_amount() {
		final Account account = new Account();
		sAccount.deposit(account, null, null);
	}

	@Test
	public void should_return_statement_balance_100_when_i_deposit_100() {
		final BigDecimal aDepositOf100 = BigDecimal.valueOf(100.0);
		final Account account = new Account();
		final Account expectedAccount = sAccount.deposit(account, aDepositOf100, null);
		assertNotNull(expectedAccount);
		assertEquals(0, sAccount.getBalance(expectedAccount).compareTo(aDepositOf100));
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
		assertEquals(0, sAccount.getBalance(expectedAccount).compareTo(aDepositOf100));
	}

	/**
	 * should_return_statement_balance_50_when_i_deposit_100_and_i_withdraw_50.
	 *
	 */
	@Test
	public void should_return_statement_balance_50_when_i_deposit_100_and_i_withdraw_50() {
		final Account account = new Account();
		final BigDecimal aDepositOf100 = BigDecimal.valueOf(100.0);
		final BigDecimal aWithdrawOf50 = BigDecimal.valueOf(50.0);

		sAccount.deposit(account, aDepositOf100, null, LocalDateTime.now());
		sAccount.withdraw(account, aWithdrawOf50, null, LocalDateTime.now());
		assertEquals(0, (sAccount.getBalance(account).compareTo(BigDecimal.valueOf(50))));
	}

	/**
	 * should_return_statement_balance_minus_50_when_i_withdraw_50_and_200_as_overdraft.
	 *
	 */
	@Test
	public void should_return_statement_balance_minus_50_when_i_withdraw_50_and_200_as_overdraft() {
		final Account account = new Account();
		account.setOverdraft(BigDecimal.valueOf(200.0));
		final BigDecimal aWithdrawOf50 = BigDecimal.valueOf(50.0);
		sAccount.withdraw(account, aWithdrawOf50, null, LocalDateTime.now());
		assertEquals(0, (sAccount.getBalance(account).compareTo(BigDecimal.valueOf(-50))));
	}

	/**
	 * should_return_statement_items_size_2_and_balance_50_when_i_deposit_100_and_i_withdraw_50.
	 *
	 */
	@Test
	public void should_return_statement_items_size_2_and_balance_50_when_i_deposit_100_and_i_withdraw_50() {

		final Account account = new Account();
		final BigDecimal aDepositOf100 = BigDecimal.valueOf(100.0);
		final BigDecimal aWithdrawOf50 = BigDecimal.valueOf(50.0);

		sAccount.deposit(account, aDepositOf100, null, LocalDateTime.now());
		sAccount.withdraw(account, aWithdrawOf50, null, LocalDateTime.now());

		final List<StatementItem> statement = account.getStatements();
		assertEquals(0, (sAccount.getBalance(account).compareTo(BigDecimal.valueOf(50))));
		assertEquals(2, statement.size());
	}

	/**
	 * should_print_statement_with_2_items_with_balance_50_when_a_transaction_of_100_and_a_transaction_of_minus_50.
	 *
	 */
	@Test
	public void should_print_statement_with_2_items_with_balance_50_when_a_transaction_of_100_and_a_transaction_of_minus_50() {
		final Account account = new Account();
//		Transaction transactionDepsit_100 = new Transaction(BigDecimal.valueOf(100.0), null,
//				LocalDateTime.parse("2000-01-01T00:00:00.000", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
//				TransactionType.DEPOSIT);
//		account.addStatementItem(new StatementItem(transactionDepsit_100, BigDecimal.valueOf(100.0)));
//		Transaction transactionWithdraw_50 = new Transaction(BigDecimal.valueOf(50.0), null,
//				LocalDateTime.parse("2000-01-02T00:00:00.000", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
//				TransactionType.WITHDRAWAL);
//		account.addStatementItem(new StatementItem(transactionWithdraw_50, BigDecimal.valueOf(50.0)));

		//TODO Perhaps its better to mock deposit, withdraw ...
		sAccount.deposit(account, BigDecimal.valueOf(100.0),null, LocalDateTime.parse("2000-01-01T00:00:00.000", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		sAccount.withdraw(account, BigDecimal.valueOf(50.0), null,LocalDateTime.parse("2000-01-02T00:00:00.000", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		assertThat(account.getStatements().size()).isEqualTo(2);
		assertThat(account.getBalance()).isEqualTo(BigDecimal.valueOf(50.0));
		String str = sAccount.print(account);
		assertThat(str).isEqualTo("2000-01-01T00:00:00 DEPOSIT 100.0 100.0\n2000-01-02T00:00:00 WITHDRAWAL 50.0 50.0");
	}

	// /**
	// *
	// should_return_statement_balance_$1_when_i_did_transaction_with_amount_$2_$3_$4.
	// *
	// * @param expectedBalance
	// * @param amount1
	// * @param amount2
	// * @param amount3
	// */
	// @Test
	// @Parameters({ "50, 100, -30, -20", "40, 50, 0, -10", "0, 0, 0, 0", "30,
	// 10, 10, 10"
	//
	// })
	// public void
	// should_return_statement_balance_$1_when_i_did_transaction_with_amount_$2_$3_$4(
	// final double expectedBalance, final BigDecimal amount1, final BigDecimal
	// amount2, final BigDecimal amount3) {
	// final Account account = new Account();
	// if (amount1.compareTo(BigDecimal.ZERO)>0) {
	// sAccount.deposit(account, amount1, null, LocalDateTime.now());
	// } else {
	// sAccount.withdraw(account, amount1.negate(), null, LocalDateTime.now());
	// }
	// if (amount2.compareTo(BigDecimal.ZERO)>0) {
	// sAccount.deposit(account, amount2, null, LocalDateTime.now());
	// } else {
	// sAccount.withdraw(account, amount2.negate(), null, LocalDateTime.now());
	// }
	// if (amount3.compareTo(BigDecimal.ZERO)>0) {
	// sAccount.deposit(account, amount3, null, LocalDateTime.now());
	// } else {
	// sAccount.withdraw(account, amount3.negate(), null, LocalDateTime.now());
	// }
	// assertEquals(0,
	// (account.getBalance().compareTo(BigDecimal.valueOf(expectedBalance))));
	// }

}
