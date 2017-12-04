package com.bank.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bank.domain.Account;
import com.bank.domain.StatementItem;
import com.bank.domain.Transaction;
import com.bank.domain.TransactionType;
import com.google.common.base.Preconditions;

public class ServiceAccountImpt implements ServiceAccount {

	@Override
	public BigDecimal getBalance(Account account) {
		double credits = account.getStatements().stream()
				.filter(rec -> TransactionType.DEPOSIT.equals(rec.getTransaction().getOperation()))
				.mapToDouble(rec -> rec.getTransaction().getAmount().doubleValue()).sum();

		double debits = account.getStatements().stream()
				.filter(rec -> TransactionType.WITHDRAWAL.equals(rec.getTransaction().getOperation()))
				.mapToDouble(rec -> rec.getTransaction().getAmount().doubleValue()).sum();

		return BigDecimal.valueOf(credits - debits);
	}

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
		BigDecimal newBalance = account.getBalance().add(transaction.getAmount());

		account.setBalance(newBalance);
		StatementItem item = new StatementItem(transaction,newBalance );
		account.addStatementItem(item);
		return account;
	}

	@Override
	public Account deposit(Account account, BigDecimal amount, Currency currency) {
		return deposit(account, amount, currency, LocalDateTime.now());
	}

	@Override
	public Account withdraw(Account account, BigDecimal amount, Currency currency, LocalDateTime date) {
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
		Transaction transaction = new Transaction(amount, currency, date, TransactionType.WITHDRAWAL);
		// TODO Fix Currency !!!!
		BigDecimal newBalanceWithOverDraft = account.getOverdraft().add(account.getBalance()).subtract(amount);
		BigDecimal newBalance;
		if (newBalanceWithOverDraft.compareTo(BigDecimal.ZERO) < 0) {
			return account;
		} else {
			newBalance = newBalanceWithOverDraft.subtract(account.getOverdraft());
		}

		account.setBalance(newBalance);
		StatementItem item = new StatementItem(transaction, newBalance);
		account.addStatementItem(item);
		return account;
	}

	@Override
	public Account withdraw(Account account, BigDecimal amount, Currency currency) {
		return withdraw(account, amount, currency, LocalDateTime.now());
	}

	@Override
	public String print(Account account) {
		return print(account, DateTimeFormatter.ISO_LOCAL_DATE_TIME, BankAccountPredicates.alwaysTrue());
	}

	@Override
	public String print(Account account, DateTimeFormatter dateFormater) {
		return print(account, dateFormater, BankAccountPredicates.alwaysTrue());
	}

	@Override
	public String print(Account account, Predicate<StatementItem> predicate) {
		return print(account, DateTimeFormatter.ISO_LOCAL_DATE_TIME, predicate);
	}

	@Override
	public String print(Account account, DateTimeFormatter dateFormater, Predicate<StatementItem> predicate) {
		String history = BankAccountPredicates.filterStatements(account, predicate).stream()
				.map(s -> s.print(dateFormater)).collect(Collectors.joining("\n"));
		return history;
	}

}
