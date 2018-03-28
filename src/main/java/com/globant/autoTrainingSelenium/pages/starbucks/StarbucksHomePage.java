/**
 * 
 */
package com.globant.autoTrainingSelenium.pages.starbucks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.autoTrainingSelenium.pages.BasePage;

/**
 * @author jose.negrete
 *
 */
public class StarbucksHomePage extends BasePage {
	private static final String URL = "https://www.starbucks.com/";
	
	private By byLinkFindPerfectCoffee = By.partialLinkText("Find Your Perfect Coffee");
	private By byLinkGiftCardByEmail   = By.partialLinkText("Give a Gift by Email");

	@FindBy(xpath= "//*[@id=\"nav_coffee\"]/a/strong")
	WebElement mnuCoffee;
	
	@FindBy(xpath= "//*[@id=\"nav_menudrinkstea\"]/a/strong")
	WebElement mnuTea;
	
	@FindBy(xpath= "//*[@id=\"nav_menu\"]/a/strong")
	WebElement mnuMenu;
	
	@FindBy(xpath= "//*[@id=\"nav_coffeehouse\"]/a/strong")
	WebElement mnuCoffeeHouse;
	
	@FindBy(xpath= "//*[@id=\"nav_responsibility\"]/a/strong")
	WebElement mnuSocialImpact;
	
	@FindBy(xpath= "//*[@id=\"nav_starbucks_rewards\"]/a/strong")
	WebElement mnuStarbucksRewards;
	
	@FindBy(xpath= "//*[@id=\"nav_blog\"]/a/strong")
	WebElement mnuBlog;
	
	@FindBy(xpath= "//*[@id=\"nav_gift_cards\"]/a/strong")
	WebElement mnuGiftCards;
	
	
	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		driver.get(URL);
	}

	public WebElement getMnuCoffee() {
		return mnuCoffee;
	}

	public static String getUrl() {
		return URL;
	}

	public WebElement getMnuTea() {
		return mnuTea;
	}

	public WebElement getMnuMenu() {
		return mnuMenu;
	}

	public WebElement getMnuCoffeeHouse() {
		return mnuCoffeeHouse;
	}

	public WebElement getMnuSocialImpact() {
		return mnuSocialImpact;
	}

	public WebElement getMnuStarbucksRewards() {
		return mnuStarbucksRewards;
	}

	public WebElement getMnuGiftCards() {
		return mnuGiftCards;
	}

	public WebElement getMnuBlog() {
		return mnuBlog;
	}
	
	/**
	 * M&eacute;todo que obtiene la p&aacute;gina de Find your Coffee 
	 * @return FindYourCoffeePage
	 */
	public FindYourCoffeePage getFindYourCoffeePage() {
		Actions mouseOver = new Actions(getDriver());
		// Desplegando el menú COFFEE
		mouseOver.moveToElement(mnuCoffee).build().perform();
		
		// Buscando el elemento 'Find your perfect Coffee'
		WebElement findYourPerfectChoice = getDriver().findElement(byLinkFindPerfectCoffee);
		getWait().until(ExpectedConditions.elementToBeClickable(findYourPerfectChoice));
		findYourPerfectChoice.click();
		
		return new FindYourCoffeePage(getDriver());
	}
	
	/**
	 * M&eacute;todo que obtiene la p&aacute;gina de Giver a Gift Card By Email
	 * @return EGiftCardPage
	 */
	public EGiftCardPage getGiveGiftCardByEmailPage() {
		Actions mouseOver = new Actions(getDriver());
		// Desplegando el menú COFFEE
		mouseOver.moveToElement(mnuGiftCards).build().perform();
		
		// Buscando el elemento 'Find your perfect Coffee'
		WebElement giveGiftCard = getDriver().findElement(byLinkGiftCardByEmail);
		getWait().until(ExpectedConditions.elementToBeClickable(giveGiftCard));
		giveGiftCard.click();
		
		return new EGiftCardPage(getDriver());
	}
}
