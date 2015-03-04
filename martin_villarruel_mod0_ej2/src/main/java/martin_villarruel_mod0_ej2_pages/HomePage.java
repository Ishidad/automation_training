package martin_villarruel_mod0_ej2_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomePage {
	
	DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();

	@FindBy(id = "headerStandard")
	private WebElement pageHeader;

	@FindBy(xpath = "//li[@class='welcomeText']")
	private WebElement welcomeText;

	@FindBy(xpath = "//a[contains(@href, 'https://www.cheaptickets.com/account/login?destinationUrl=%2F')]")
	private WebElement loginLink;

	@FindBy(xpath = "//a[contains(@href, '/account/logout')]")
	private WebElement logoutLink;

	@FindBy(xpath = "//input[@id='search.type.air']")
	private WebElement flyRadioBtn;

	@FindBy(xpath = "//input[@name='ar.rt.leaveSlice.orig.key']")
	private WebElement originFlyText;

	@FindBy(xpath = "//input[@name='ar.rt.leaveSlice.dest.key']")
	private WebElement destinyFlyText;

	@FindBy(xpath = "//input[@name='ar.rt.leaveSlice.date']")
	private WebElement leaveDateInput;
	
	@FindBy(xpath = "//span[@data-dateindex='5']")
	private WebElement leaveDateAutoInput;

	@FindBy(xpath = "//input[@name='ar.rt.returnSlice.date']")
	private WebElement returnDateInput;
	
	@FindBy(xpath = "//span[@data-dateindex='28']")
	private WebElement returnDateAutoInput;

	@FindBy(xpath = "//select[@name='ar.rt.numAdult']")
	private WebElement adultQntyBtn;

	@FindBy(xpath = "//input[@name='hotel.keyword.key']")
	private WebElement hotelTextBox;

	@FindBy(xpath = "//input[@value='Search Flights']")
	private WebElement searchFlightBtn;

	public void goToPage(WebDriver driver) {
		driver.get("http://www.cheaptickets.com/");
	}

	public void loginIn() {
		loginLink.click();
	}

	public void logOut() {
		logoutLink.click();
	}

	public void checkLoginStatus() {
		welcomeText.getText().contains("Martin Test");
	}

	public void checkLogoutStatus() {
		welcomeText.getText().contains("CheapTickets");
	}

	public void selectFlightOnly() {
		flyRadioBtn.click();
	}

	public void completeFlightInfo() {
		originFlyText.sendKeys("LAS");
		destinyFlyText.sendKeys("LAX");
		leaveDateInput.click();
		leaveDateAutoInput.click();
		returnDateInput.click();
		returnDateAutoInput.click();
		searchFlightBtn.click();
	}
}
