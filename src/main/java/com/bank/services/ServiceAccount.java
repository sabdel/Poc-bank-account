package com.bank.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import com.bank.dao.Account;
import com.bank.dao.StatementItem;

public interface ServiceAccount {

	StatementItem deposit(Account account,BigDecimal amount,Currency currency, LocalDate date);

	StatementItem deposit(Account account,BigDecimal amount,Currency currency);
}
