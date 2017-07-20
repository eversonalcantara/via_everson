package br.com.inmetrics.treinamento.testpagefactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.inemtrics.treinamento.commons.TestBase;
import br.com.inmetrics.treinamento.SingletonInstancePage;
import br.com.inmetrics.treinamento.enumerator.EnumTipoCEP;
import br.com.inmetrics.treinamento.pagefactory.BuscaCEPPageFactory;
import br.com.inmetrics.treinamento.pagefactory.HomePageFactory;

public class StandardJunitTestWithPageFactory extends TestBase{
	
	static HomePageFactory home = new HomePageFactory();
	static BuscaCEPPageFactory buscaCEP = new BuscaCEPPageFactory();
	static WebDriver driver = SingletonInstancePage.getInstance().getChromeDriver();
	
	@Before
	public void validarTelaHome() throws Exception {
		driver.navigate().to("http://www.correios.com.br/para-voce");
		
		PageFactory.initElements(driver, home);
		PageFactory.initElements(driver, buscaCEP);
		
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
