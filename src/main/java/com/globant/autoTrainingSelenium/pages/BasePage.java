/**
 * 
 */
package com.globant.autoTrainingSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author jose.negrete
 *
 */
public class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	/**
	 * Constructor del BasePage a partir de un WebDriver determinado
	 * @param pDriver
	 */
	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		
		driver = pDriver;		
		wait = new WebDriverWait(driver, 100);
	}
	
	/**
	 * Obtiene el WebDriver
	 * @return
	 */
	protected WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Libera los recursos del WebDriver
	 */
	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriverWait getWait() {
		return wait;
	}

}
