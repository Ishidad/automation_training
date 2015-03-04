package martin_villarruel_mod0_ej2_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TravelerInfoPage {

	@FindBy(xpath = "//input[@name='_eventId_submit']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//div[@class='productInfo']")
	private WebElement tripInfoSide;
	
	@FindBy(xpath ="//input[contains(@name, 'travelers[0].name.firstName')]")
	private WebElement travelerFirstName;
	
	@FindBy(xpath ="//input[contains(@name, 'travelers[0].name.lastName')]")
	private WebElement travelerLastName;
	
	@FindBy(xpath ="//input[contains(@name, 'travelers[0].phoneNumber.phoneNumber')]")
	private WebElement travelersPhone;
	
	@FindBy(xpath ="//option[@value='M']")
	private WebElement travelerMasculine;
	
	@FindBy(xpath ="//option[@value='F']")
	private WebElement travelerFemenine;
	
	@FindBy(xpath ="//option[@value='6']")
	private WebElement travelerBirthDay;
	
	@FindBy(xpath ="//option[@value='30']")
	private WebElement travelerBirthMonth;
	
	@FindBy(xpath ="//option[@value='1987']")
	private WebElement travelerBirthYear;
	
	@FindBy(xpath ="//input[contains(@name, 'email.emailAddress')]")
	private WebElement travelersEmailComfirmation;
	
	@FindBy(xpath ="//input[@class='needsclick' and contains(@name, 'selectedProductIndex') and @value='-1']")
	private WebElement noinsurenceRadioBtn;
	
	public void checkTripInfo(WebElement tripInfo){
		Assert.assertEquals(tripInfoSide, tripInfo);
	}
	
	public void fillTravelerInfo(String firstName, String lastName, String phoneNumber, String eMail){
		travelerFirstName.sendKeys(firstName);
		travelerLastName.sendKeys(lastName);
		travelersPhone.sendKeys(phoneNumber);
		travelerMasculine.click();
		travelerBirthDay.click();
		travelerBirthMonth.click();
		travelerBirthYear.click();
		travelersEmailComfirmation.sendKeys(eMail);
		noinsurenceRadioBtn.click();		
	}
	
	public void clickContinue(){
		continueBtn.click();
	}
}
