package com.spec.steps;

import java.math.BigDecimal;

import com.bank.dao.Account;
import com.bank.services.ServiceAccount;
import com.bank.services.ServiceAccountImpt;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class WithdrawFromAccountStepDefs implements En {

	private ServiceAccount serviceAccount = new ServiceAccountImpt();

	private Account account = new Account();

	public WithdrawFromAccountStepDefs() {

		When("^he withdraws (\\-?\\d+\\.\\d+)  from his account$", (BigDecimal amount) -> {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		});

		When("^has (\\d+)$", (BigDecimal overdraft) -> {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		});

		Then("^his new balance should be (\\-?\\d+\\.\\d+)$", (BigDecimal newBalance) -> {
		    // Write code here that turns the phrase above into concrete actions
		    throw new PendingException();
		});

	}

}
