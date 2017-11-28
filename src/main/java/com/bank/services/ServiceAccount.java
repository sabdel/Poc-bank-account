package com.bank.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import com.bank.dao.Account;

/**
 * This class contains all operations , Every implemantation should be ThreadSafe
 * @author SLA
 *
 */
public interface ServiceAccount {

	
	Account deposit(Account account,BigDecimal amount,Currency currency, LocalDateTime date);

	Account deposit(Account account,BigDecimal amount,Currency currency);
}
