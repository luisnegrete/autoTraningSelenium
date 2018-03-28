/**
 * 
 */
package com.globant.autoTrainingSelenium.pages.wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.autoTrainingSelenium.pages.BasePage;

/**
 * @author jose.negrete
 *
 */
public class WikiArticlePage extends BasePage {

	public WikiArticlePage(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy (id = "firstHeading")
	WebElement pageTitle;
	
	@FindBy (linkText = "API Java")
	WebElement javaLink;
	
	public String getTitle() {
		return pageTitle.getText();
	}

}
