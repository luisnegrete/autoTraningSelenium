/**
 * 
 */
package com.globant.autoTrainingSelenium.pages.starbucks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.autoTrainingSelenium.pages.BasePage;

/**
 * @author jose.negrete
 *
 */
public class FindYourCoffeePage extends BasePage {
	private By byH5 = By.tagName("h5");
	private By byButton = By.tagName("button");
	private By byArticle = By.tagName("article");
	
	@FindBy(id="back-top")
	private WebElement lnkBackTop;
	
	@FindBy(id="find-my-coffee")
	private WebElement btnFindMyCoffee;
	
	@FindBy(id="featured-coffees-stack")
	WebElement coffeesStack;
	
	public FindYourCoffeePage(WebDriver pDriver) {
		super(pDriver);
	}
	
	public String getFindYourPerfectCoffee(int q1, int q2, int q3, int q4) {
		// Obteniendo el elemento de acuerdo a la respuesta de la primer pregunta
		
		String idQ3 = null;
		switch (q1) {
		case 0:
			idQ3 = "light-questions";
			break;
		case 1:
			idQ3 = "medium-questions";
			break;
		case 2:
			idQ3 = "dark-questions";
			break;
		}
		
		clickSelectButton("question1", q1);
		clickSelectButton("question2", q2);
		clickSelectButton(idQ3, q3);
		clickSelectButton("question4", q4);
		
		getWait().until(ExpectedConditions.elementToBeClickable(btnFindMyCoffee));
		btnFindMyCoffee.click();

		WebElement selectedArticle = validateSelectedArticle();
		
		
		return selectedArticle.findElement(byH5).getText();
	}

	/**
	 * Metodo que ejecuta el click sobre el elemento seleccionado
	 * @param idElement
	 * @param pIndex
	 */
	private void clickSelectButton(String idElement, Integer pIndex) {
		WebElement webElement = getAnswerByIndex(getDriver().findElement(By.id(idElement)), pIndex);
		getWait().until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click(); 
	}
	
	/**
	 * Obtiene el elemento dependiendo del indice seleccionado
	 * @param pContainer
	 * @param pIndex
	 * @return
	 */
	private WebElement getAnswerByIndex(WebElement pContainer, int pIndex) {
		List<WebElement> lst = pContainer.findElements(byButton);
		return lst.get(pIndex);
	}
	
	/**
	 * M�todo que valida qu� art�culo es el que result�
	 * @return
	 */
	private WebElement validateSelectedArticle() {
		WebElement selectedArticle = null;
		
		
		// Obteniendo todos los art�culos dispobibles
		getWait().until(ExpectedConditions.elementToBeClickable(coffeesStack));
		List<WebElement> lstArticles = coffeesStack.findElements(byArticle);
		for (WebElement webElement : lstArticles) {
			if (webElement.isDisplayed()) {
				selectedArticle = webElement;
				break;
			}
		}
		return selectedArticle;
	}
	
	/**
	 * Selecciona el link Go Back
	 */
	public void selectGoBack() {
		getWait().until(ExpectedConditions.elementToBeClickable(lnkBackTop));
		lnkBackTop.click();
	}
}
