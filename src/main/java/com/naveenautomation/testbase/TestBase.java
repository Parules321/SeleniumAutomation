package com.naveenAutomation.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.naveenAutomation.broswermodes.BrowserModes;
import com.naveenAutomation.browsers.Browsers;
import com.naveenAutomation.env.Environment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	private static Browsers DEFAULT_BROWSER = Browsers.CHROME;
	private static Environment DEFAULT_ENV = Environment.PROD;

	public void intialisation() {
		setBrowserForTesting();
		driverManagement();
		DEFAULT_ENV.getEnvUrl();
		driver.get(DEFAULT_ENV.getEnvUrl());
	}

	private void driverManagement() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	private void setBrowserForTesting() {

		switch (DEFAULT_BROWSER) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser");

		}

	}

	public void tearDown() {
		driver.close();
	}

}
