package com.bank.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.function.Predicate;

import com.bank.domain.Account;
import com.bank.domain.StatementItem;

/**
 * This class contains all operations , Every implemantation should be ThreadSafe
 * @author SLA
 *
 */
public interface ServiceAccount {

	/**
	 * compute the balance of the account 
	 */
	
	BigDecimal getBalance(Account account);
	
	/**
	 * deposit an amount of money into an account 
	 * @param account
	 * @param amount
	 * @param currency
	 * @param date
	 * @return The account
	 */
	Account deposit(Account account,BigDecimal amount,Currency currency, LocalDateTime date);

	/**
	 * deposit an amount of money into an account now
	 * @param account
	 * @param amount
	 * @param currency
	 * @return account
	 */
	Account deposit(Account account,BigDecimal amount,Currency currency);

	/**
	 * withdraw money from account
	 * @param account
	 * @param amount
	 * @param currency
	 * @param date
	 * @return the account
	 */
	Account withdraw(Account account,BigDecimal amount,Currency currency, LocalDateTime date);

	/**
	 * withdraw money from account
	 * @param account
	 * @param amount
	 * @param currency
	 * @return the account
	 */
	Account withdraw(Account account,BigDecimal amount,Currency currency);
	
	/**
	 * Get and Print all operations, by dafalut {@link DateTimeFormatter.ISO_LOCAL_DATE_TIME} , No filter
	 * @param account
	 * @return
	 */
	String print(Account account);
	
	/**
	 * Get and Print all operations, no filter 
	 * @param account
	 * @return
	 */
	String print(Account account,DateTimeFormatter dateFormater);
	
	/**
	 * Get and Print all operations, by dafalut {@link DateTimeFormatter.ISO_LOCAL_DATE_TIME} 
	 * @param account
	 * @return
	 */
	String print(Account account,Predicate<StatementItem> predicate);


	/**
	 * Get and Print all operations, specify a date formater
	 * @param account
	 * @return
	 */
	String print(Account account,DateTimeFormatter dateFormater,Predicate<StatementItem> predicate);


}
