package br.com.inmetrics.treinamento.runner;


import org.junit.runner.RunWith;

import br.com.inemtrics.treinamento.commons.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features/",
		glue = "br.com.inmetrics.treinamento.stepdefinitions",
		monochrome = true,
		plugin = {"pretty", "html:Reports/cucumber"}
		)
public class CucumberRunnerTest extends TestBase {
	
}