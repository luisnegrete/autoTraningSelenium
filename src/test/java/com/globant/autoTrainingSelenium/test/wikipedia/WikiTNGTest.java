/**
 * 
 */
package com.globant.autoTrainingSelenium.test.wikipedia;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.globant.autoTrainingSelenium.pages.wikipedia.WikiArticlePage;
import com.globant.autoTrainingSelenium.pages.wikipedia.WikiHomePage;
import com.globant.autoTrainingSelenium.test.BaseTNGTest;

/**
 * @author jose.negrete
 *
 */
public class WikiTNGTest extends BaseTNGTest {

	public WikiHomePage getWikiHomePage() {
		WikiHomePage wikiHomePage = new WikiHomePage(myDriver.getDriver()); 
		basePage  = wikiHomePage;
		return wikiHomePage;
	}
	
	@Test(groups = {"wiki"})
	public void testWikiSearch() {
		WikiHomePage wikiHomePage = getWikiHomePage();
		WikiArticlePage articlePage = wikiHomePage.buscar("Java");
		
		Assert.assertEquals(articlePage.getTitle(), "Java");
	}
}
