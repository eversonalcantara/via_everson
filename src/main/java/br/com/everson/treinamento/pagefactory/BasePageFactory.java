package br.com.everson.treinamento.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.everson.treinamento.utils.WebDriverUtils;

public class BasePageFactory {
	
	protected boolean contemElemento(WebElement elemento) throws Exception {
		WebDriverUtils.aguardaElementoAparecer(elemento);
		if (!elemento.equals(null)) {
			return true;
		}
		return false;
	}
	
	protected boolean isHabilitado(WebElement elemento) {
		WebDriverUtils.aguardaElementoAparecer(elemento);
		return elemento.isEnabled();
	}
	
	protected void clicar(WebElement elemento) {
		WebDriverUtils.aguardaElementoAparecer(elemento);
		elemento.click();
	}
	
	protected void preencherTexto(String texto, WebElement elemento) {
		elemento.clear();
		elemento.sendKeys(texto);
	}
	
	protected void selecionarElementoListBoxByName(WebElement elemento, String itemValue) {
		WebDriverUtils.aguardaElementoAparecer(elemento);
		new Select(elemento).selectByValue(itemValue);
	}
	
	protected boolean elementoContemTexto(WebElement elemento, String valor) {
		return elemento.getText().equals(valor);
	}
	
}