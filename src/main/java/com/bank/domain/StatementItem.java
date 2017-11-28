package com.bank.domain;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * This is a representation of a commited operation stored in the cache
 *   
 * @author SLA
 *
 */
public class StatementItem extends BusinessObject{
	
	
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

	/**
	 * 
	 * @return
	 */
	public UUID getId() {
		return id;
	}

	public String print(DateTimeFormatter dateFormater){
		final StringBuilder joiner = new StringBuilder("");
		joiner.append(this.getTransaction().getDate().format(dateFormater)).append(" ");
		joiner.append(this.getTransaction().getOperation().name()).append(" ");
		joiner.append(this.getTransaction().getAmount().toPlainString()).append(" ");
		joiner.append(this.getBalance().toPlainString());
		return joiner.toString();
	}
	
	@Override
	public String toString() {
		return "StatementItem [transaction=" + transaction + ", balance=" + balance + "]";
	}


}
