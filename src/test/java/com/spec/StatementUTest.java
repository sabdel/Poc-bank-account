package com.spec;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bank.domain.Account;
import com.bank.domain.StatementItem;
import com.bank.domain.Transaction;
import com.bank.domain.TransactionType;
import com.bank.services.ServiceAccount;
import com.bank.services.ServiceAccountImpt;

@RunWith(MockitoJUnitRunner.class)

public class StatementUTest {

	private ServiceAccount sAccount = new ServiceAccountImpt() ;
	
	@Mock
	private Account account;

	@Before
	public void setUp() {
		// Mockito expectations
		List<StatementItem> items = new ArrayList<>();
		Transaction transactionDepsit_100 = new Transaction(BigDecimal.valueOf(100.0), null,
				LocalDateTime.parse("2017-01-01T00:00:00.000", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
				TransactionType.DEPOSIT);
		StatementItem depositOperation = new StatementItem(transactionDepsit_100, BigDecimal.valueOf(100.0));
		items.add(depositOperation);
		Transaction transactionWithdraw_50 = new Transaction(BigDecimal.valueOf(50.0), null,
				LocalDateTime.parse("2016-01-02T00:00:00.000", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
				TransactionType.WITHDRAWAL);
		StatementItem withdrawOperation = new StatementItem(transactionWithdraw_50, BigDecimal.valueOf(100.0));
		items.add(withdrawOperation);
		when(account.getStatements()).thenReturn(Collections.unmodifiableList(items));

	}

	@Test
	public void getOnlyCreditOperation(){
		
		String str = sAccount.print(account);
		assertThat(str)
		.isEqualTo("2017-01-01T00:00:00 DEPOSIT 100.0 100.0");

	}
	
	@Test
	public void getOnlyDebitOperation(){
		String str = sAccount.print(account);
		assertThat(str)
		.isEqualTo("2016-01-02T00:00:00 WITHDRAWAL 50.0 50.0");

	}
	
	@Test
	public void getAllOperationBeforeThisDate_2016_05_05(){
		String str = sAccount.print(account);
		assertThat(str)
		.isEqualTo("2016-01-02T00:00:00 WITHDRAWAL 50.0 50.0");
	
	}
	
	@Test
	public void getAllOperationAfterThisDate_2016_05_05(){
		String str = sAccount.print(account);
		assertThat(str)
		.isEqualTo("2017-01-01T00:00:00 DEPOSIT 100.0 100.0");

	}
	@Test
	public void getAllOperationOfThisDate_2016_05_05(){
		String str = sAccount.print(account);
		assertThat(str)
		.isEqualTo("");
	
	}


}
