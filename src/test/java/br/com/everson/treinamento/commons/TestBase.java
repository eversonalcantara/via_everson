package br.com.everson.treinamento.commons;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.everson.treinamento.SingletonInstancePage;

public class TestBase {

	static WebDriver driver = SingletonInstancePage.getInstance().newInstanceBrowser();

	@BeforeClass
	public static void inicializaChromeDriver() {
		driver = SingletonInstancePage.getInstance().getChromeDriver();
	}
	
	@AfterClass
	public static void closeDriver() {
//		SingletonInstancePage.getInstance().getChromeDriver().close();
	}
	
	@io.qameta.allure.Attachment(value = "Evidência {0}", type = "image/png")
	public byte[] printEvidencia(String nomeEvidencia) throws FileNotFoundException, IOException {
        byte[] bytes = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        return bytes;
	}

}
