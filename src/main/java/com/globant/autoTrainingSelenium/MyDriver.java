/**
 * 
 */
package com.globant.autoTrainingSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

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
	public MyDriver(String browser, String urlDriver) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", urlDriver);
			
			FirefoxOptions firefoxOptions = new FirefoxOptions(DesiredCapabilities.firefox());
	        firefoxOptions.addPreference("browser.popups.showPopupBlocker", false);
	        firefoxOptions.addPreference("security.sandbox.content.level", 5);
	        firefoxOptions.setAcceptInsecureCerts(true);
	        firefoxOptions.setProfile(new FirefoxProfile());

	        driver = new FirefoxDriver(firefoxOptions);
			
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", urlDriver);
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
