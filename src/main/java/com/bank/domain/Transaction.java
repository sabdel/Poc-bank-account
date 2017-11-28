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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (operation != other.operation)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", currency=" + currency + ", date=" + date + ", operation="
				+ operation + "]";
	}

	
}
