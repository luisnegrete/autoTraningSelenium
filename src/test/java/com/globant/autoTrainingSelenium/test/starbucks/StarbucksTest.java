/**
 * 
 */
package com.globant.autoTrainingSelenium.test.starbucks;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globant.autoTrainingSelenium.pages.starbucks.CartPage;
import com.globant.autoTrainingSelenium.pages.starbucks.FindYourCoffeePage;
import com.globant.autoTrainingSelenium.pages.starbucks.StarbucksHomePage;
import com.globant.autoTrainingSelenium.test.BaseTNGTest;

/**
 * @author jose.negrete
 *
 */
public class StarbucksTest extends BaseTNGTest {
	private StarbucksHomePage starbucksHomePage;
	
	@Test
	public void test1() {
		starbucksHomePage = new StarbucksHomePage(myDriver.getDriver());
		Assert.assertEquals(starbucksHomePage.getMnuCoffee().getText(), 			"COFFEE");
		Assert.assertEquals(starbucksHomePage.getMnuTea().getText(), 				"TEA");
		Assert.assertEquals(starbucksHomePage.getMnuMenu().getText(), 				"MENU");
		Assert.assertEquals(starbucksHomePage.getMnuCoffeeHouse().getText(), 		"COFFEEHOUSE");
		Assert.assertEquals(starbucksHomePage.getMnuSocialImpact().getText(), 		"SOCIAL IMPACT");
		Assert.assertEquals(starbucksHomePage.getMnuStarbucksRewards().getText(),	"STARBUCKS REWARDS");
		Assert.assertEquals(starbucksHomePage.getMnuBlog().getText(), 				"BLOG");
		Assert.assertEquals(starbucksHomePage.getMnuGiftCards().getText(), 			"GIFT CARDS");
	}
	
	@DataProvider(name="providerTest2")
	public Object[][] createData1() {
		return new Object[][] { 
				{ new Integer(2), new Integer(1), new Integer(2), new Integer(1),"EARTHY & HERBAL" },
				{ new Integer(0), new Integer(0), new Integer(0), new Integer(0),"MELLOW & SOFT" },
				{ new Integer(1), new Integer(2), new Integer(0), new Integer(1),"SMOOTH & BALANCED" },
				{ new Integer(0), new Integer(1), new Integer(1), new Integer(0),"MELLOW & SOFT" }, 
			};
	}

	
	@Test(dataProvider = "providerTest2")
	public void test2(Integer q1, Integer q2, Integer q3, Integer q4, String resultado) {
		starbucksHomePage = new StarbucksHomePage(myDriver.getDriver());
		// Obteniendo la p�gina de 'Find your perfect Coffee
		FindYourCoffeePage findYourCoffeePage = starbucksHomePage.getFindYourCoffeePage();
		
		// Verificando que el resultado dependiendo de los par�metros.
		Assert.assertEquals(findYourCoffeePage.getFindYourPerfectCoffee(q1,q2,q3,q4), resultado);
	}
	
	
	@DataProvider(name="providerTest3")
	public Object[][] createData2() {
		return new Object[][] { 
				{ "Spring", 0,"JL", "Spring Message",50,"JL", "recipientSpring@email.com","senderSpring@email.com", "Spring Flowers"},
				{ "Birthday", 1,"JL", "Birthday Message",100,"JL", "recipientBirthday@email.com","senderBirthday@email.com","HBD"},
				{ "Friendship", 3,"JL", "Friendship Message",10,"JL", "recipientFriendship@email.com","senderFriendship@email.com","Thinking of You"},
			};
	}
	
	
	@Test(dataProvider = "providerTest3")
	public void test3(String categorie,int carruselItem, String recipientNameValue, String messageValue, int amountValue,
			String senderNameValue, String recipientEmailValue, String senderEmailValue, String selectedCard) {
		starbucksHomePage = new StarbucksHomePage(myDriver.getDriver());

		// Obteniendo el carrito de compra una vez agregada un Card
		CartPage cartPage = starbucksHomePage.getGiveGiftCardByEmailPage().addGiftCardPage(categorie).addToCart(
				carruselItem, recipientNameValue, messageValue, amountValue, senderNameValue, recipientEmailValue,
				senderEmailValue);
		
		Assert.assertTrue(cartPage.isCardAdded(recipientNameValue, messageValue, amountValue, recipientEmailValue));
		// Verificando que el resultado dependiendo de los par�metros.
		Assert.assertTrue(cartPage.isCardInSummary(selectedCard, amountValue));
	}
	
	
	@AfterTest(alwaysRun=true)
	public void restartTest() {
		basePage = starbucksHomePage;
	}
	
}
