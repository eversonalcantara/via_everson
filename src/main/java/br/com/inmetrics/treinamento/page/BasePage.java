package br.com.inmetrics.treinamento.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.inmetrics.treinamento.SingletonInstancePage;
import br.com.inmetrics.treinamento.utils.WebDriverUtils;

public class BasePage {
	
	private static ChromeDriver driver = SingletonInstancePage.getInstance().getChromeDriver();
	
	protected boolean contemElementoByName(String nomeElemento) throws Exception {
		try {
			WebDriverUtils.aguardaElementoAparecerPorNome(nomeElemento);
			if (!(driver.findElementByName(nomeElemento)).equals(null)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("O elemento: " + nomeElemento + " não foi encontrado", e);
		}
		return false;
	}
	
	protected boolean contemElementoByXPath(String xpath) throws Exception {
		try {
			
			WebDriverUtils.aguardaElementoAparecerByXpath(xpath);
			if (!(driver.findElementByXPath(xpath)).equals(null)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("O elemento: " + xpath + " não foi encontrado", e);
		}
		return false;
	}
	
	protected boolean contemElementoById(String id) throws Exception {
		try {
			WebDriverUtils.aguardaElementoAparecerById(id);
			if (!(driver.findElementById(id)).equals(null)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("O elemento: " + id + " não foi encontrado", e);
		}
		return false;
	}
	
	
	protected boolean elementoContemTextoByXPath(String xpath, String texto) throws Exception {
		try {
			WebDriverUtils.aguardaElementoAparecerByXpath(xpath);
			WebElement elemento = driver.findElementByXPath(xpath);
			if (elemento.getText().equals(texto)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("O texto: " + texto + "não foi encontrado", e);
		}
		return false;
	}

	protected boolean isHabilitado(String name) {
		WebDriverUtils.aguardaElementoAparecerPorNome(name);
		WebElement elemento = driver.findElementByName(name);
		return elemento.isEnabled();
	}
	
	protected void clicarPorNome(String name) {
		WebDriverUtils.aguardaElementoAparecerPorNome(name);
		WebElement elemento = driver.findElementByName(name);
		elemento.click();
	}

	protected void clicarPorXPath(String xpath) {
		WebDriverUtils.aguardaElementoAparecerByXpath(xpath);
		WebElement elemento = driver.findElementByXPath(xpath);
		elemento.click();
	}
	
	protected void preencherTexto(String texto, WebElement elemento) {
		elemento.clear();
		elemento.sendKeys(texto);
	}
	
	protected void selecionarElementoListBoxByName(String name, String itemValue) {
		WebDriverUtils.aguardaElementoAparecerPorNome(name);
		WebElement element = driver.findElementByName(name);
		new Select(element).selectByValue(itemValue);
	}
	
}