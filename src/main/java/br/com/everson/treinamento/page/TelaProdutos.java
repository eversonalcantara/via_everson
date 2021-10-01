package br.com.everson.treinamento.page;

import br.com.everson.treinamento.SingletonInstancePage;

public class TelaProdutos extends BasePage {
	
	
	private String msgAdicaoCarrinho = "//*[@id=\"content\"]/div[2]/div";
	
	
	public void goToHome() {
		SingletonInstancePage.getInstance().getChromeDriver().navigate().to("http://www.correios.com.br/para-voce");
	}
	//*[@id="product-3111"]/div[1]/div[2]/div/form/table/tbody/tr[1]/td[2]/ul/li[1]
	public void selecionarProdutoPorNumero(int numeroItem) {	
		clicarPorXPath("//*[@id=\"content\"]/div[2]/div/div[" + numeroItem + "]/div/div[1]/figure/a/img[2]");
	}

	public void selecionarTamanhoXS(int idProduto) {
		clicarPorXPath("//*[@id=\"product-" + idProduto +  "\"]/div[1]/div[2]/div/form/table/tbody/tr[1]/td[2]/ul/li[1]");
	}
	
	public void selecionarCor(int idProduto) {
		clicarPorXPath("//*[@id=\"product-" + idProduto +  "\"]/div[1]/div[2]/div/form/table/tbody/tr[2]/td[2]/ul/li[1]");
	}
	
	public void clicarComprar(int idProduto) {
		clicarPorXPath("//*[@id=\"product-" + idProduto +  "\"]/div[1]/div[2]/div/form/div/div[2]/button");
	}
	
	public boolean verificaProdutoNoCarrinho() throws Exception {
		return contemElementoByXPath(msgAdicaoCarrinho);
	}
	
}
