package martin_villarruel_mod0_ej2_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FlightResultsPage {

	@FindBy(xpath = "/html/head/title")
	private WebElement pageTitle;

	@FindBy(xpath = "//li[@data-context='air100Tab' and @class='currentTab']")
	private WebElement currentTab;

	@FindBy(xpath = "//table[@summary='Your Trip']")
	private WebElement tripSummaryTable;

	@FindBy(xpath = "//div[@class='airResultsMatrixMod ']")
	private WebElement airResultMatrix;

	@FindBy(xpath = "//div[@class='matchingResults']")
	private WebElement searchResultNumber;

	@FindBy(xpath = "//div[@id='main']")
	private WebElement resutlList;

	@FindBy(xpath = "//div[@data-context='selectedSortLink-AIR_PRICE-ascending']")
	private WebElement listOrderDropDown;

	@FindBy(xpath = "//a[@data-wt-ti='airSort-Departure time-ascending']")
	private WebElement listOrderDropDownOption;

	public void validatePage() {
		Assert.assertNotNull(pageTitle);
		Assert.assertNotNull(currentTab);
		Assert.assertNotNull(tripSummaryTable);
		Assert.assertNotNull(airResultMatrix);
		Assert.assertNotNull(searchResultNumber);
	}

	public void orderByErliestDeparture() {
		listOrderDropDown.click();
		listOrderDropDownOption.click();
	}

	public void getSelectFirstResult() {
		List<WebElement> list = resutlList.findElements(By
				.xpath("//div[@data-context='airResultsCard']"));
		list.get(0).findElement(By.xpath("//a[@data-context='selectButton']"))
				.click();
	}

	public WebElement getResultList() {
		return resutlList;
	}
}
