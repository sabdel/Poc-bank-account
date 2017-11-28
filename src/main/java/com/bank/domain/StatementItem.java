package com.bank.domain;

import java.math.BigDecimal;

/**
 * This is a representation of a commited operation stored in the cache
 *   
 * @author SLA
 *
 */
public class StatementItem {
	
	/**
	 * The transaction
	 */
	public final Transaction transaction;
	
	/**
	 * The balance just after transaction was commited
	 */
	public final BigDecimal balance;

	public StatementItem(Transaction transaction, BigDecimal balance) {
		super();
		this.transaction = transaction;
		this.balance = balance;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
	
	

}
