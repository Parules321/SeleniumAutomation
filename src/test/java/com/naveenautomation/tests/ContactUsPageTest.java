package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.ContactUsPage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.pages.RegisterAccountPage;
import com.naveenAutomation.testbase.TestBase;
import com.naveenAutomation.utility.Utility;

public class ContactUsPageTest extends TestBase {
	RegisterAccountPage registerAccountPage;
	MyAccountPage myAccountPage;
	ContactUsPage contactPage;

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
		registerAccountPage = new RegisterAccountPage();
		myAccountPage = registerAccountPage.registerAccount(Utility.getFirstName(), Utility.getLastName(), Utility.getPhoneNo(), Utility.getEmail(),
				Utility.getPassword());

	}

	@Test
	public void validateContactBtnClickTest() {
		contactPage = myAccountPage.clickContactBtn();
		String contactUsHeaderText = contactPage.getContactUsPageHeaderText();
		Assert.assertEquals(contactUsHeaderText, "Contact Us", "Test Failed - Landing page titles did not match.");
	}

	@Test
	public void validateSubmitContactDetails() {
		contactPage = myAccountPage.clickContactBtn();
		contactPage.submitContactDetails("This is test enquiry");

		String confirmationText = contactPage.getConfirmationText();
		Assert.assertEquals(confirmationText, "Your enquiry has been successfully sent to the store owner!",
				"Test Failed - The confirmation text did not match.");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
