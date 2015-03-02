package martin_villarruel_automation_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarDayPage {
	
	@FindBy(id="content")
	private WebElement homePagePostsContent;
	
	public int getArticlesList(){		
		List<WebElement> articleList = homePagePostsContent.findElements(By.tagName("article"));
		for(WebElement articles : articleList){
			System.out.println(articles.findElement(By.tagName("a")).getText());
		}
		return articleList.size();
	}
}
