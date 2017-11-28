package com.bank.dao;

import java.math.BigDecimal;

public class StatementItem {
	
	public final Transaction transaction;
	
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
