package com.bank.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import com.bank.dao.Account;
import com.bank.dao.StatementItem;
import com.bank.dao.Transaction;
import com.bank.dao.TransactionType;
import com.google.common.base.Preconditions;

public class ServiceAccountImpt implements ServiceAccount {

	@Override
	public Account deposit(Account account, BigDecimal amount, Currency currency, LocalDateTime date) {
		// TODO Wait for Logger or/and Notification System
		try {
			Preconditions.checkNotNull(account);
			Preconditions.checkNotNull(amount);
			Preconditions.checkNotNull(date);
		} catch (NullPointerException e) {
			throw new IllegalArgumentException(e);
		}

		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			return account;
		}
		Transaction transaction = new Transaction(amount, currency, date, TransactionType.DEPOSIT);
		// TODO Fix Currency !!!!
		StatementItem item = new StatementItem(transaction, account.getBalance().add(transaction.getAmount()));
		account.addStatementItem(item);
		return account;
	}

	@Override
	public Account deposit(Account account, BigDecimal amount, Currency currency) {
		return deposit(account, amount, currency, LocalDateTime.now());
	}

}
