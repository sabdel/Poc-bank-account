package com.bank.dao;

import java.util.List;
import java.util.UUID;

public class Account {

	public  UUID	 Id;
	
	public  List<StatementItem> statements;

	public Account(List<StatementItem> statements) {
		this.Id = UUID.randomUUID();
		this.statements = statements;
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

	
	
	
	
	
}
