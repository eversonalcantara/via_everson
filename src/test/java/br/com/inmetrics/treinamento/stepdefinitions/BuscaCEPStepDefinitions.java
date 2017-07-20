package br.com.inmetrics.treinamento.stepdefinitions;

import org.junit.Assert;

import br.com.inmetrics.treinamento.page.BuscaCEPPage;
import br.com.inmetrics.treinamento.page.HomePage;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class BuscaCEPStepDefinitions {
	
	HomePage home = new HomePage();
	BuscaCEPPage buscaCEP = new BuscaCEPPage();
	
	@Before("@OpenHome")
	public void irHome() {
		home.goToHome();
	}
	
	@Dado("^que eu esteja na home dos correios$")
	public void queEuEstejaNaHomeDosCorreios() throws Throwable {
		Assert.assertTrue(home.isValida());
	}

	@Quando("^eu clicar em busca CEP$")
	public void euClicarEmBuscaCEP() throws Throwable {
		home.clicarBuscaCEP();
	}

	@Então("^devo visualizar a tela de Busca de CEP$")
	public void devoVisualizarATelaDeBuscaDeCEP() throws Throwable {
		buscaCEP.isValida();
	}

	@Quando("^eu entrar com os criterios de busca \"(.*?)\"$")
	public void euEntrarComOsCriteriosDeBusca(String criterio) throws Throwable {
		buscaCEP.preencherCriterioBusca(criterio);
	}

	@E("^clicar no botao buscar$")
	public void clicarNoBotaoBuscar() throws Throwable {
		buscaCEP.clicarBotaoBuscar();
	}

	@Então("^devo visualizar a tela de Resultados$")
	public void devoVisualizarATelaDeResultados() throws Throwable {
		Assert.assertTrue(buscaCEP.validaSucessoPesquisa());
	}

	@E("^selecionar \"(.*?)\"$")
	public void selecionar(String arg1) throws Throwable {
		
	}

}
