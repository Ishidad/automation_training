package martin_villarruel_mod0_ej2_tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import martin_villarruel_mod0_ej2_pages.CustomizeTripPage;
import martin_villarruel_mod0_ej2_pages.FlightAndHotelResultPage;
import martin_villarruel_mod0_ej2_pages.FlightResultsPage;
import martin_villarruel_mod0_ej2_pages.FlightSearchErrorPage;
import martin_villarruel_mod0_ej2_pages.HomePage;
import martin_villarruel_mod0_ej2_pages.LogInPage;
import martin_villarruel_mod0_ej2_pages.PackageVerificationPage;
import martin_villarruel_mod0_ej2_pages.TravelerInfoPage;
import martin_villarruel_mod0_ej2_pages.TripDetailsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tests {
	WebDriver driver;
	WebDriverWait wait;

	public void pause(int s) {
		try {
			Thread.sleep(s * 1000);
		} catch (InterruptedException e) {
		}
	}

	@BeforeMethod
	@Parameters("browser")
	public void before(String browser) throws MalformedURLException {
		System.out.println(browser);
		if(browser.equals("FF")){
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), capability);
		}
		if(browser.equals("CH")){
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		System.setProperty("webdriver.chrome.driver",
				"C://Users//martin.villarruel//Desktop//eclipse//chromedriver.exe");
		driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), capability);
		}
		if(browser.equals("IE")){
		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		System.setProperty("webdriver.ie.driver",
				   "C://Users//martin.villarruel//Desktop//eclipse//IEDriverServer.exe");
		driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), capability);   
		}
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		

		driver.get("http://www.cheaptickets.com/");
		Reporter.log("Se Entro a la Pagina Correctamente\n");
	}

	@AfterMethod
	public void after() {
		driver.close();
	}

	@Test
	public void singIn() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToPage(driver);
		homePage.loginIn();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		loginPage.fillLogIn("m.villarruel.test@gmail.com", "Automation");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		homePage.checkLoginStatus();
	}

	@Test
	public void logOut() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToPage(driver);
		homePage.loginIn();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		loginPage.fillLogIn("m.villarruel.test@gmail.com", "Automation");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		homePage.checkLogoutStatus();
	}

	@Test
	public void verifyWrongMail() {
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		loginPage.goToPage(driver);
		pause(15);
		loginPage.fillLogIn("asdsad", "Automation");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		loginPage.checkForErrorMessage();
	}

	@Test
	public void verifyWrongPass() {
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		loginPage.goToPage(driver);
		pause(15);
		loginPage.fillLogIn("m.villarruel.test@gmail.com", "asdadad");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		loginPage.checkForErrorMessage();
	}

	@Test
	public void searchForFly() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToPage(driver);
		pause(15);
		homePage.selectFlightOnly();
		homePage.completeFlightInfo();
		pause(30);
		FlightResultsPage flightSearchPage = PageFactory.initElements(driver,
				FlightResultsPage.class);
		flightSearchPage.validatePage();
		flightSearchPage.orderByErliestDeparture();
		pause(10);
		flightSearchPage.getSelectFirstResult();
		pause(30);
		TripDetailsPage tripDetailsPage = PageFactory.initElements(driver,
				TripDetailsPage.class);
		tripDetailsPage.validatePage();
		WebElement tripInfo = tripDetailsPage.getTripInfo();
		tripDetailsPage.clickContinue();
		pause(15);
		CustomizeTripPage customTrip = PageFactory.initElements(driver,
				CustomizeTripPage.class);
		customTrip.checkTripInfo(tripInfo);
		customTrip.clickContinue();
		pause(15);
		TravelerInfoPage travelInfo = PageFactory.initElements(driver,
				TravelerInfoPage.class);
		travelInfo.checkTripInfo(tripInfo);
		travelInfo.fillTravelerInfo("martin", "villarruel", "1234567890",
				"false@mail.com");
		travelInfo.clickContinue();
	}

	@Test
	public void negativeSearchResults1() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToPage(driver);
		pause(15);
		homePage.selectFlightOnly();
		homePage.completeWrongFlightInfo1();
		pause(30);
		homePage.checkForErrorMsg();
	}

	@Test
	public void negativeSearchResults2() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToPage(driver);
		pause(15);
		homePage.selectFlightOnly();
		homePage.completeWrongFlightInfo2();
		pause(20);
		FlightSearchErrorPage flyErrorPage = PageFactory.initElements(driver,
				FlightSearchErrorPage.class);
		flyErrorPage.validatePage();
	}

	@Test
	public void positiveSearchResults() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToPage(driver);
		pause(15);
		homePage.selectFlightOnly();
		homePage.completeFlightInfo();
		pause(30);
		FlightResultsPage flightSearchPage = PageFactory.initElements(driver,
				FlightResultsPage.class);
		flightSearchPage.validatePage();
	}

	@Test
	public void logedInFlightSearch() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToPage(driver);
		pause(15);
		homePage.loginIn();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		loginPage.fillLogIn("m.villarruel.test@gmail.com", "Automation");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		homePage.selectFlightOnly();
		homePage.completeFlightInfo();
		pause(30);
		FlightResultsPage flightSearchPage = PageFactory.initElements(driver,
				FlightResultsPage.class);
		flightSearchPage.validatePage();
		flightSearchPage.orderByErliestDeparture();
		pause(10);
		flightSearchPage.getSelectFirstResult();
		pause(30);
		TripDetailsPage tripDetailsPage = PageFactory.initElements(driver,
				TripDetailsPage.class);
		tripDetailsPage.validatePage();
		WebElement tripInfo = tripDetailsPage.getTripInfo();
		tripDetailsPage.clickContinue();
		pause(15);
		CustomizeTripPage customTrip = PageFactory.initElements(driver,
				CustomizeTripPage.class);
		customTrip.checkTripInfo(tripInfo);
		customTrip.clickContinue();
		pause(15);
		TravelerInfoPage travelInfo = PageFactory.initElements(driver,
				TravelerInfoPage.class);
		travelInfo.checkTripInfo(tripInfo);
		travelInfo.fillLoginTravelerInfo("1234567890", "false@mail.com");
		travelInfo.clickContinue();
	}

	@Test
	public void searchForFlyAndHotel() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToPage(driver);
		pause(15);
		homePage.selectFlightAndHotel();
		pause(10);
		homePage.completeFlightAndHotelInfo();
		pause(30);
		FlightAndHotelResultPage flightHotelSearchPage = PageFactory
				.initElements(driver, FlightAndHotelResultPage.class);
		flightHotelSearchPage.validatePage();
		flightHotelSearchPage.orderByFourStars();
		pause(15);
		flightHotelSearchPage.orderByScore();
		pause(10);
		flightHotelSearchPage.validateScore();
		flightHotelSearchPage.getSelectFirstResult();
		pause(30);
		PackageVerificationPage packageDetailsPage = PageFactory.initElements(
				driver, PackageVerificationPage.class);
		packageDetailsPage.clickContinueBtn();
		TripDetailsPage tripDetailsPage = PageFactory.initElements(driver,
				TripDetailsPage.class);
		tripDetailsPage.validatePage();
	}
}
