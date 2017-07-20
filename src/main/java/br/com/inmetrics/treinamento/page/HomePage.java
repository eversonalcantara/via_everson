package br.com.inmetrics.treinamento.page;

import br.com.inmetrics.treinamento.SingletonInstancePage;

public class HomePage extends BasePage{

	private String ID_BUTTON_VOCE = "portaltab-para-voce"; 
	private String XPATH_BUTTON_BUSCA_CEP = "//*[@id=\"content-principais-servicos\"]/ul/li[1]/a/img";
	
	public void goToHome() {
		SingletonInstancePage.getInstance().getChromeDriver().navigate().to("http://www.correios.com.br/para-voce");
	}

	/**
	 * Valida se os componentes de validação da tela estão presentes
	 * @return
	 * @throws Exception 
	 */
	public boolean isValida() throws Exception {
		return contemElementoById(ID_BUTTON_VOCE);
	}
	
	public void clicarBuscaCEP() {
		clicarPorXPath(XPATH_BUTTON_BUSCA_CEP);
	}

	
	
}
