package com.bank.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
/**
 * This is a representation of the bank account
 * @author SLA
 *
 */
public class Account extends BusinessObject{


	/**
	 * All statements
	 */
	private List<StatementItem> statements = new ArrayList<>();

	/**
	 * the overdraft
	 */
	private BigDecimal overdraft = BigDecimal.ZERO;
	
	
	/**
	 * the balance
	 */
	
	private BigDecimal balance = BigDecimal.ZERO; 
	
	
	public Account() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public UUID getId() {
		return id;
	}

	
	/**
	 * return the overDraft
	 * @return
	 */
	public BigDecimal getOverdraft() {
		return overdraft;
	}

	/**
	 * set the overdraft
	 * @param overdraft
	 */
	public void setOverdraft(BigDecimal overdraft) {
		this.overdraft = overdraft;
	}

	/**
	 * Get all statememnt item
	 * @return
	 */
	public List<StatementItem> getStatements() {
		return Collections.unmodifiableList(statements);
	}
	
	/**
	 * Add a statement , operation , to the cache
	 * @param statementItem
	 */

	public void addStatementItem(final StatementItem statementItem) {
		this.statements.add(statementItem);
	}

	/**
	 * Get the balance 
	 * @return
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
