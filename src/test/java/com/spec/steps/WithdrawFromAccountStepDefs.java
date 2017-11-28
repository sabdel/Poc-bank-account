package com.spec.steps;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import com.bank.dao.Account;
import com.bank.services.ServiceAccount;
import com.bank.services.ServiceAccountImpt;

import cucumber.api.java8.En;

public class WithdrawFromAccountStepDefs implements En {

	private ServiceAccount serviceAccount = new ServiceAccountImpt();

	private Account account = new Account();

	public WithdrawFromAccountStepDefs() {

		Given("^An existing client  \"([^\"]*)\" with (\\-?\\d+\\.\\d+) euros in his account and (\\-?\\d+\\.\\d+) as overdraft$",
				(String arg1, BigDecimal amount,BigDecimal overdraft) -> {
					serviceAccount.deposit(account, amount, null);
					account.setOverdraft(overdraft);
				});


		When("^he withdraws (\\-?\\d+\\.\\d+)  from his account$", (BigDecimal amount) -> {
			serviceAccount.withdraw(account, amount, null);
		});

		Then("^his new balance should be (\\-?\\d+\\.\\d+)$", (BigDecimal newBalance) -> {
			System.out.println(account.getBalance() + " "+ newBalance);
			assertEquals(0, account.getBalance().compareTo(newBalance));
		});

	}

}
