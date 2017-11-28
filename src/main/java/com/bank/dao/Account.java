package com.bank.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Account {

	public UUID Id;

	public List<StatementItem> statements = new ArrayList<>();

	public Account(List<StatementItem> statements) {
		this.Id = UUID.randomUUID();
		this.statements = statements;
	}

	public UUID getId() {
		return Id;
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
