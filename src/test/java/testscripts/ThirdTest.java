package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibrary.BaseClass;

public class ThirdTest extends BaseClass {

	@Test
	public void thirdTest() { 
		
	SoftAssert soft= new SoftAssert();
	
	home.searchFor("core java for selenium");
	soft.assertEquals(coreJava.getPageHeader(), "CORE JAVA FOR SELENIUM");
	
	coreJava.ClickCoreJavaForSeleniumLink();
	soft.assertEquals(javaVideo.getPageHeader(), "Core Java For Selenium Training");
	
	javaVideo.clickCloseCookies();
	web.switchToFrame();
	javaVideo.ClickPlayButton();
	Thread.sleep(2000);
	javaVideo.ClickPauseButton();
	web.switchBackFromFrame();
	javaVideo.ClicAddToWishlist();
	
	soft.assertAll();
}
}