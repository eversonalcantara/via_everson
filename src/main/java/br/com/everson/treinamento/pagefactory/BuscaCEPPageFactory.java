package br.com.everson.treinamento.pagefactory ;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.everson.treinamento.enumerator.EnumTipoCEP;

public class BuscaCEPPageFactory extends BasePageFactory{

	private String textoSucessoPesquisa = "DADOS ENCONTRADOS COM SUCESSO.";

	@FindBy(name = "relaxation")
	private WebElement campoCriterioBusca;
	
	@FindBy(xpath = "//*[@id=\"Geral\"]/div/div/div[6]/input")
	private WebElement xpathElementoBotaoBuscar;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/h3")
	private WebElement xpathElementoTituloBuscaCep;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/p")
	private WebElement xpathElementoTituloResultadoPesquisa;
	
	@FindBy(name = "tipoCEP")
	private WebElement listBoxCEPDe_name;
	
	public boolean isValida() throws Exception {
		return contemElemento(xpathElementoTituloBuscaCep);
	}

	public void preencherCriterioBusca(String texto) {
		preencherTexto(texto, campoCriterioBusca);
	}

	public void clicarBotaoBuscar() {
		clicar(xpathElementoBotaoBuscar);
	}

	public boolean validaSucessoPesquisa() throws Exception {
		return elementoContemTexto(xpathElementoTituloResultadoPesquisa, textoSucessoPesquisa);
	}

	public void selecionarFiltro(String string) {
		selecionarElementoListBoxByName(listBoxCEPDe_name, EnumTipoCEP.TODOS.getValue());
	}
}
