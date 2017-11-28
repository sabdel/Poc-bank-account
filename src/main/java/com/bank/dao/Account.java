package com.bank.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Account {

	public UUID Id;

	public List<StatementItem> statements = new ArrayList<>();

	public BigDecimal overdraft = BigDecimal.ZERO;
	
	public Account() {
		this.Id = UUID.randomUUID();
		
	}

	public UUID getId() {
		return Id;
	}

	
	public BigDecimal getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(BigDecimal overdraft) {
		this.overdraft = overdraft;
	}

	public List<StatementItem> getStatements() {
		return Collections.unmodifiableList(statements);
	}

	public void addStatementItem(final StatementItem statementItem) {
		this.statements.add(statementItem);
	}

	public BigDecimal getBalance() {
		return this.statements.isEmpty() ? BigDecimal.ZERO
				: this.statements.get(this.statements.size() - 1).getBalance();
	}

}
