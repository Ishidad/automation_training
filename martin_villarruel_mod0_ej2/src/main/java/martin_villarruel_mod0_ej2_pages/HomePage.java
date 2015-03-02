package martin_villarruel_mod0_ej2_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(id="headerStandard")
	private WebElement pageHeader;
	
	@FindBy(xpath="//li[@class='welcomeText']")
	private WebElement welcomeText;
	
	@FindBy(xpath = "//a[contains(@href, 'https://www.cheaptickets.com/account/login?destinationUrl=%2F')]")
	private WebElement loginLink;
	
	@FindBy(xpath="//a[contains(@href, '/account/logout')]")
	private WebElement logoutLink;

	public void goToPage(WebDriver driver){
		driver.get("http://www.cheaptickets.com/");
	}
	
	public void loginIn(){
		loginLink.click();
	}
	
	public void logOut(){
		logoutLink.click();
	}
	
	public void checkLoginStatus(){
		welcomeText.getText().contains("Martin Test");
	}
	
	public void checkLogoutStatus(){
		welcomeText.getText().contains("CheapTickets");
	}
}
