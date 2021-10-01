package br.com.everson.treinamento.stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.everson.treinamento.SingletonInstancePage;
import br.com.everson.treinamento.page.HomePage;
import br.com.everson.treinamento.page.TelaProdutos;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.qameta.allure.Attachment;

public class CarrinhoStepDefinitions {
	
	HomePage home = new HomePage();
	TelaProdutos telaProdutos = null;
	
	@Attachment(value = "Evidência {0}", type = "image/png")
	public byte[] printEvidencia(String nomeEvidencia) throws FileNotFoundException, IOException {
        byte[] bytes = ((TakesScreenshot) SingletonInstancePage.getInstance().getChromeDriver())
                .getScreenshotAs(OutputType.BYTES);
        return bytes;
	}
	
	@Before("@OpenHome")
	public void irHome() throws FileNotFoundException, IOException {
		home.goToHome();
		printEvidencia("Home");
	}
	
	
	@Dado("^que eu esteja na home da Loja$")
	public void queEuEstejaNaHomeDaLoja() throws Throwable {
		Assert.assertTrue(home.isValida());
		printEvidencia("Home");
	}
	

	@Quando("^eu clicar em Comprar$")
	public void euClicarEmComprar() throws Throwable {
		telaProdutos = home.clicarTelaProdutos();
		printEvidencia("Tela Produtos");
	}

	@Entao("^devo visualizar a tela de Produtos$")
	public void devoVisualizarATelaDeProdutos() throws Throwable {
		Assert.assertNotNull(telaProdutos);

	}

	@Quando("^eu clicar no produto (\\d+)$")
	public void euClicarNoProduto(int arg1) throws Throwable {
		telaProdutos.selecionarProdutoPorNumero(arg1);
		printEvidencia("Seleciona produto");

	}

	@E("^selecionar o tamanho e cor e clicar em comprar para o produto (\\d+)$")
	public void selecionarOTamanhoECorEClicarEmComprarParaOProduto(int arg1) throws Throwable {
		telaProdutos.selecionarTamanhoXS(arg1);
		telaProdutos.selecionarCor(arg1);
		printEvidencia("Tamanho e Cor selecionados");
		telaProdutos.clicarComprar(arg1);
	}

	@Entao("^devo visualizar a mensagem de intem incluido no carrinho corretamente$")
	public void devoVisualizarAMensagemDeIntemIncluidoNoCarrinhoCorretamente() throws Throwable {
		Assert.assertTrue(telaProdutos.verificaProdutoNoCarrinho());
		printEvidencia("adicionado ao carrinho");
	}

}
