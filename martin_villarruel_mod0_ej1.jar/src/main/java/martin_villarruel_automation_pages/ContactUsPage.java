package martin_villarruel_automation_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage {
	
	@FindBy(id="cntctfrm_contact_form")
	private WebElement contactForm;
	
	@FindBy(id="cntctfrm_contact_name")
	private WebElement formName;
	
	@FindBy(id="cntctfrm_contact_email")
	private WebElement formEmail;
	
	@FindBy(id="cntctfrm_contact_subject")
	private WebElement formSubjetc;
	
	@FindBy(id="cntctfrm_contact_message")
	private WebElement formMessage;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Submit']")
	private WebElement submitFormButton;
	
	@FindBy(id="cntctfrm_thanks")
	private WebElement formSubmitComfirmation;
	
	@FindBy(xpath="//*[@id='cntctfrm_contact_form']/div[1]")
	private WebElement formErrorMessage;
	
	public void goToPage(WebDriver driver){
		driver.get("http://10.28.148.127/wordpress/sample-page/");
	}
	
	public boolean returnSubmitComfirmation(){
		if (getFormSubmitComfirmation() == "Thank you for contacting us."){
			return true;
		}
		return false;
	}

	public void completeForm(String name, String email, String subject, String message){
		formName.sendKeys(name);
		formEmail.sendKeys(email);
		formSubjetc.sendKeys(subject);
		formMessage.sendKeys(message);
		submitFormButton.click();
	}
	
	public void incompleteForm(String email, String subject){
		formEmail.sendKeys(email);
		formSubjetc.sendKeys(subject);
		submitFormButton.click();
	}
	
	public void fillIncompleteForm(String name, String message){
		formName.sendKeys(name);
		formMessage.sendKeys(message);
		submitFormButton.click();
	}
	
	
	public String getFormSubmitComfirmation(){
		String comfirmation = formSubmitComfirmation.getText();
		return comfirmation;				
	}
	
	public boolean getFormErrorMessage(){
		System.out.println(formErrorMessage.getText());
		if("Please make corrections below and try again.".equals(formErrorMessage.getText())){
			return true;
		}
		return false;
	}

}
