package martin_villarruel_automation_pages_tests;

import java.util.concurrent.TimeUnit;

import martin_villarruel_automation_pages.ContactUsPage;
import martin_villarruel_automation_pages.HomePage;
import martin_villarruel_automation_pages.PostPage;
import martin_villarruel_automation_pages.SearchResultPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void before(){

		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		System.setProperty("webdriver.ie.driver", "C://Users//martin.villarruel//Desktop//eclipse//IEDriverServer.exe"); //path driver IEDriver.exe
		driver = new InternetExplorerDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void after(){
		driver.quit();
	}
	
//	@Test()
//	public void validatePageTittle(){
//		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//		homePage.goToPage(driver);
//		Assert.assertEquals(driver.getTitle(), HomePage.HOME_PAGE_TITLE, "Title Error");
//		
//	}
//	
//	@Test()
//	public void pageSearch(){
//		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//		SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		homePage.goToPage(driver);
//		homePage.search("dog");		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("post-0")));
//		System.out.println(searchResultPage.getNoResults());
//		Assert.assertEquals(searchResultPage.getNoResults().contains("Nothing Found"), true,  "There are search results");
//	}
//	
//	@Test()
//	public void verifyPostDate(){
//		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//		homePage.goToPage(driver);
//		PostPage postPage = PageFactory.initElements(driver, PostPage.class);
//		Assert.assertEquals(postPage.getDateFromPost(), homePage.getDateFromPost(), "The date is incorrect");
//	}
//	
//	@Test()
//	public void contactUsFormComplete(){
//		ContactUsPage contactPage = PageFactory.initElements(driver, ContactUsPage.class);
//		contactPage.goToPage(driver);
//		contactPage.completeForm("martin", "my@mail.com", "Hola", "Hello World");
//		Assert.assertEquals(contactPage.getFormSubmitComfirmation(), "Thank you for contacting us.", "The form didn't submit correctly");
//	}
//	
	@Test()
	public void contactUsFormIncomplete(){
		ContactUsPage contactPage = PageFactory.initElements(driver, ContactUsPage.class);
		contactPage.goToPage(driver);
		contactPage.incompleteForm("my@mail.com", "Hola");
		System.out.println(contactPage.getFormErrorMessage());
		if(contactPage.getFormErrorMessage() == true){
			contactPage.fillIncompleteForm("martin", "Hello World");
			Assert.assertEquals(contactPage.getFormSubmitComfirmation(), "Thank you for contacting us.", "The form didn't submit correctly");
		}
		else{
			System.out.println("Fail");
		}
		
	}
	
//	@Test()
//	public void howManyCalendarPostByDate(){
//		
//	}
}
