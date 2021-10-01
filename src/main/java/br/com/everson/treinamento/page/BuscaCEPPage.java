package br.com.inmetrics.treinamento.page;

import org.openqa.selenium.WebElement;

import br.com.inmetrics.treinamento.SingletonInstancePage;
import br.com.inmetrics.treinamento.enumerator.EnumTipoCEP;

public class BuscaCEPPage extends BasePage{

	private String campoCriterioBusca = "relaxation";
//	private String tituloBuscaCep = "Busca CEP";
	private String xpathElementoBotaoBuscar = "//*[@id=\"Geral\"]/div/div/div[6]/input";
	private String xpathElementoTituloBuscaCep = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/h3";
	private String xpathElementoTituloResultadoPesquisa = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/p";
	private String textoSucessoPesquisa = "DADOS ENCONTRADOS COM SUCESSO.";
	private String listBoxCEPDe_name = "tipoCEP";
	
	public boolean isValida() throws Exception {
		return contemElementoByXPath(xpathElementoTituloBuscaCep);
	}

	public void preencherCriterioBusca(String texto) {
		WebElement elemento = SingletonInstancePage.getInstance().getChromeDriver().findElementByName(campoCriterioBusca);
		preencherTexto(texto, elemento);
	}

	public void clicarBotaoBuscar() {
		clicarPorXPath(xpathElementoBotaoBuscar);
	}

	public boolean validaSucessoPesquisa() throws Exception {
		return elementoContemTextoByXPath(xpathElementoTituloResultadoPesquisa, textoSucessoPesquisa);
	}

	public void selecionarFiltro(String string) {
		selecionarElementoListBoxByName(listBoxCEPDe_name, EnumTipoCEP.TODOS.getValue());
	}
}
