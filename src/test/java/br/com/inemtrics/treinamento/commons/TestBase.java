package br.com.inemtrics.treinamento.commons;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import br.com.inmetrics.treinamento.SingletonInstancePage;

public class TestBase {

	private static WebDriver driver = null;
	
	@BeforeClass
	public static void inicializaChromeDriver() {
		SingletonInstancePage.getInstance().openBrowser();
		driver = SingletonInstancePage.getInstance().getChromeDriver();
		driver.navigate().to("http://www.correios.com.br/para-voce");
	}
	
	@AfterClass
	public static void closeDriver() {
		driver.close();
	}

}
