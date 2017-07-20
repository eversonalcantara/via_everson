package br.com.inmetrics.treinamento.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.inemtrics.treinamento.commons.TestBase;
import br.com.inmetrics.treinamento.SingletonInstancePage;
import br.com.inmetrics.treinamento.enumerator.EnumTipoCEP;
import br.com.inmetrics.treinamento.page.BuscaCEPPage;
import br.com.inmetrics.treinamento.page.HomePage;

public class StandardJunitTest extends TestBase{
	
	static HomePage home = new HomePage();
	static BuscaCEPPage buscaCEP = new BuscaCEPPage();
	
	@Before
	public void validarTelaHome() throws Exception {
		SingletonInstancePage.getInstance().getChromeDriver().navigate().to("http://www.correios.com.br/para-voce");
		Assert.assertTrue(home.isValida());
		home.clicarBuscaCEP();
		Assert.assertTrue(buscaCEP.isValida());
	}
	
	@Test
	public void realizarBuscaCEPValido() throws Exception {
		buscaCEP.preencherCriterioBusca("03111040");
		buscaCEP.clicarBotaoBuscar();
		Assert.assertTrue(buscaCEP.validaSucessoPesquisa());
	}
	
	@Test
	public void realizarPesquisaComFiltro() throws Exception {
		buscaCEP.preencherCriterioBusca("03111030");
		buscaCEP.selecionarFiltro(EnumTipoCEP.TODOS.getValue());
		buscaCEP.clicarBotaoBuscar();
		Assert.assertTrue(buscaCEP.validaSucessoPesquisa());
	}
	
}
