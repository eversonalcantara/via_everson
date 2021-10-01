package br.com.everson.treinamento.runner;


import org.junit.runner.RunWith;

import br.com.everson.treinamento.commons.TestBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features/cenario.feature",
		glue = "br.com.everson.treinamento.stepdefinitions",
		monochrome = true)
public class CucumberRunnerTest extends TestBase {
	
}