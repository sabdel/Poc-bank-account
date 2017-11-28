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
public class Account {

	/**
	 * the identifier
	 */
	public UUID Id;

	/**
	 * All statements
	 */
	public List<StatementItem> statements = new ArrayList<>();

	/**
	 * the overdraft
	 */
	public BigDecimal overdraft = BigDecimal.ZERO;
	
	public Account() {
		this.Id = UUID.randomUUID();
		
	}

	public UUID getId() {
		return Id;
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
		return this.statements.isEmpty() ? BigDecimal.ZERO
				: this.statements.get(this.statements.size() - 1).getBalance();
	}

}
