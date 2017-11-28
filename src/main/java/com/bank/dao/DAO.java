package com.bank.dao;

import java.io.Serializable;

import com.bank.domain.BusinessObject;
/**
 * Basic operations for persistence layer ....
 * @author SLA
 *
 * @param <T>
 */
public interface DAO<T extends BusinessObject>{

	/**
	 * Persist the object
	 * 
	 * @param object
	 * @throws DAOException
	 */
	 T  save(T object);
	
	
	/**
	 * remove the object
	 * 
	 * @param object
	 * @throws DAOException
	 */
	 void delete(T object);
	
	
	
	/**
	 * return the object with the specified id
	 * @param <X>
	 * @param type
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	 <X extends T> X getById(Class<X> type, Serializable id);
	
}
