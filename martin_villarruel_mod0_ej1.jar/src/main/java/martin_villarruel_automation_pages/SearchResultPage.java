package martin_villarruel_automation_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {
	
	@FindBy(id="post-0")
	private WebElement noneSearchResults;
	
	@FindBy(id="content")
	private WebElement searchResultElemet;
	
	@FindBy(id="site-title")
	private WebElement pageTitle;
	
	public void goToPage(WebDriver driver){
		driver.get("http://10.28.148.127/wordpress/?s=dog&submit=Search");
	}

	public WebElement searchResult(){
		return searchResultElemet;
	}
	
	public String getNoResults(){		
		return noneSearchResults.getText();		
	}
	
	public String getPageTitleText(){
		return pageTitle.getText();
	}
}
