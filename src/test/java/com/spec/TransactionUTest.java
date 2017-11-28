package com.spec;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

import com.bank.dao.Transaction;
import com.bank.dao.TransactionType;

public class TransactionUTest {
	/**
     * should_return_transaction_amount_equals_1_and_date_now_and_operation_deposit_when_transaction_amount_equals_1_and_date_now.
     *
     */
    @Test
    public void should_return_transaction_amount_equals_1_and_date_now_and_operation_deposit_when_transaction_amount_equals_1_and_date_now() {
        final BigDecimal amount = BigDecimal.valueOf(1.0);
        final LocalDateTime date = LocalDateTime.now();
        final Transaction transaction = new Transaction(amount,null,date,TransactionType.DEPOSIT);
        assertThat(transaction.getAmount()).isEqualTo(amount);
        assertThat(transaction.getDate()).isEqualTo(date);
        assertThat(transaction.getOperation()).isEqualTo(TransactionType.DEPOSIT);
        assertThat(transaction.getOperation()).isNotEqualTo(TransactionType.WITHDRAWAL);
    }
    
    
    /**
     * should_return_transaction_amount_equals_minus_1_and_date_now_and_operation_withdrawal_when_transaction_amount_equals_minus_1_and_date_now.
     *
     */
    @Test
    public void should_return_transaction_amount_equals_minus_1_and_date_now_and_operation_withdrawal_when_transaction_amount_equals_minus_1_and_date_now() {
        final BigDecimal amount = BigDecimal.valueOf(1.0).negate();
        final LocalDateTime date = LocalDateTime.now();
        final Transaction transaction = new Transaction(amount,null,date,TransactionType.WITHDRAWAL);
        assertThat(transaction.getAmount()).isEqualTo(amount);
        assertThat(transaction.getDate()).isEqualTo(date);
        assertThat(transaction.getOperation()).isEqualTo(TransactionType.WITHDRAWAL);
        assertThat(transaction.getOperation()).isNotEqualTo(TransactionType.DEPOSIT);
    }
    
    
    /**
     * should_return_transaction_amount_equals_0_and_date_now_and_operation_deposit_when_transaction_amount_equals_0_and_date_now.
     *
     */
    @Test
    public void should_return_transaction_amount_equals_0_and_date_now_and_operation_deposit_when_transaction_amount_equals_0_and_date_now() {
        final BigDecimal amount = BigDecimal.valueOf(0.0).negate();
        final LocalDateTime date = LocalDateTime.now();
        final Transaction transaction = new Transaction(amount,null,date,TransactionType.DEPOSIT);
        assertThat(transaction.getAmount()).isEqualTo(amount);
        assertThat(transaction.getDate()).isEqualTo(date);
        assertThat(transaction.getOperation()).isEqualTo(TransactionType.DEPOSIT);
        assertThat(transaction.getOperation()).isNotEqualTo(TransactionType.WITHDRAWAL);
    }
    

}
