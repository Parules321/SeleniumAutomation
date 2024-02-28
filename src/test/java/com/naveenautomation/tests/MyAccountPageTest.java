package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.pages.RegisterAccountPage;
import com.naveenAutomation.testbase.TestBase;
import com.naveenAutomation.utility.Utility;

public class MyAccountPageTest extends TestBase {
	RegisterAccountPage registerAccountPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
		
	}

	@Test
	public void validateAccountRegistrationTest() {	
		registerAccountPage = new RegisterAccountPage();
		myAccountPage = registerAccountPage.registerAccount(Utility.getFirstName(), Utility.getLastName(), Utility.getPhoneNo(), Utility.getEmail(),
				Utility.getPassword());
		String accountRegistrationConfirmationText = myAccountPage.getAccountCreationConfirmationText();	
		Assert.assertEquals(accountRegistrationConfirmationText, "Your Account Has Been Created!", "Confirmation text for account registration does not match.");
	}


	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
