package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testbase.TestBase;

public class ContactUsPage extends TestBase {

	public ContactUsPage() {
		PageFactory.initElements(driver, this); // this method is defined inside the constructor to initialize all the
												// elements of the current class object.
	}

	@FindBy(id = "input-enquiry") // For every element there should be a correponding method
	WebElement enquiryInputBox;

	@FindBy(css = "[type ='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//p[contains(text(),'successfully sent')]")
	WebElement confirmationText;
	
	@FindBy(css = "#content h1")
	WebElement contactUsPageHeader;

	
	public String getContactUsPageHeaderText() {
		return contactUsPageHeader.getText();
		
	}

	private void enterEnquiry(String enquiry) {
		enquiryInputBox.sendKeys(enquiry);
	}

	private void clickSubmitBtn() {
		submitBtn.click();
	}

	public void submitContactDetails(String enquiry) {
		enterEnquiry(enquiry);
		clickSubmitBtn();
	}

	public String getConfirmationText() {
		return confirmationText.getText();
	}

}
