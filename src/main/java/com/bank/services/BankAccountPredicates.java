package com.bank.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bank.domain.Account;
import com.bank.domain.StatementItem;
import com.bank.domain.TransactionType;

/**
 * Some usefull predicates 
 * @author SLA
 *
 */
public class BankAccountPredicates {
	/**
	 * True when we its a deposit into account operation or false if not
	 * @return
	 */
	public static Predicate<StatementItem> isCreditOperation() {
		return statement -> TransactionType.DEPOSIT.equals(statement.getTransaction().getOperation());
	}

	/**
	 * True when we its a withdraw into account operation or false if not
	 * @return
	 */

	public static Predicate<StatementItem> isDebitOperation() {
		return statement -> TransactionType.WITHDRAWAL.equals(statement.getTransaction().getOperation());
	}

	/**
	 * True when if the operation happen after this date , false if not
	 * @return
	 */

	public static Predicate<StatementItem> isOperationAfter(LocalDateTime date) {
		return statement -> statement.getTransaction().getDate().isAfter(date);
	}

	/**
	 * True when if the operation happen before this date , false if not
	 * @return
	 */
	public static Predicate<StatementItem> isOperationBefore(LocalDateTime date) {
		return statement -> statement.getTransaction().getDate().isBefore(date);
	}

	/**
	 * True when if the operation happen  this "date" , false if not
	 * @return
	 */
	public static Predicate<StatementItem> isOperationThisDay(LocalDateTime date) {
		return statement -> statement.getTransaction().getDate().isEqual(date);
	}

	/**
	 * No Filter
	 * @param account
	 * @param predicate
	 * @return
	 */
	public static Predicate<StatementItem> alwaysTrue(){
		return statement -> Boolean.TRUE;
	}
	public static List<StatementItem> filterStatements(Account account, java.util.function.Predicate<StatementItem> predicate) {
		return account.getStatements().stream().filter(predicate).collect(Collectors.<StatementItem>toList());
	}

}
