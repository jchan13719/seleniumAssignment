package com.demo.selenium_assignment1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook {
	final static String USERNAME = "test6842test@gmail.com";
	final static String PASSWORD = "test123test123!!";
	final static String INCORRECT_PASSWORD = "test123test123!";
	final static String user = "Justin Teest";

	final static String INCORRECT_PASSWORD_MSG = "The password you’ve entered is incorrect. Forgot Password?";
	public static WebDriver driver;

	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jc561\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// setup chrome parameters
		// Note: headless means it will execute in the background w/o brower
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--headless");

		WebDriver webdriver = new ChromeDriver(chromeOptions);
		driver = webdriver;

		// Test Login Page
//		testLogin();
//		driver.manage().deleteAllCookies();
//		testIncorrectPassword();

		// Close the driver
//		driver.close();
	}

	public WebElement login() {
		try {
			// open url in the brower
			driver.get("https://www.facebook.com");
			// Find the username and password elements
			driver.findElement(By.id("email")).sendKeys(USERNAME);
			driver.findElement(By.id("pass")).sendKeys(PASSWORD);
			// Find all button tags
			List<WebElement> buttons = driver.findElements(By.tagName("button"));
			// Login in button is at the first position
			buttons.get(0).click();

			// Get logged user to check text
			WebElement loggedInUser = driver.findElement(By.cssSelector("div.x1iyjqo2 div.x1qjc9v5"));
			System.out.println("***************************************" + loggedInUser.getText());
			return loggedInUser;
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;
	}

	public WebElement incorrectPassword() {
		try {
			// open url in the brower
			driver.get("https://www.facebook.com/login");

			// Find the username and password elements
			driver.findElement(By.id("email")).sendKeys(USERNAME);
			driver.findElement(By.id("pass")).sendKeys(INCORRECT_PASSWORD);

			// Find all button tags
			List<WebElement> buttons = driver.findElements(By.tagName("button"));
			// Login in button is at the first position
			buttons.get(0).click();

			driver.findElement(By.className("_aklt")).click();
			driver.findElement(By.id("pass")).sendKeys(INCORRECT_PASSWORD);
			driver.findElement(By.id("loginbutton")).click();

			// Get incorrect password msg to check text
			WebElement incorrectPasswordMsg = driver.findElement(By.cssSelector("div._9ay7"));
			System.out.println("***************************************" + incorrectPasswordMsg.getText());
			return incorrectPasswordMsg;
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;

	}

	public void closeDriver() {
		driver.close();

	}
}
