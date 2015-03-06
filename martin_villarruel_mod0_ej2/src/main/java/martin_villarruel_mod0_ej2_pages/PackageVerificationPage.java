package martin_villarruel_mod0_ej2_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PackageVerificationPage {

	@FindBy(xpath = "//div[@class='linkAsButton button-primary button-medium selectFlight']/a[@data-context='selectButton' and @class='buttonLink link']")
	private WebElement continueBtn;

	public void clickContinueBtn() {
		continueBtn.click();
	}
}
