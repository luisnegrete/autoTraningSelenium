/**
 * 
 */
package com.globant.autoTrainingSelenium.test.wikipedia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globant.autoTrainingSelenium.pages.wikipedia.WikiArticlePage;
import com.globant.autoTrainingSelenium.pages.wikipedia.WikiHomePage;
import com.globant.autoTrainingSelenium.test.BaseJUnitTest;

/**
 * @author jose.negrete
 *
 */
public class WikiJUnitTests extends BaseJUnitTest{

	

	@Test
	public void testWikiSearch() {
		WikiHomePage wikiHomePage = getWikiHomePage();
		WikiArticlePage articlePage = wikiHomePage.buscar("Java");
		
		assertEquals(articlePage.getTitle(), "Java");
	}

}
