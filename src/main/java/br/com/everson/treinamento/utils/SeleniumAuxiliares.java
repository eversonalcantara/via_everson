package br.com.everson.treinamento.utils;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everson.exceptions.TesteFalhouException;

public class SeleniumAuxiliares {
	
	public WebDriver driver; 
	public static String IgnoreTextCase="translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜÉÈÊÀ�?ÂÃÒÓÔÙÚÛÇÅ�?ÕÑŒ', 'abcdefghijklmnopqrstuvwxyzäöüéèêàáâãòóôùúûçåïõñœ')";
	public static String IgnorePontoCase="translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜÉÈÊÀ�?ÂÃÒÓÔÙÚÛÇÅ�?ÕÑŒ', 'abcdefghijklmnopqrstuvwxyzäöüéèêàáâãòóôùúûçåïõñœ')";
	
	public SeleniumAuxiliares(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement retornarElementoVisivel(String xPath){
		try{
			if (driver.findElements(By.xpath(xPath)).size() > 0){
				List<WebElement> elementosEncontrados = driver.findElements(By.xpath(xPath));
				for ( WebElement elem: elementosEncontrados) { 
					if(elem.isDisplayed()){
						return elem;
					}
			    }
			}
		}catch (Exception e){
			return null;
		}
		return null;
	}


	public WebElement retornarElementoVisivel(WebElement ElemementPai, String xPath){
		if (ElemementPai.findElements(By.xpath(xPath)).size() > 0){
			List<WebElement> elementosEncontrados = ElemementPai.findElements(By.xpath(xPath));
			for ( WebElement elem: elementosEncontrados) { 
				if(elem.isDisplayed()){
					return elem;
				}
		    }
		}
		return null;
	}
	
	public  boolean isClickable(WebElement webe, int segundos_timeout){
		try
		{
			
		   WebDriverWait wait = new WebDriverWait(driver, segundos_timeout);
		   wait.until(ExpectedConditions.elementToBeClickable(webe));
		   return webe.isDisplayed();
		}
		catch (Exception e)
		{
		  return false;
		}
	}
	
	//xPath, caminho para o elemento
	//segundos_timeout, tempo limite de espera para o elemento se encontrado
	//RETORNA true, se durante a espera o elemento aparecer, ou false der timout
	public boolean esperaElemento(String xPath, int segundos_timeout) throws InterruptedException{
		
		Boolean isPresent = retornarElementoVisivel(xPath)!=null;
		if (isPresent==true){
	
			return true;

		}
		
		for (int i = segundos_timeout; i > 0; i--) {
			Thread.sleep(1000);
			isPresent =retornarElementoVisivel(xPath)!=null;
			if (isPresent==true){
				WebElement Elem = retornarElementoVisivel(xPath);
				if (isClickable(Elem,segundos_timeout)){
					isPresent=true;
				}else{
					isPresent=false;
				}
				return isPresent;
			}
		}
		
		return isPresent;
	}
	
	//xPath, caminho para o elemento
	//segundos_timeout, tempo limite de espera para o elemento se encontrado
	//RETORNA true, se durante a espera o elemento aparecer, ou false der timout
	public boolean esperaElemento( WebElement elementpai, String xPath, int segundos_timeout) throws InterruptedException
	{

		Boolean isPresent = retornarElementoVisivel(elementpai,xPath)!=null;
		if (isPresent==true){
			return retornarElementoVisivel(elementpai,xPath).isDisplayed();
		}
		for (int i = segundos_timeout; i > 0; i--) {
			Thread.sleep(1000);
			isPresent = retornarElementoVisivel(elementpai,xPath)!=null;
			if (isPresent==true){
				WebElement Elem = retornarElementoVisivel(elementpai,xPath);
				if (isClickable(Elem,segundos_timeout)){
					isPresent=Elem.isDisplayed();
				}else{
					isPresent=false;
				}
				return retornarElementoVisivel(elementpai,xPath).isDisplayed();
			}
		}
		
		return isPresent;
	}
	
	
	
	//xPath, caminho para o elemento
	//segundos_timeout, tempo limite de espera para o elemento se encontrado
	//RETORNA true, se durante a espera o elemento sumir, ou false der timout
	public boolean esperaElementoSumir(String xPath, int segundos_timeout) throws InterruptedException
	{
		Boolean notPresent = !esperaElemento(xPath,0);
		if (notPresent==true){
			return notPresent;
		}
		for (int i = segundos_timeout; i > 0; i--) {
			Thread.sleep(1000);
			notPresent = !esperaElemento(xPath,0);
			if (notPresent==true){
				return notPresent;
			}
		}
		
		return notPresent;
	}
	
	
	//xPath, caminho para o elemento
	//segundos_timeout, tempo limite de espera para o elemento se encontrado
	//RETORNA true, se durante a espera o elemento sumir, ou false der timout
	public boolean esperaElementoSumir( WebElement elementpai, String xPath, int segundos_timeout) throws InterruptedException
	{
		Boolean notPresent = !esperaElemento(elementpai, xPath,0);
		if (notPresent==true){
			return notPresent;
		}
		for (int i = segundos_timeout; i > 0; i--) {
			Thread.sleep(1000);
			notPresent = !esperaElemento(elementpai, xPath,0);
			if (notPresent==true){
				return notPresent;
			}
		}
		
		return notPresent;
	}
	
	//xPath, caminho para o elemento
	//segundos_timeout, tempo limite de espera para o elemento se encontrado
	//segundos_espera_antes_click, tempo de espera, depois de já encontrado o elemente, antes de realmente clicar nele
	public void clicar(WebElement element, int segundos_espera_antes_click, String mensagemDeErro) throws InterruptedException, TesteFalhouException
	{


		WebDriverWait wait = new WebDriverWait(driver, 2);
		Thread.sleep(segundos_espera_antes_click*1000);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		
		
		try{
			element.click();
		}catch (Exception e){
			//tenta ir direto pelo link
			String Link = element.getAttribute("href");			
			if(Link!=""){
				driver.get(element.getAttribute("href"));
			}else{
				throw new TesteFalhouException(mensagemDeErro);
			}
		}

	}
	
	
	//xPath, caminho para o elemento
	//segundos_timeout, tempo limite de espera para o elemento se encontrado
	//segundos_espera_antes_click, tempo de espera, depois de já encontrado o elemente, antes de realmente clicar nele
	public void clicar(String xPath, int segundos_timeout, int segundos_espera_antes_click, String mensagemDeErro) throws InterruptedException, TesteFalhouException
	{

		if (esperaElemento(xPath,segundos_timeout)==false){
			throw new TesteFalhouException("Clicar - Elemento com o xPath '" + xPath + "' não encontrado e timeout excedido");
		}
		//WebDriverWait wait = new WebDriverWait(driver, segundos_timeout);
		Thread.sleep(segundos_espera_antes_click*1000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
		
		try{
			driver.findElement(By.xpath(xPath)).click();
		}catch (Exception e){
			//tenta ir direto pelo link
			String Link = retornarElementoVisivel(xPath).getAttribute("href");			
			if(!Link.contains("")){
				driver.get(retornarElementoVisivel(xPath).getAttribute("href"));
			}else{
				throw new TesteFalhouException(mensagemDeErro);
			}
		}

	}
	
	
	
	public void clicarElementoProximoAoTexto(Boolean exatamente_igual, String texto, int NumeroDoItem, String pai, String tagidentif, int limite_de_camadas) throws InterruptedException, TesteFalhouException	{
		WebElement element = elementoProximoAoTexto(exatamente_igual, texto, NumeroDoItem, pai, tagidentif, limite_de_camadas, "Impossível encontrar: " + texto);
		clicar(element, 0, "Não foi possível clicar em: " + element);
	}
	
	
	public void clicarElementoProximoAoTexto(Boolean exatamente_igual, String texto, int NumeroDoItem, WebElement elementpai, String tagidentif, int limite_de_camadas) throws InterruptedException, TesteFalhouException
	{
		WebElement element = elementoProximoAoTexto(exatamente_igual, texto, NumeroDoItem, elementpai, tagidentif, limite_de_camadas, "Impossível encontrar: " + texto);
		clicar(element, 0, "Não foi possível clicar em: " + element);

	}
	
	/**
	 *
	 * @since 5 de mai de 2016 09:38:02
	 * @author Everson Alcantara<BR>
	 */
	public void clicarIE(WebElement element, int segundos_espera_antes_click, String mensagemDeErro) throws InterruptedException, TesteFalhouException {

		WebDriverWait wait = new WebDriverWait(driver, 2);
		Thread.sleep(segundos_espera_antes_click * 1000);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		try {

//			if (FuncoesAutomacaoIB.ehInstanciaDeIE()) {
//
//				Actions builder = new Actions(driver);
//				builder.doubleClick(element).build().perform();
//			} 
//			else {
//
//				element.click();
//			}
		} 
		catch (Exception e) {

			// tenta ir direto pelo link
			String Link = element.getAttribute("href");

			if (Link != "") {

				driver.get(element.getAttribute("href"));
			} 
			else {

				throw new TesteFalhouException(mensagemDeErro);
			}
		}
	}
	
	//xPath, caminho para o elemento
	//segundos_timeout, tempo limite de espera para o elemento se encontrado
	//segundos_espera_antes_click, tempo de espera, depois de já encontrado o elemente, antes de realmente escrever nele
	//texto, texto para ser escrito
	public void escrever(String xPath, int segundos_timeout, int segundos_espera_antes_escrever, String texto) throws InterruptedException, TesteFalhouException
	{

		if (esperaElemento(xPath,segundos_timeout)==false){
			throw new TesteFalhouException("Escrever - Elemento com o xPath '" + xPath + "' não encontrado e timeout excedido");
		}
		Thread.sleep(segundos_espera_antes_escrever*1000);
		retornarElementoVisivel(xPath).click();
		retornarElementoVisivel(xPath).sendKeys(texto);
		
	
	}
	
	public WebElement elemento(String xPath) throws TesteFalhouException, InterruptedException{
		if (esperaElemento(xPath,1)==false){
			throw new TesteFalhouException("Elemento - Elemento com o xPath '" + xPath + "' não encontrado");
		}
		return retornarElementoVisivel(xPath);
		
	}
	
	
	/**
	 * 
	 * Se você decide realizar a pesquisa do elemento por um valor no atributo, use o parâmetro 
	 * <code>exatamente_igual</code> com o valor <code>false</code>. 
	 * 
	 * @param exatamente_igual - Opçao de string do elemento ser exatamente igual ou contida.  
	 * @param texto
	 * @param NumeroDoItem
	 * @param tipotag
	 * @param pai
	 * @param segundos_timeout
	 * @param mensagemDeErro - mensagem que irá ser lançada na exception.
	 * @return
	 * @throws InterruptedException
	 * @throws TesteFalhouException
	 */
	public WebElement elementoQuecontenhaTexto(boolean exatamente_igual, String texto, int NumeroDoItem, String tipotag, String pai, int segundos_timeout, String mensagemDeErro) throws InterruptedException, TesteFalhouException{
		WebElement element=null;
		String CondicaoVisivel=" and not(contains(@style,'display:none'))";
		

		String xPath;
		if (exatamente_igual==true){
			xPath=pai + tipotag + "[*='" + texto  + "'" + CondicaoVisivel + "]" + "[" + NumeroDoItem + "]";
			
			if(esperaElemento(xPath,segundos_timeout)==true){
				element= retornarElementoVisivel(xPath);
				return element;
			}else{
				texto=texto.toLowerCase();
				xPath=pai + tipotag + "[normalize-space(" + IgnorePontoCase + ")='" + texto + "'" + CondicaoVisivel +  "]" + "[" + NumeroDoItem + "]";
				if(esperaElemento(xPath,1)==true){
					element= retornarElementoVisivel(xPath);
					return element;
				}
			}
			
		}else{
			texto=texto.toLowerCase();
			xPath=pai + tipotag + "[contains(" + IgnoreTextCase + ",'" + texto + "')" + CondicaoVisivel + "]" + "[" + NumeroDoItem + "]";
			if(esperaElemento(xPath,segundos_timeout)==true){
				element= retornarElementoVisivel(xPath);
				return element;
			}
			xPath=pai + tipotag + "[contains(normalize-space(" + IgnoreTextCase + "),'" + texto + "')" + CondicaoVisivel +  "]" + "[" + NumeroDoItem + "]";
			if(esperaElemento(xPath,segundos_timeout)==true){
				element= retornarElementoVisivel(xPath);
				return element;
			}
			xPath=pai + tipotag + "[@*[contains(" + IgnorePontoCase + ", '" + texto + "')" + CondicaoVisivel + "]]" + "[" + NumeroDoItem + "]";
			if(esperaElemento(xPath,segundos_timeout)==true){
				element= retornarElementoVisivel(xPath);
				return element;
			}
		}
		
		throw new TesteFalhouException(mensagemDeErro);
	}

	/**
	 * @param exatamente_igual - Opçao de string do elemento ser exatamente igual ou contida.
	 * @param texto
	 * @param NumeroDoItem
	 * @param tipotag
	 * @param elementpai
	 * @param segundos_timeout
	 * @param mensagemDeErro
	 * @return
	 * @throws InterruptedException
	 * @throws TesteFalhouException
	 */
	public WebElement elementoQuecontenhaTexto(boolean exatamente_igual, String texto, int NumeroDoItem, String tipotag, WebElement elementpai, int segundos_timeout, String mensagemDeErro) throws InterruptedException, TesteFalhouException{
		WebElement element=null;
		String CondicaoVisivel=" and not(contains(@style,'display:none'))";
		String pai=".//";
		String xPath;
		if (exatamente_igual==true){
			xPath=pai + tipotag + "[*='" + texto  + "'" + CondicaoVisivel + "]" + "[" + NumeroDoItem + "]";
			
			if(esperaElemento(elementpai, xPath,segundos_timeout)==true){
				element= retornarElementoVisivel(elementpai, xPath);
				return element;
			}else{
				texto=texto.toLowerCase();
				xPath=pai + tipotag + "[normalize-space(" + IgnorePontoCase + ")='" + texto + "'" + CondicaoVisivel +  "]";
				if(esperaElemento(elementpai, xPath,1)==true){
					element= retornarElementoVisivel(elementpai, xPath);
					return element;
				}
			}
			
		}else{
			texto=texto.toLowerCase();
			xPath=pai + tipotag + "[contains("+ IgnoreTextCase + ",'" + texto + "')" + CondicaoVisivel +  "]" + "[" + NumeroDoItem + "]";
			if(esperaElemento(elementpai, xPath,segundos_timeout)==true){
				element= retornarElementoVisivel(elementpai, xPath);
				return element;
			}
			xPath=pai + tipotag + "[contains(normalize-space(text()),'" + texto + "')" + CondicaoVisivel +  "]" + "[" + NumeroDoItem + "]";
			if(esperaElemento(elementpai, xPath,segundos_timeout)==true){
				element= retornarElementoVisivel(elementpai, xPath);
				return element;
			}
			xPath=pai + tipotag + "[@*[contains(., '" + texto + "')" + CondicaoVisivel +  "]]" + "[" + NumeroDoItem + "]";
			if(esperaElemento(elementpai, xPath,segundos_timeout)==true){
				element= retornarElementoVisivel(elementpai, xPath);
				return element;
			}
		}
		
		throw new TesteFalhouException(mensagemDeErro);

	}
	
	/**
	 * @param exatamente_igual - Opçao de string do elemento ser exatamente igual ou contida.
	 * @param texto
	 * @param NumeroDoItem
	 * @param pai
	 * @param tagidentif
	 * @param limite_de_camadas - limite_de_camadas é até quantas camadas a função deve procurar.
	 * @param mensagemDeErro - mensagem que irá para exception.
	 * @return
	 * @throws InterruptedException
	 * @throws TesteFalhouException
	 */
	public WebElement elementoProximoAoTexto(Boolean exatamente_igual, String texto, int NumeroDoItem, String pai, String tagidentif, int limite_de_camadas, String mensagemDeErro) throws InterruptedException, TesteFalhouException{
		WebElement element=null;
		String CondicaoVisivel=" and not(contains(@style,'display:none'))";
		
		String xPath="";
		String xPath_test="";

		if (exatamente_igual==true){
			xPath_test=pai + "*[" + IgnorePontoCase + "='" + texto  + "'" + CondicaoVisivel +  "]";
			if(esperaElemento(xPath_test,1)==true){
				xPath=xPath_test;
			}else{
				texto=texto.toLowerCase();
				xPath_test=pai + "*[normalize-space(" + IgnorePontoCase + ")='" + texto + "'" + CondicaoVisivel +  "]";
				if(esperaElemento(xPath_test,1)==true){
					xPath=xPath_test;
				}
			}
		}else{
			texto=texto.toLowerCase();
			xPath_test=pai + "*[contains("+ IgnoreTextCase +",'" + texto + "')" + CondicaoVisivel +  "]";
			if(esperaElemento(xPath_test,1)==true){
				xPath=xPath_test;
			}else{
				xPath_test=pai + "*[contains(normalize-space(" + IgnoreTextCase + "),'" + texto + "')" + CondicaoVisivel + "]";
				if(esperaElemento(xPath_test,1)==true){
					xPath=xPath_test;
				}else{
					xPath_test=pai + "*[@*[contains(" + IgnorePontoCase + ", '" + texto + "')" + CondicaoVisivel + "]]";
					if(esperaElemento(xPath_test,1)==true){
						xPath=xPath_test;
					}
				}
			}
		}
			
		if(xPath==""){
			throw new TesteFalhouException(mensagemDeErro);
		}
		
		CondicaoVisivel="not(contains(@style,'display:none'))";
		
		
		//checando elementos na vizinhança
		int Counter=0;
		if(esperaElemento(xPath ,1)==true){
			
			String xPathExam=xPath + "/following-sibling::" + tagidentif + "[" + CondicaoVisivel +  "]["+ NumeroDoItem +"]";			
			if (esperaElemento(xPathExam,1)==true){
				element=retornarElementoVisivel(xPathExam);

				return element;
			}
			
			xPathExam=xPath + "/preceding-sibling::" + tagidentif + "[" + CondicaoVisivel +   "]["+ NumeroDoItem +"]";			
			if (esperaElemento(xPathExam,1)==true ){
				element=retornarElementoVisivel(xPathExam);
				return element;
			}
			
			xPath= xPath + "/..";
			xPathExam= xPath+ "//" + tagidentif + "[" + CondicaoVisivel +  "]["+ NumeroDoItem +"]";
			Counter=0;
			while (esperaElemento(xPathExam,1)==false && Counter<=limite_de_camadas){
				xPath= xPath + "/..";
				xPathExam= xPath +  "//" + tagidentif + "[" + CondicaoVisivel +  "]["+ NumeroDoItem +"]";
				Counter++;
			}
			element=retornarElementoVisivel(xPathExam);
			return element;
		}
		return element;


	}
	
	/**
	 * 
	 * @param exatamente_igual - Opçao de string do elemento ser exatamente igual ou contida.
	 * @param texto
	 * @param NumeroDoItem
	 * @param elementpai
	 * @param tagidentif
	 * @param limite_de_camadas - limite_de_camadas é até quantas camadas a função deve procurar
	 * @param mensagemDeErro - Mensagem que será retornada na Exception.
	 * @return
	 * @throws InterruptedException
	 * @throws TesteFalhouException
	 */
	public WebElement elementoProximoAoTexto(Boolean exatamente_igual, String texto, int NumeroDoItem,  WebElement elementpai, String tagidentif, int limite_de_camadas, String mensagemDeErro) throws InterruptedException, TesteFalhouException{
		WebElement element=null;
		String CondicaoVisivel=" and not(contains(@style,'display:none'))";
		
		String pai=".//";
		String xPath="";
		String xPath_test="";
		if (exatamente_igual==true){
			xPath_test=pai + "*[" + IgnorePontoCase + "='" + texto  + "'" + CondicaoVisivel + "]";
			if(esperaElemento(elementpai,xPath_test,1)==true){
				xPath=xPath_test;
			}else{
				texto=texto.toLowerCase();
				xPath_test=pai + "*[normalize-space(" + IgnorePontoCase + ")='" + texto + "'" + CondicaoVisivel +  "]";
				if(esperaElemento(xPath_test,1)==true){
					xPath=xPath_test;
				}
			}
			
		}else{
			texto=texto.toLowerCase();
			xPath_test=pai + "*[contains(" + IgnoreTextCase + ",'" + texto + "')" + CondicaoVisivel + "]";
			if(esperaElemento(elementpai,xPath_test,1)==true){
				xPath=xPath_test;
			}else{
				xPath_test=pai + "*[contains(normalize-space(" + IgnoreTextCase + "),'" + texto + "')" + CondicaoVisivel + "]";
				if(esperaElemento(elementpai,xPath_test,1)==true){
					xPath=xPath_test;
				}else{
					xPath_test=pai + "*[@*[contains(" + IgnorePontoCase + ", '" + texto + "')" + CondicaoVisivel + "]]";
					if(esperaElemento(elementpai,xPath_test,1)==true){
						xPath=xPath_test;
					}
				}
			}
		}
		
		if(xPath==""){
			throw new TesteFalhouException(mensagemDeErro);
		}
		
		CondicaoVisivel="not(contains(@style,'display:none'))";
		
		//checando elementos na vizinhança
		int Counter=0;
		if(esperaElemento(elementpai,xPath ,1)==true){
			
			String xPathExam=xPath + "/following-sibling::" + tagidentif + "[" + CondicaoVisivel +  "]["+ NumeroDoItem +"]";			
			if (esperaElemento(elementpai,xPathExam,1)==true){
				element=retornarElementoVisivel(xPathExam);

				return element;
			}
			
			xPathExam=xPath + "/preceding-sibling::" + tagidentif + "[" + CondicaoVisivel +  "]["+ NumeroDoItem +"]";			
			if (esperaElemento(elementpai,xPathExam,1)==true ){
				element=retornarElementoVisivel(xPathExam);
				return element;
			}
			
			xPath= xPath + "/..";
			xPathExam= xPath+ "//" + tagidentif + "[" + CondicaoVisivel + "]["+ NumeroDoItem +"]";
			Counter=0;
			while (esperaElemento(elementpai,xPathExam,1)==false && Counter<=limite_de_camadas){
				xPath= xPath + "/..";
				xPathExam= xPath +  "//" + tagidentif + "[" + CondicaoVisivel +  "]["+ NumeroDoItem +"]";
				Counter++;
			}
			element=retornarElementoVisivel(xPathExam);
			return element;
		}
		return element;

	}
	
	public void mouseMoveTo(WebElement element) throws AWTException{
		
//		Integer ObjY = element.getLocation().getY();
//		Integer ObjX = element.getLocation().getX();
//		Integer WindowY = driver.manage().window().getPosition().getY();
//		Integer WindowX = driver.manage().window().getPosition().getX();
//		Integer ObjHeight = element.getSize().getHeight();
//		Integer ObjWidth = element.getSize().getWidth();
//	
//		Integer ObjBordaTop = 0;
//		Integer ObjBordaLeft = 0;
//		
//
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//
//		long viewport_outerHeight = (long) js.executeScript("return window.outerHeight;");
//		long viewport_innerHeight = (long)js.executeScript("return window.innerHeight;");
//		long viewport_outerWidth= (long)js.executeScript("return window.outerWidth;");
//		long viewport_innerWidtht = (long)js.executeScript("return window.innerWidth;");
//		
//		
//		ObjBordaTop = (int)viewport_outerHeight - (int)viewport_innerHeight;
//		ObjBordaLeft = (int)viewport_outerWidth	- (int)viewport_innerWidtht;
//	
//		Robot robot;
//		robot = new Robot();
//		new Actions(driver).moveToElement(element).perform();
//		robot.mouseMove(
//				(int) (WindowX + ObjBordaLeft + ObjX + Math.floor(ObjWidth / 2)),
//				(int) (WindowY + ObjBordaTop + ObjY + Math.floor(ObjHeight / 2)));
//		
		
	}
	
	public void mouseMoveTo(String xPath, int timout) throws AWTException, TesteFalhouException, InterruptedException{
		if (esperaElemento(xPath,timout)==false){
			throw new TesteFalhouException("MouseMove - Elemento com o xPath '" + xPath + "' não encontrado e timeout excedido");
		}
		
		WebElement element=driver.findElement(By.xpath(xPath));

		mouseMoveTo(element);
		
	}
	
    public void mouseRightClick(WebElement element) throws AWTException, TesteFalhouException, InterruptedException {
  		Robot robot;
  		robot = new Robot();
      	
  		mouseMoveTo(element);
  		robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
  		robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);

     }

    public void mouseClick(String xPath, int timout) throws AWTException, TesteFalhouException, InterruptedException {
		Robot robot;
		robot = new Robot();
    	
		mouseMoveTo(xPath,timout);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }
	
    public static void mouseClick(int x, int y) throws AWTException {
		Robot robot;
		robot = new Robot();
    	
		robot.mouseMove(x, y);
		
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }
	
	public void mouseMoveTo(int PosX, int PosY) throws AWTException, TesteFalhouException, InterruptedException{
	
		Robot robot;
		robot = new Robot();
		robot.mouseMove(PosX,PosY);
	}
	
	//esta função não funciona em todos os casos. A borda em volta do elemento não fica visível
	public void highlight(WebElement element, int segundos_duracao) throws InterruptedException	{

		//EsperaElemento(xPath,segundos_timeout);
		//WebElement element=driver.findElement(By.xpath(xPath));
		String originalStyle = element.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', ' border: 2px solid red;');", element);
		
		try {
			Thread.sleep(segundos_duracao*1000);
		} 
		catch (InterruptedException e) {}
		
		js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
	
	}
	
	//esta função não funciona em todos os casos. A borda em volta do elemento não fica visível
	public void highlight(String xPath, int segundos_timeout, int segundos_duracao) throws InterruptedException	{

		esperaElemento(xPath,segundos_timeout);
		WebElement element=driver.findElement(By.xpath(xPath));
		
		String originalStyle = element.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', ' border: 5px solid red;');", element);
		
		try {
			Thread.sleep(segundos_duracao*1000);
		} 
		catch (InterruptedException e) {}
		
		js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
	}
	
	/**
	 * Retorna o xpath do elemento.
	 * @param element
	 * @return
	 */
	public String getXpath(WebElement element){
		return element.getAttribute("xpath");
	}
	
	
	public void aguardarEnquantoExistir(By by) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		wait = null;
	}
	
}