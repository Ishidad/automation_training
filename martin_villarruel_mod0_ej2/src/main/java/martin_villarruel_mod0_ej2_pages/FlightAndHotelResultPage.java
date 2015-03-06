package martin_villarruel_mod0_ej2_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FlightAndHotelResultPage {

	@FindBy(xpath = "//a[contains(@href, 'rating=4')]")
	private WebElement fourStarsRaiting;

	@FindBy(xpath = "//a[contains(@href, 'rating=5')]")
	private WebElement fiveStarsRaiting;

	@FindBy(xpath = "//div[@data-context='pkgResults']")
	private WebElement searchResults;

	@FindBy(xpath = "//div[@data-context='sortLinksDropDown' and @tabindex='0']")
	private WebElement orderBySelect;

	@FindBy(xpath = "//a[contains(@href, 'HOTEL_STAR')]")
	private WebElement orderByScore;

	// Validations
	@FindBy(xpath = "/html/head/title")
	private WebElement pageTitle;

	@FindBy(xpath = "//li[@data-context='pkg100Tab']")
	private WebElement selectedTab;

	@FindBy(xpath = "//div[@data-context='pkgBreadcrumb']")
	private WebElement mainTitle;

	@FindBy(xpath = "//div[@class='rating']")
	private WebElement starRating;

	@FindBy(xpath = "//div[@class='pkgMatchingResults']")
	private WebElement packageShowing;

	@FindBy(xpath = "//span[@class='reviewRatingBubble']")
	private WebElement validateReviewRating;

	public void orderByFourStars() {
		fourStarsRaiting.click();
	}

	public void orderByFiveStars() {
		fiveStarsRaiting.click();
	}

	public void orderByScore() {
		orderBySelect.click();
		orderByScore.click();
	}

	public void validatePage() {
		Assert.assertNotNull(pageTitle);
		Assert.assertNotNull(selectedTab);
		Assert.assertNotNull(mainTitle);
		Assert.assertNotNull(starRating);
		Assert.assertNotNull(packageShowing);
	}

	public void validateScore() {
		List<WebElement> scoreList = searchResults.findElements(By
				.xpath("//div[@class='pkgResultsCard pkgResultsHotelCard']"));
		int x = 0, listSize = 10;
		while (x < listSize) {
			Assert.assertNotNull(scoreList
					.get(x)
					.findElement(
							By.xpath("//img[@data-context='stars-4' and @alt='4 stars']")));
			x++;
		}
	}

	public void getSelectFirstResult() {
		List<WebElement> resultList = searchResults.findElements(By
				.xpath("//div[@class='pkgResultsCard pkgResultsHotelCard']"));
		resultList
				.get(1)
				.findElement(
						By.xpath("//a[@data-wt-ti='matrixCell-chooseFlight']"))
				.click();
	}
}
