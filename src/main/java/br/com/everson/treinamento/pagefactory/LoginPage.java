package br.com.everson.treinamento.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.everson.exceptions.TesteFalhouException;

import br.com.everson.treinamento.SingletonInstancePage;
import br.com.everson.treinamento.utils.SeleniumAuxiliares;

public class LoginPage extends BasePageFactory{

	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div/img")
	private WebElement imgBancoOriginal; 
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div/form/label[1]")
	private WebElement labelDigiteSeuCPF;
	
	SeleniumAuxiliares sa;
	
	public LoginPage() {
		this.sa = new SeleniumAuxiliares(SingletonInstancePage.getInstance().getChromeDriver());
	}
	
	
	public void goToLogin() {
		SingletonInstancePage.getInstance().getChromeDriver().navigate().to("");
	}

	/**
	 * Valida se os componentes de validação da tela estão presentes
	 * @return
	 * @throws Exception 
	 */
	public boolean isValida() throws Exception {
		return contemElemento(imgBancoOriginal)  &&
				contemElemento(labelDigiteSeuCPF);
	}
	
	public void digitaCPF() throws InterruptedException, TesteFalhouException {
		preencherTexto("336161113695", sa.elementoProximoAoTexto(false, "Digite seu CPF", 1, "//", "input", 5, ""));
	}

	
	
}
