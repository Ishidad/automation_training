package martin_villarruel_automation_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage {
	
	@FindBy(id="content")
	private WebElement postContent;
	
	public String getDateFromPost(){
		String date = postContent.findElement(By.tagName("time")).getText();
		return date;
	}
}
