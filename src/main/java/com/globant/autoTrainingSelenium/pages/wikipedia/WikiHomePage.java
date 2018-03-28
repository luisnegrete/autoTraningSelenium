/**
 * 
 */
package com.globant.autoTrainingSelenium.pages.wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.autoTrainingSelenium.pages.BasePage;

/**
 * @author jose.negrete
 *
 */
public class WikiHomePage extends BasePage {
	private static final String URL = "https://es.wikipedia.org/wiki/Wikipedia:Portada"; 

	public WikiHomePage(WebDriver driver) {
		super(driver);
		driver.get(URL);
	}
	
	@FindBy(id = "searchInput")
	WebElement searchInput;
	
	@FindBy(id = "searchButton")
	WebElement searchButton;
	
	
	public WikiArticlePage buscar(String busqueda) {
		searchInput.sendKeys(busqueda);		
		getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		
		return new WikiArticlePage(getDriver());
	}
	

}
