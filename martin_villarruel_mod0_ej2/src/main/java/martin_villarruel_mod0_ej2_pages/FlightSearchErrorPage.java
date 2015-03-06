package martin_villarruel_mod0_ej2_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FlightSearchErrorPage {

	@FindBy(xpath = "//div[@class='disambiguate']")
	private WebElement mainTitleErrorText;

	@FindBy(xpath = "//form[@novalidate= 'novalidate']")
	private WebElement cityAirportVerification;

	public void validatePage() {
		Assert.assertNotNull(mainTitleErrorText);
		Assert.assertNotNull(cityAirportVerification);
		Assert.assertTrue(mainTitleErrorText.getText().contains(
				"We need more information about your trip."));
	}
}
