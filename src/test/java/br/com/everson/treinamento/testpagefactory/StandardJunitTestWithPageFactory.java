package br.com.everson.treinamento.testpagefactory;

import org.openqa.selenium.WebDriver;

import br.com.everson.treinamento.SingletonInstancePage;
import br.com.everson.treinamento.commons.TestBase;
import br.com.everson.treinamento.pagefactory.BuscaCEPPageFactory;
import br.com.everson.treinamento.pagefactory.LoginPage;

public class StandardJunitTestWithPageFactory extends TestBase{

	static LoginPage home = new LoginPage();
	static BuscaCEPPageFactory buscaCEP = new BuscaCEPPageFactory();
	static WebDriver driver = SingletonInstancePage.getInstance().getChromeDriver();
	
//	@Before
//	public void validarTelaHome() throws Exception {
//		driver.navigate().to("http://www.correios.com.br/para-voce");
//		
//		PageFactory.initElements(driver, home);
//		PageFactory.initElements(driver, buscaCEP);
//		
//		Assert.assertTrue(home.isValida());
////		home.clicarBuscaCEP();
//		Assert.assertTrue(buscaCEP.isValida());
//	}
//	
//	@Test
//	public void realizarBuscaCEPValido() throws Exception {
//		buscaCEP.preencherCriterioBusca("03111040");
//		buscaCEP.clicarBotaoBuscar();
//		Assert.assertTrue(buscaCEP.validaSucessoPesquisa());
//	}
//	
//	@Test
//	public void realizarPesquisaComFiltro() throws Exception {
//		buscaCEP.preencherCriterioBusca("03111030");
//		buscaCEP.selecionarFiltro(EnumTipoCEP.TODOS.getValue());
//		buscaCEP.clicarBotaoBuscar();
//		Assert.assertTrue(buscaCEP.validaSucessoPesquisa());
//	}
	
}
