package martin_villarruel_mod0_ej2_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {

	@FindBy(id = "main")
	private WebElement mainFrame;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailInput;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//input[@type='submit' and @name='_eventId_submit']")
	private WebElement submitInput;

	@FindBy(xpath = "//p[starts-with(@class, 'error')]/span")
	private WebElement errorMessage;

	public void goToPage(WebDriver driver) {
		driver.get("https://www.cheaptickets.com/account/login");
	}

	public void fillLogIn(String mail, String pass) {
		emailInput.sendKeys(mail);
		passwordInput.sendKeys(pass);
		submitInput.click();
	}

	public void checkForErrorMessage() {
		errorMessage.getText().contains("error");
	}
}