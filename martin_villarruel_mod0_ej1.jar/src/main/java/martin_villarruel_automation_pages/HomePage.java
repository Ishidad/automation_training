package martin_villarruel_automation_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	public static final String HOME_PAGE_TITLE = "Automation Training | Aprender a automatizar en un solo sitio";
	
	@FindBy(id="s")
	private WebElement searchInput;
	
	@FindBy(id="site-title")
	private WebElement pageTitle;
	
	@FindBy(id="content")
	private WebElement homePagePostsContent;
	
	@FindBy(id="prev")
	private WebElement previousCalendarBtn;
	
	@FindBy(id="wp-calendar")
	private WebElement calendarWrapper;
	
	public void goToPage(WebDriver driver){
		driver.get("http://10.28.148.127/wordpress/");
	}
	
	public void search(String query){
		searchInput.sendKeys(query);
		searchInput.submit();
	}
	
	public String getPageTitleText(){
		return pageTitle.getText();
	}
	
	public String getDateFromPost(){
		String date = homePagePostsContent.findElement(By.tagName("time")).getText();
		return date;
	}
	
	public void goToPreviusPost(){
		previousCalendarBtn.click();
	}
	
	public void goToCalendarPost(WebElement post){
		post.click();		
	}
}
