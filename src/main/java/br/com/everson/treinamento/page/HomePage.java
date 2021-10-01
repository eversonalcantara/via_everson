package br.com.everson.treinamento.page;

import br.com.everson.treinamento.SingletonInstancePage;

public class HomePage extends BasePage{
	private String XPATH_BTN_COMPRAR = "//*[@id=\"primary-menu\"]/li[2]/a";
	private String XPATH_ICONE_LOJA = "//*[@id=\"tbay-header\"]/div/div/div/div[1]/div/a/img";
	private String XPATH_LABEL_PRODUTOS = "//*[@id=\"content\"]/h1";

	public void goToHome() {
		SingletonInstancePage.getInstance().getChromeDriver().navigate().to("http://lojaebac.ebaconline.art.br/");
	}

	/**
	 * Valida se os componentes de validação da tela estão presentes
	 * @return
	 * @throws Exception 
	 */
	public boolean isValida() throws Exception {
		return contemElementoByXPath(XPATH_ICONE_LOJA);
	}
	
	/**
	 * Realiza ação de click em menu superior para Comprar
	 * @return 
	 * @throws Exception
	 */
	public TelaProdutos clicarTelaProdutos() throws Exception {
		clicarPorXPath(XPATH_BTN_COMPRAR);
		if (contemElementoByXPath(XPATH_LABEL_PRODUTOS)) {
			return new TelaProdutos();
		}
		return null;
	}
	
	
	
}
