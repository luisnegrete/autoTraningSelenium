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
public class AddGiftCardPage extends BasePage {
	private By byLi = By.tagName("li");
	private By byLabel = By.tagName("label");
	
	@FindBy(id="carousel-scrollable")
	private WebElement carrusel;
	
	@FindBy(xpath="//*[@id=\"ecardform\"]/div[3]/span/button")
	private WebElement btnAddToCart; 
	
	@FindBy(id="recipient_name")
	private WebElement recipientName;
	
	@FindBy(id="message")
	private WebElement message;
	
	@FindBy(id="pre_range")
	private WebElement preRange;
	
	@FindBy(id="sender_name")
	private WebElement sendername;
	
	@FindBy(id="recipient_email")
	private WebElement recipientEmail;
	
	@FindBy(id="sender_email")
	private WebElement senderEmail;
	
	
	public AddGiftCardPage(WebDriver pDriver) {
		super(pDriver);
	}

	/**
	 * Médoto que llena el formulario de tarjeta y lo agrega el carrito
	 * @param carruselItem
	 * @param recipientNameValue
	 * @param messageValue
	 * @param amountValue
	 * @param senderNameValue
	 * @param recipientEmailValue
	 * @param senderEmailValue
	 * @return
	 */
	public CartPage addToCart(int carruselItem, String recipientNameValue, String messageValue, int amountValue,
			String senderNameValue, String recipientEmailValue, String senderEmailValue) {
		
		fillCardFields(carruselItem, recipientNameValue, messageValue, amountValue, senderNameValue, recipientEmailValue, senderEmailValue);
		
		// Seleccionando el botón Add to Cart
		getWait().until(ExpectedConditions.elementToBeClickable(btnAddToCart));
		btnAddToCart.click();
		
		return new CartPage(getDriver());
	}
	
	/**
	 * Método que llena los campos del formulario de la tarjeta
	 * @param carruselItem
	 * @param recipientNameValue
	 * @param messageValue
	 * @param amountValue
	 * @param senderNameValue
	 * @param recipientEmailValue
	 * @param senderEmailValue
	 */
	private void fillCardFields(int carruselItem, String recipientNameValue, String messageValue, int amountValue,
			String senderNameValue, String recipientEmailValue, String senderEmailValue) {
		
		// Seleccionando tipo de Card
		getWait().until(ExpectedConditions.visibilityOf(carrusel));
		List<WebElement> lstCardType = carrusel.findElements(byLi);
		getWait().until(ExpectedConditions.elementToBeClickable(lstCardType.get(carruselItem)));
		lstCardType.get(carruselItem).click();
		
		// Llenando el recipientName
		getWait().until(ExpectedConditions.visibilityOf(recipientName));
		recipientName.sendKeys(recipientNameValue);
		
		// Llenando el message
		getWait().until(ExpectedConditions.visibilityOf(message));
		message.sendKeys(messageValue);
		
		// Seleccionando el monto
		WebElement amount = selectAmount(amountValue);
		getWait().until(ExpectedConditions.elementToBeClickable(amount));
		amount.click();
		
		// Llenando el senderName
		getWait().until(ExpectedConditions.visibilityOf(sendername));
		sendername.sendKeys(senderNameValue);
		
		// Llenando el recipientEmail
		getWait().until(ExpectedConditions.visibilityOf(recipientEmail));
		recipientEmail.sendKeys(recipientEmailValue);
		
		// Llenando el senderEmail
		getWait().until(ExpectedConditions.visibilityOf(senderEmail));
		senderEmail.sendKeys(senderEmailValue);
	}
	
	/**
	 * Método que selecciona el monto de la tarjeta
	 * @param amountValue
	 * @return
	 */
	private WebElement selectAmount(int amountValue) {
		WebElement amount = null;
		String idAmount = "defined-amount_" + amountValue;
	    List<WebElement> lstAmounts = preRange.findElements(byLabel);
	    
	    for (WebElement item : lstAmounts) {
			if(idAmount.equals(item.getAttribute("for"))) {
				amount = item;
				break;
			}
		}
	    
		return amount;
	}
}
