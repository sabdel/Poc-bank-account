package com.bank.services;

import java.time.LocalDate;

import com.bank.dao.Account;
import com.bank.dao.StatementItem;

public interface ServiceAccount {

	StatementItem deposit(Account account,Double amount, LocalDate date);

	StatementItem deposit(Account account,Double amount);
}
