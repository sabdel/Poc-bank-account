package com.bank.dao;

import java.io.Serializable;

import com.bank.domain.BusinessObject;

public  class AbstractDAO<T extends BusinessObject> implements DAO<T> {

	// JPA Entity Manager 
	
	@Override
	public T save(T object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X extends T> X getById(Class<X> type, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	

}
