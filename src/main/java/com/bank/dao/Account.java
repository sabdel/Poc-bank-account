package com.bank.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Account {

	public  UUID	 Id;
	
	public  List<StatementItem> statements;
	
	public BigDecimal balance;
	

	public Account(List<StatementItem> statements,BigDecimal balance) {
		this.Id = UUID.randomUUID();
		this.statements = statements;
		this.balance = balance;
		
	}

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	public List<StatementItem> getStatements() {
		return statements;
	}

	public void setStatements(List<StatementItem> statements) {
		this.statements = statements;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	
	
	
	
	
	
}
