/**
 * 
 */
package com.globant.autoTrainingSelenium.pages.starbucks;

import java.text.NumberFormat;
import java.text.ParseException;
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
public class CartPage extends BasePage {
	private By byTbody 	= By.tagName("tbody");
	private By byTd 	= By.tagName("td");
	private By byTh 	= By.tagName("th");
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/h1")
	private WebElement pageTitle;
	
	@FindBy(id="cart_form")
	private WebElement cartForm;
	
	@FindBy(id="cart_summary")
	private WebElement cartSummary;
	/**
	 * Constructor por defecto
	 * @param pDriver
	 */
	public CartPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	public String getTitle() {
		getWait().until(ExpectedConditions.elementToBeClickable(pageTitle));
		return pageTitle.getText();
	}
	
	public boolean isCardAdded(String recipientNameValue, String messageValue, int amountValue,
			String recipientEmailValue) {
		boolean answer = false;

		// Obteniendo las tablas de los elementos agregados
		getWait().until(ExpectedConditions.visibilityOf(cartForm));
		List<WebElement> lstAddedItems = cartForm.findElements(byTbody);

		// Iterando sobre los elementos agregados
		for (WebElement item : lstAddedItems) {
			// Obteniendo los campos de cada tarjeta
			List<WebElement> lstFields = item.findElements(byTd);

			String recipientEmailName = null;
			Integer amount = null;
			String message = null;

			for (WebElement field : lstFields) {
				switch (field.getAttribute("data-th") == null ? "": field.getAttribute("data-th")) {
					case "eGift":
						break;
	
					case "Recipient":
						recipientEmailName = field.getText();
						break;
	
					case "Amount":
						NumberFormat format = NumberFormat.getCurrencyInstance();
						try {
							amount = format.parse(field.getText()).intValue();
						} catch (ParseException e) {
							e.printStackTrace();
							amount = 0;
						}
	
						break;
	
					case "Message":
						message = field.getText();
						break;
				}
			}
			
			// Validanso si los datos proporcionados se encuentran en el carrito
			if(recipientEmailName.equals(recipientEmailValue) &&
			   amount.equals(amountValue) &&
			   message.equals(recipientNameValue + "\n" + messageValue)) {
				answer = true;
				break;
			}
			
		}

		return answer;
	}
	
	/**
	 * Método que valida si una tarjeta se encuentra agregada al sumario del carrito de compra
	 * @param selectedCard
	 * @return
	 */
	public boolean isCardInSummary(String selectedCard) {
		boolean answer = false;
		
		// Obteniendo las tablas de los elementos del sumario
		getWait().until(ExpectedConditions.visibilityOf(cartSummary));
		List<WebElement> lstSummaryItems = cartSummary.findElement(byTbody).findElements(byTh);
		
		for (WebElement item : lstSummaryItems) {
			if(("1 " + selectedCard).equals(item.getText())) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}

}
