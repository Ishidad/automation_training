package martin_villarruel_automation_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPreviusPage {
	
	@FindBy(id="wp-calendar")
	private WebElement calendarWrapper;
	
	public int findCalendarPosts(){
		List<WebElement> postList = calendarWrapper.findElements(By.tagName("a"));
		postList.get(0).click();
		return postList.size();
	}
}
