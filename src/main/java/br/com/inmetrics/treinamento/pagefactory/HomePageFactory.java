package br.com.inmetrics.treinamento.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.inmetrics.treinamento.SingletonInstancePage;

public class HomePageFactory extends BasePageFactory{

//	@FindBy(id = "portaltab-para-voce")
	@FindBy(id = "portaltab-para-voce")
	private WebElement ID_BUTTON_VOCE; 
	
	@FindBy(xpath = "//*[@id=\"content-principais-servicos\"]/ul/li[1]/a/img")
	private WebElement XPATH_BUTTON_BUSCA_CEP;
	public void goToHome() {
		SingletonInstancePage.getInstance().getChromeDriver().navigate().to("http://www.correios.com.br/para-voce");
	}

	/**
	 * Valida se os componentes de validação da tela estão presentes
	 * @return
	 * @throws Exception 
	 */
	public boolean isValida() throws Exception {
		return contemElemento(ID_BUTTON_VOCE);
	}
	
	public void clicarBuscaCEP() {
		clicar(XPATH_BUTTON_BUSCA_CEP);
	}

	
	
}
