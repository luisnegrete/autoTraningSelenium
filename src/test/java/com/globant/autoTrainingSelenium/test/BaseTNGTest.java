/**
 * 
 */
package com.globant.autoTrainingSelenium.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.globant.autoTrainingSelenium.MyDriver;
import com.globant.autoTrainingSelenium.pages.BasePage;

/**
 * @author jose.negrete
 *
 */
public class BaseTNGTest {
	protected MyDriver myDriver;
	protected BasePage basePage;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser", "urlDriver"})
	public void beforeSuit(String browser, String urlDriver) throws Exception {
		myDriver = new MyDriver(browser, urlDriver);
	}
	
	//@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		basePage.dispose();
	}
	
}
