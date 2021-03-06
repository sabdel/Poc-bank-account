package com.spec.steps;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import com.bank.domain.Account;
import com.bank.services.ServiceAccount;
import com.bank.services.ServiceAccountImpt;

import cucumber.api.java8.En;

public class DepositIntoAccountStepDefs implements En {

	private ServiceAccount serviceAccount = new ServiceAccountImpt();

	private Account account = new Account();

	public DepositIntoAccountStepDefs() {

		Given("^An existing client named \"([^\"]*)\" with (\\d+\\.\\d+) euros in his account$",
				(String arg1, BigDecimal balance) -> {
					// Nothing
				});

		When("^he deposits (\\-?\\d+\\.\\d+)  into his account$", (BigDecimal amount) -> {
			serviceAccount.deposit(account, amount, Currency.getInstance("EUR"), LocalDateTime.now());
		});

		Then("^the new balance should be (\\d+\\.\\d+)$", (BigDecimal newBalance) -> {
			assertEquals(0, serviceAccount.getBalance(account).compareTo(newBalance));
		});

	}

}
