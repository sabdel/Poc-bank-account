package com.spec.steps;

import java.math.BigDecimal;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class AccountOperationsStepDefs implements En{
	
	 public AccountOperationsStepDefs() {
		 
		 
		 
		   Given("^An existing client named \"([^\"]*)\" with (\\d+\\.\\d+) euros in his account$", (String arg1,BigDecimal arg2) -> {
			    // Write code here that turns the phrase above into concrete actions
			    throw new PendingException();
			});

			When("^he deposits (\\-?\\d+\\.\\d+)  into his account$", (BigDecimal arg2) -> {
			    // Write code here that turns the phrase above into concrete actions
			    throw new PendingException();
			});

			Then("^the new balance should be (\\d+\\.\\d+)$", (BigDecimal arg2) -> {
			    // Write code here that turns the phrase above into concrete actions
			    throw new PendingException();
			});

	 }



}
