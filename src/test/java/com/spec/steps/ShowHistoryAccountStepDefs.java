package com.spec.steps;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import com.bank.domain.Account;
import com.bank.services.ServiceAccount;
import com.bank.services.ServiceAccountImpt;

import cucumber.api.java8.En;

public class ShowHistoryAccountStepDefs implements En {

	private ServiceAccount serviceAccount = new ServiceAccountImpt();

	private Account account = new Account();

	public ShowHistoryAccountStepDefs() {

		Given("^I deposit (\\-?\\d+\\.\\d+) euros$", (BigDecimal amount) -> {
			serviceAccount.deposit(account, amount, Currency.getInstance("EUR"), LocalDateTime.now());

		});

		Given("^I withdraw (\\-?\\d+\\.\\d+) euros$", (BigDecimal amount) -> {
			serviceAccount.withdraw(account, amount, null);
		});

		When("^I ask the statement$", () -> {
			serviceAccount.print(account);
		});

		Then("^sMy balance should be (\\-?\\d+\\.\\d+)$", (BigDecimal newBalance) -> {
			assertEquals(0, serviceAccount.getBalance(account).compareTo(newBalance));
		});

	}
}
