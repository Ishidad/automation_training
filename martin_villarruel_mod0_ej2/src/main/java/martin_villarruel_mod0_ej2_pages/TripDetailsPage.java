package martin_villarruel_mod0_ej2_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	public boolean validatePage() {
		if (pageTitle.isDisplayed() && tripDetailsTitle.isDisplayed()
				&& reasonToBook.isDisplayed()
				&& tripInfoSide.isDisplayed()
				&& tripDetailsContent.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
}
