package br.com.everson.treinamento.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.everson.treinamento.SingletonInstancePage;
import br.com.everson.treinamento.commons.TestBase;
import br.com.everson.treinamento.page.HomePage;
import br.com.everson.treinamento.page.TelaProdutos;

public class StandardJunitTest extends TestBase{
	
	static HomePage home = new HomePage();
	static WebDriver driver = SingletonInstancePage.getInstance().getChromeDriver();
	
	@Before
	public void validarTelaHome() throws Exception {
		try {
			driver.navigate().to("http://lojaebac.ebaconline.art.br/");
			Assert.assertTrue(home.isValida());
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void incluirItensCarrinho() throws Exception {
		
		TelaProdutos telaProdutos = home.clicarTelaProdutos();
		telaProdutos.selecionarProdutoPorNumero(1);
		telaProdutos.selecionarTamanhoXS(2559);
		telaProdutos.selecionarCor(2559);
		telaProdutos.clicarComprar(2559);
		Assert.assertTrue(telaProdutos.verificaProdutoNoCarrinho());
		
		home.goToHome();
		
		telaProdutos = home.clicarTelaProdutos();
		telaProdutos.selecionarProdutoPorNumero(2);
		telaProdutos.selecionarTamanhoXS(3111);
		telaProdutos.selecionarCor(3111);
		telaProdutos.clicarComprar(3111);
		Assert.assertTrue(telaProdutos.verificaProdutoNoCarrinho());
	}
	
}
