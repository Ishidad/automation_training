package martin_villarruel_mod0_ej2_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CustomizeTripPage {

	@FindBy(xpath = "//input[@name='_eventId_continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//div[@class='productInfo']")
	private WebElement tripInfoSide;
	
	public void checkTripInfo(WebElement tripInfo){
		Assert.assertEquals(tripInfoSide, tripInfo);
	}
	
	public void clickContinue(){
		continueBtn.click();
	}
}
