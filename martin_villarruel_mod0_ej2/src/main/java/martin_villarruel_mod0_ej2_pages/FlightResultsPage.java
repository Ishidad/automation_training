package martin_villarruel_mod0_ej2_pages;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	public boolean validatePage() {
		if (pageTitle.isDisplayed() && currentTab.isDisplayed()
				&& tripSummaryTable.isDisplayed()
				&& airResultMatrix.isDisplayed()
				&& searchResultNumber.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void getSelectFirstResult() {
		List<WebElement> list = resutlList.findElements(By
				.xpath("//div[@data-context='airResultsCard']"));
		list.get(0).findElement(By.xpath("//a[@class='buttonLink link']"))
				.click();
	}
	
	public WebElement getResultList(){
		return resutlList;
	}
}
