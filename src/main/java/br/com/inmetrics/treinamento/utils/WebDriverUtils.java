package br.com.inmetrics.treinamento.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inmetrics.treinamento.SingletonInstancePage;

public class WebDriverUtils {

	private static WebDriver driver = SingletonInstancePage.getInstance().getChromeDriver();
	private static long timeout = 5;
	
	
	//-----------------------------------------------------------------------
	public static void aguardaElementoSumir(WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(elemento));
	}
	
	public static void aguardaElementoAparecer(WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(elemento));
	}
	//------------------------------------------------------------------------
	
	public static void aguardaElementoAparecerPorNome(String nome) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(nome)));
	}
	
	public static void aguardaElementoAparecerById(String id) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public static void aguardaElementoAparecerByXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
}
