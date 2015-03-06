package martin_villarruel_mod0_ej2_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TripDetailsPage {

	@FindBy(xpath = "/html/head/title")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[@id='preMain']")
	private WebElement tripDetailsTitle;

	@FindBy(xpath = "//div[@class='perk-cards']")
	private WebElement reasonToBook;

	@FindBy(xpath = "//div[@class='productInfo']")
	private WebElement tripInfoSide;

	@FindBy(xpath = "//div[@class='tripDetailsComponent ']")
	private WebElement tripDetailsContent;

	@FindBy(xpath = "//input[@name='_eventId_checkout']")
	private WebElement continueBtn;

	public void validatePage() {
		Assert.assertNotNull(pageTitle);
		Assert.assertNotNull(tripDetailsTitle);
		Assert.assertNotNull(reasonToBook);
		Assert.assertNotNull(tripInfoSide);
		Assert.assertNotNull(tripDetailsContent);
	}

	public WebElement getTripInfo() {
		return tripInfoSide;
	}

	public void clickContinue() {
		continueBtn.click();
	}
}
