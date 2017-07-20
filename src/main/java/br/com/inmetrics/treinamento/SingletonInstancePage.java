package br.com.inmetrics.treinamento;

import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonInstancePage {

    private static SingletonInstancePage instance = null;
    private ChromeDriver driver;

    private SingletonInstancePage(){

    }

    public ChromeDriver openBrowser() {
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
