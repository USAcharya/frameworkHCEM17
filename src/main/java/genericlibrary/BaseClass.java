package genericlibrary;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompage.ContactUsPage;
import pompage.CoreJavaForSeleniumPage;
import pompage.CoreJavaVideoPage;
import pompage.SeleniumTrainingPage;
import pompage.SkillraryDemoApp;
import pompage.SkillraryHomePage;
import pompage.TestingPage;

public class BaseClass {
	private static final WebDriver driver= null;
	
	protected PropertyFileUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected SkillraryHomePage home;
	protected SkillraryDemoApp skillraryDemo ;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage coreJava;
	protected CoreJavaVideoPage javaVideo;
	protected ContactUsPage contact;
	protected long time;

	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classConfiguration() {
		
	    property = new PropertyFileUtility();
		excel = new ExcelUtility();
		web = new WebDriverUtility();
		
		property.propertyFileInitialization(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
	}
	@BeforeMethod
	public void methodConfiguration() {
		
	    time =Long.parseLong(property.fetchProperty("timeouts"));
	    web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"),time);
		
		home = new  SkillraryHomePage(driver);
		
		Assert.assertTrue(home.getLogo().isDisplayed());
		
		skillraryDemo = new SkillraryDemoApp(driver);
		selenium = new SeleniumTrainingPage(driver);
		coreJava = new CoreJavaForSeleniumPage(driver);
		javaVideo = new CoreJavaVideoPage(driver);
		testing = new TestingPage(driver);
	}
	
	@AfterMethod
	public void methodTearDown() {
		web.quitBrowser();
	}
	
	@AfterClass
	public void classTearDown() {
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite

}
