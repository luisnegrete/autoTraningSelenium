/**
 * 
 */
package com.globant.autoTrainingSelenium.pages.starbucks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.autoTrainingSelenium.pages.BasePage;

/**
 * @author jose.negrete
 *
 */
public class EGiftCardPage extends BasePage {
	private By byCategories = By.id("egift-categories");
	private By byLi = By.tagName("li");
	private By bySpan = By.tagName("span");
	

	public EGiftCardPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	/**
	 * Método que selecciona un tipo de Card
	 * @param categorie
	 * @return
	 */
	public AddGiftCardPage addGiftCardPage(String categorie) {
		WebElement card = null;
		// Buscando el Card por categoria
		List<WebElement> lstCategorias = getDriver().findElement(byCategories).findElements(byLi);
		for (WebElement item : lstCategorias) {
			if(categorie.equals(item.findElement(bySpan).getText())) {
				card = item;
				break;
			}
		}
		
		getWait().until(ExpectedConditions.elementToBeClickable(card));
		card.click();
		
		return new AddGiftCardPage(getDriver());
	}

}
