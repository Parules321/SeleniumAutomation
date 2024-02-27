package com.naveenautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomation.dateformat.DateFormat;
import com.naveenautomation.testbase.TestBase;

public class Utility extends TestBase {

	public static String getFirstName() {
		String firstName = RandomStringUtils.randomAlphabetic(4, 30);
		return firstName;
	}

	public static String getLastName() {
		String lastName = RandomStringUtils.randomAlphabetic(4, 30);
		return lastName;
	}

	public static String getPhoneNo() {
		String phoneNo = RandomStringUtils.randomNumeric(10);
		return phoneNo;
	}

	public static String getEmail() {
		String email = RandomStringUtils.randomAlphanumeric(1, 25) + "@example.com";
		return email;
	}

	public static String getPassword() {
		String password = RandomStringUtils.random(8,
				"0123456789!@#$%^&*()_-+=<>?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		return password;
	}

	public static String getRecipientName() {
		String recipientFirstName = RandomStringUtils.randomAlphabetic(4, 30);
		String recipientLastName = RandomStringUtils.randomAlphabetic(4, 30);
		String recipientName = recipientFirstName + " " + recipientLastName;
		return recipientName;
	}

	public static String getRecipientEmail() {
		String recipientEmail = RandomStringUtils.randomAlphanumeric(1, 50) + "@example.com";
		return recipientEmail;
	}

	public static String getAmount() {
		String amount = RandomStringUtils.randomNumeric(2, 4);
		return amount;
	}

	public static void takeFailedTestScreenShot(String testCaseName) {
		// Get the current date and Time
		String timeStamp = new SimpleDateFormat(DateFormat.LONG_DATE.getFormat()).format(new Date());

		// Save the screen shot in data type file by typecasting the WebDriver instance
		// driver to TakesScreenshot interface.
		// By typecasting like below driver becomes an instance of the TakesScreenshot
		// interface
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot. Thows IO exception if source or destination is not
		// valid.
		// ./ signifies the current directory, and FailedScreenShot is the subdirectory
		// within the current directory where the file will be saved.

		try {
			FileUtils.copyFile(screenShotFile,
					new File("./FailedScreenShot\\" + "_" + testCaseName + "_" + timeStamp + ".jpeg"));
		} catch (IOException e) {
			System.out.println("Unable to save or take screen shot of failed test " + testCaseName);

		}

	}

}
