package com.bank.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import com.bank.domain.Account;

/**
 * This class contains all operations , Every implemantation should be ThreadSafe
 * @author SLA
 *
 */
public interface ServiceAccount {

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
	 * Get and Print all operations, no filter
	 * @param account
	 * @return
	 */
	String print(Account account);

}
