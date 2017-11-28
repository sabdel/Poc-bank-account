package com.spec.steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/spec/features/account_operations.feature")
public class CucumberIntegrationTest {

}
