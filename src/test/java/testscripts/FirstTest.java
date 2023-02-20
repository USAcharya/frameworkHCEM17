package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibrary.BaseClass;

public class FirstTest extends BaseClass {
	
	@Test
	public void firstTest() {
		SoftAssert soft = new SoftAssert();
		
		home.clickGears();
		home.clickSkillrarydemoApp();
		web.handleChildBrowser();
		
		soft.assertTrue(skillraryDemo.getPageHeader().isDisplayed());
		
		skillraryDemo.mouseHoverToCourse(web);
		skillraryDemo.ClickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
		selenium.doubleClickPlusButton(web);
		selenium.clickAddToCart();
		web.handleAlert();
		web.explicitWait(time, selenium.getItemAddedMessage());
		web.takeScreenshot();
		soft.assertTrue(selenium.getItemAddedMessage().isDisplayed());
		
		soft.assertAll();
		
	}
	

}
