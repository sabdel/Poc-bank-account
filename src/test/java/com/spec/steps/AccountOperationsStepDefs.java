package com.spec.steps;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;

import com.bank.dao.Account;
import com.bank.services.ServiceAccount;

import cucumber.api.java8.En;

public class AccountOperationsStepDefs implements En{
	
	 private ServiceAccount serviceAccount; 
	
	 private Account account = new Account(new ArrayList<>(),BigDecimal.valueOf(0));;

	public AccountOperationsStepDefs() {
		 
		   Given("^An existing client named \"([^\"]*)\" with (\\d+\\.\\d+) euros in his account$", (String arg1,BigDecimal balance) -> {
			   account.setBalance(balance);		
			   
		   });

			When("^he deposits (\\-?\\d+\\.\\d+)  into his account$", (BigDecimal amount) -> {
				serviceAccount.deposit(account, amount,Currency.getInstance("EUR"), LocalDate.now());
			});

			Then("^the new balance should be (\\d+\\.\\d+)$", (BigDecimal newBalance) -> {
              assertEquals(true,account.getBalance().compareTo(newBalance) );
			});

	 }



}
