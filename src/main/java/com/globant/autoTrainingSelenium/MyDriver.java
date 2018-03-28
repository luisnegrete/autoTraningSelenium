/**
 * 
 */
package com.globant.autoTrainingSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author jose.negrete
 *
 */
public class MyDriver {
	
	private WebDriver driver;

	/**
	 * Constructor que genera la instancia del WebDriver dependiendo del navegador solicitado
	 * @param browser
	 */
	public MyDriver(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\jose.negrete\\driversTesting\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jose.negrete\\driversTesting\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
	}

	/**
	 * Obtiene la instancia del WebDriver
	 * @return driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

}
