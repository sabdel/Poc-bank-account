package com.spec.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.bank.domain.Account;
import com.bank.services.ServiceAccount;
import com.bank.services.ServiceAccountImpt;

import cucumber.api.DataTable;
import cucumber.api.Transformer;
import cucumber.api.java8.En;

public class ShowHistoryAccountStepDefs implements En {

	private ServiceAccount serviceAccount = new ServiceAccountImpt();

	private Account account = new Account();

	private String history = "";

	public ShowHistoryAccountStepDefs() {

		// Given("^I deposit (\\d+) euros (.*) $", (BigDecimal
		// amount,@Transform(ISO_LOCAL_DATE_TIMETimeConverter.class)
		// LocalDateTime d) -> {
		// serviceAccount.deposit(account, amount, Currency.getInstance("EUR"),
		// d);
		//
		// });
		//
		// Given("^I withdraw (\\d+) euros (.*) $", (BigDecimal
		// amount,@Transform(ISO_LOCAL_DATE_TIMETimeConverter.class)
		// LocalDateTime d) -> {
		// serviceAccount.withdraw(account, amount, null,d);
		// });

		// Given("^I deposit (\\d+) euros \"([^\"]*)\"$", (BigDecimal amount,
		// @Format("yyyy-MM-dd'T'HH:mm:ss") LocalDateTime d) -> {
		// serviceAccount.deposit(account, amount, Currency.getInstance("EUR"),
		// d);
		// });
		//
		// Given("^I withdraw (\\d+) euros \"([^\"]*)\"$", (BigDecimal amount,
		// @Format("yyyy-MM-dd'T'HH:mm:ss") LocalDateTime d) -> {
		// serviceAccount.withdraw(account, amount, null,d);
		//
		// });

		Given("^I deposit (\\d+) euros  \"([^\"]*)\"$", (BigDecimal amount, String date) -> {
			serviceAccount.deposit(account, amount, Currency.getInstance("EUR"),
					LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		});

		Given("^I withdraw (\\d+) euros  \"([^\"]*)\"$", (BigDecimal amount, String date) -> {
			serviceAccount.withdraw(account, amount, null,
					LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME));

		});

		When("^I ask the statement$", () -> {
			history = serviceAccount.print(account);
		});

		Then("^history  should be$", (DataTable expectedStatementItems) -> {

			String expectedHistory = expectedStatementItems.raw().stream()
					.map(new Function<List<String>, String>() {
						@Override
						public String apply(List<String> statementItem) {
							return statementItem.stream().map(s -> s.toString()).collect(Collectors.joining(" "));
						}
					}).collect(Collectors.joining("\n"));

			assertThat(history).isEqualTo(expectedHistory);

		});

	}

	public static class ISO_LOCAL_DATE_TIMETimeConverter extends Transformer<LocalDateTime> {

		@Override
		public LocalDateTime transform(String value) {
			return LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		}
	}

}
