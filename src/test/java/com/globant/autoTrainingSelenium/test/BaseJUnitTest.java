/**
 * 
 */
package com.globant.autoTrainingSelenium.test;

import org.junit.After;
import org.junit.Before;

import com.globant.autoTrainingSelenium.MyDriver;
import com.globant.autoTrainingSelenium.pages.wikipedia.WikiHomePage;

/**
 * @author jose.negrete
 *
 */
public class BaseJUnitTest {
	
	MyDriver myDriver;
	
	private WikiHomePage wikiHomePage;
	
	@Before
	public void setUp() throws Exception {
		myDriver = new MyDriver("chrome");
		wikiHomePage = new WikiHomePage(myDriver.getDriver());
	}
	
	@After
	public void afterSuite() {
		wikiHomePage.dispose();
	}
	
	public WikiHomePage getWikiHomePage() {
		return wikiHomePage;
	}

}
