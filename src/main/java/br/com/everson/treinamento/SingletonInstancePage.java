package br.com.everson.treinamento;

import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonInstancePage {

    private static SingletonInstancePage instance = null;
    private ChromeDriver driver;

    private SingletonInstancePage(){
    	newInstanceBrowser();
    }

    public ChromeDriver newInstanceBrowser() {
    	System.setProperty("webdriver.chrome.driver","d:\\Automação\\git\\chromedriver.exe");
    	driver = new ChromeDriver();
        return driver;
    }
    
    public ChromeDriver getChromeDriver() {
    		return driver;
    }

    public static SingletonInstancePage getInstance() {
        if (instance == null) {
            instance = new SingletonInstancePage();
        }
        return instance;
    }

}
