package com.bank.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

public class Transaction {

	
	private final BigDecimal amount;
	private Currency currency;
	private final LocalDateTime date;
	private final TransactionType operation;
	
	
	public Transaction(BigDecimal amount, Currency currency, LocalDateTime date, TransactionType operation) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.date = date;
		this.operation = operation;
	}


	public Currency getCurrency() {
		return currency;
	}


	public void setCurrency(Currency currency) {
		this.currency = currency;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public TransactionType getOperation() {
		return operation;
	}

	
}
