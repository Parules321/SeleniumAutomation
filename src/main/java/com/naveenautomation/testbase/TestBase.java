package com.naveenautomation.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.naveenautomation.broswermodes.BrowserModes;
import com.naveenautomation.browsers.Browsers;
import com.naveenautomation.env.Environment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	private static BrowserModes DEFAULT_MODE = BrowserModes.NORMAL;
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
		switch (DEFAULT_MODE) {

		case NORMAL:
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
			;
			break;
		case HEADLESS:
			switch (DEFAULT_BROWSER) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				ChromeOptions headlessOptionChrome = new ChromeOptions();
				headlessOptionChrome.setHeadless(true);
				driver = new ChromeDriver(headlessOptionChrome);
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions headlessOptionFirefox = new FirefoxOptions();
				headlessOptionFirefox.setHeadless(true);
				driver = new FirefoxDriver(headlessOptionFirefox);
				break;

			default:
				throw new IllegalArgumentException("Unsupported browser");

			}
			;
			break;

		case INCOGNITO:
			switch (DEFAULT_BROWSER) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				ChromeOptions incognitoOptionChrome = new ChromeOptions();
				incognitoOptionChrome.addArguments("--incognito");
				driver = new ChromeDriver(incognitoOptionChrome);
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions incognitoOptionFirefox = new FirefoxOptions();
				incognitoOptionFirefox.addArguments("--private");
				driver = new FirefoxDriver(incognitoOptionFirefox);
				break;
			case EDGE:
				WebDriverManager.edgedriver().setup();
				EdgeOptions incognitoOptionEdge = new EdgeOptions();
				incognitoOptionEdge.setCapability("InPrivate", true);
				driver = new EdgeDriver(incognitoOptionEdge);
				break;

			default:
				throw new IllegalArgumentException("Unsupported browser");

			}
			;
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser mode");

		}

	}

	public void tearDown() {
		driver.close();
	}

}
