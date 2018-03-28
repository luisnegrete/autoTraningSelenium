/**
 * 
 */
package com.globant.autoTrainingSelenium.pages.starbucks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.autoTrainingSelenium.pages.BasePage;

/**
 * @author jose.negrete
 *
 */
public class CartPage extends BasePage {
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/h1")
	private WebElement pageTitle;

	public CartPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	public String getTitle() {
		getWait().until(ExpectedConditions.elementToBeClickable(pageTitle));
		return pageTitle.getText();
	}

}
