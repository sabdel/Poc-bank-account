package com.bank.domain;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;
/**
 * A bank account operation 
 * @author SLA
 *
 */
public class Transaction extends BusinessObject{

	/**
	 * The amount of money
	 */
	private final BigDecimal amount;
	/**
	 * The currency
	 */
	private Currency currency;
	/**
	 * The date
	 */
	private final LocalDateTime date;
	
	/**
	 * The operation type
	 */
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

	/**
	 * 
	 * @return
	 */
	public UUID getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", currency=" + currency + ", date=" + date + ", operation="
				+ operation + "]";
	}

	
}
