package com.demo.selenium_assignment1;

/**
 * Hello world!
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class App {
	public static void main(String[] args) {
		Facebook fb = new Facebook();
		fb.driverSetup();
		fb.login();
//		fb.deleteCookie();
//		fb.incorrectPassword();
		fb.closeDriver();
	}
}
