package com.bank.domain;

import java.util.UUID;

public abstract class BusinessObject {
	/**
	 * the identifier
	 */
	protected UUID id;

	public BusinessObject() {
		super();
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	
}

