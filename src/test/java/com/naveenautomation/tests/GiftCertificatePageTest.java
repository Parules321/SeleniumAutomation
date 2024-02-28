package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.GiftCertificatePage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.pages.RegisterAccountPage;
import com.naveenAutomation.testbase.TestBase;
import com.naveenAutomation.utility.Utility;

public class GiftCertificatePageTest extends TestBase {
	RegisterAccountPage registerAccountPage;
	MyAccountPage myAccountPage;
	GiftCertificatePage giftPage;

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
		registerAccountPage = new RegisterAccountPage();
		myAccountPage = registerAccountPage.registerAccount(Utility.getFirstName(), Utility.getLastName(),
				Utility.getPhoneNo(), Utility.getEmail(), Utility.getPassword());
		giftPage = myAccountPage.clickOnGiftCerificateBtn();

	}

	@Test
	public void validateGiftCertificateBtnClickTest() {
		String giftPageHeaderText = giftPage.getGiftPageHeaderText();
		Assert.assertEquals(giftPageHeaderText, "Purchase a Gift Certificate",
				"Text on the Gift Certificate Purchase Page did not match");
	}

	@Test
	public void validateGiftCertificatePurchase() {

		giftPage.submitGiftPurchaseDetails(Utility.getRecipientName(), Utility.getRecipientEmail(),
				"This is test purchase", Utility.getAmount());
		String giftPurchaseConfirmationText = giftPage.getGiftPurchaseConfirmationText();
		Assert.assertEquals(giftPurchaseConfirmationText,
				"Thank you for purchasing a gift certificate! Once you have completed your order your gift certificate recipient will be sent an e-mail with details how to redeem their gift certificate.",
				"Test Failed - Gift Purchase Confirmation Message did not match.");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
