package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this); // this method is defined inside the constructor to initialize all the
												// elements of the current class object.
	}

	@FindBy(xpath = "//a[text() ='Contact Us']")
	WebElement contactBtn;

	@FindBy(xpath = "//a[text()='Gift Certificates']")
	WebElement giftCertificateBtn;
	
	@FindBy(css = "#content>h1")
	WebElement accountCreationConfirmationText;

	public String getAccountCreationConfirmationText() {
		return accountCreationConfirmationText.getText();
	}

	public ContactUsPage clickContactBtn() {
		contactBtn.click();
		return new ContactUsPage();
	}

	public GiftCertificatePage clickOnGiftCerificateBtn() {
		giftCertificateBtn.click();
		return new GiftCertificatePage();
	}

}
