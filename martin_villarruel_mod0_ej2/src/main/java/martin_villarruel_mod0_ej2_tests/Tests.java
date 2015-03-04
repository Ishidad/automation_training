package martin_villarruel_mod0_ej2_tests;

import java.util.concurrent.TimeUnit;

import martin_villarruel_mod0_ej2_pages.CustomizeTripPage;
import martin_villarruel_mod0_ej2_pages.FlightResultsPage;
import martin_villarruel_mod0_ej2_pages.HomePage;
import martin_villarruel_mod0_ej2_pages.LogInPage;
import martin_villarruel_mod0_ej2_pages.TravelerInfoPage;
import martin_villarruel_mod0_ej2_pages.TripDetailsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
	
	public void pausa(int s) {
		 try {
		 	Thread.sleep(s*1000);
		 } catch (InterruptedException e) {
		 	// TODO Auto-generated catch block
		 	//e.printStackTrace();
		 }
		}

	@BeforeMethod
	public void before(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void after(){
		driver.close();
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
		homePage.completeFlightInfo();		
		pausa(30);
		FlightResultsPage flightSearchPage = PageFactory.initElements(driver, FlightResultsPage.class);
		flightSearchPage.validatePage();
		flightSearchPage.orderByErliestDeparture();
		pausa(10);
		flightSearchPage.getSelectFirstResult();
		pausa(30);
		TripDetailsPage tripDetailsPage = PageFactory.initElements(driver, TripDetailsPage.class);
		tripDetailsPage.validatePage();
		WebElement tripInfo = tripDetailsPage.getTripInfo();
		tripDetailsPage.clickContinue();
		pausa(15);
		CustomizeTripPage customTrip = PageFactory.initElements(driver, CustomizeTripPage.class);
		customTrip.checkTripInfo(tripInfo);
		customTrip.clickContinue();
		pausa(15);
		TravelerInfoPage travelInfo = PageFactory.initElements(driver, TravelerInfoPage.class);
		travelInfo.checkTripInfo(tripInfo);
		travelInfo.fillTravelerInfo("martin", "villarruel", "1234567890", "false@mail.com");
		travelInfo.clickContinue();
	}
}
