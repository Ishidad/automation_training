package martin_villarruel_mod0_ej2_tests;

import java.util.concurrent.TimeUnit;

import martin_villarruel_mod0_ej2_pages.FlightResultsPage;
import martin_villarruel_mod0_ej2_pages.HomePage;
import martin_villarruel_mod0_ej2_pages.LogInPage;
import martin_villarruel_mod0_ej2_pages.TripDetailsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
	
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void before(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void after(){
		driver.quit();
	}
	
//	@Test
//	public void singIn(){
//		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//		homePage.goToPage(driver);
//		homePage.loginIn();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
//		loginPage.fillLogIn("m.villarruel.test@gmail.com", "Automation");
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		homePage.checkLoginStatus();
//	}
//	
//	@Test
//	public void logOut(){
//		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//		homePage.goToPage(driver);
//		homePage.loginIn();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
//		loginPage.fillLogIn("m.villarruel.test@gmail.com", "Automation");
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		homePage.checkLogoutStatus();		
//	}
//	
//	@Test
//	public void verifyWrongMail(){
//		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
//		loginPage.goToPage(driver);
//		loginPage.fillLogIn("asdsad", "Automation");
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		loginPage.checkForErrorMessage();
//	}
//	
//	@Test
//	public void verifyWrongPass(){
//		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
//		loginPage.goToPage(driver);
//		loginPage.fillLogIn("m.villarruel.test@gmail.com", "asdadad");
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		loginPage.checkForErrorMessage();
//	}
	
	@Test
	public void searchForFly(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToPage(driver);
		homePage.selectFlightOnly();
		homePage.completeFlightInfo("03/11/15", "03/20/15");		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//		FlightResultsPage flightSearchPage = PageFactory.initElements(driver, FlightResultsPage.class);
//		wait.until(ExpectedConditions.visibilityOf(flightSearchPage.getResultList()));;
//		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//		Assert.assertTrue(flightSearchPage.validatePage());
//		flightSearchPage.getSelectFirstResult();
//		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
//		TripDetailsPage tripDetailsPage = PageFactory.initElements(driver, TripDetailsPage.class);
//		Assert.assertTrue(tripDetailsPage.validatePage());
	}
}
