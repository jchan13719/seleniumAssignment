package com.demo.selenium_assignment1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

/**
 * Unit test for simple App.
 */
public class AppTest {

	public Facebook fb;

	@Before
	public void setUp() {
		fb = new Facebook();
		fb.driverSetup();
	}

	@After
	public void after() {
		fb.closeDriver();
	}

	@Test
	public void testLogin() {
		WebElement loggedInUser = fb.login();
		assertEquals(loggedInUser.getText(), fb.user);
	}

//	@Test
//	public void testIncorrectPassword() {
//		WebElement incorrectPasswordMsg = fb.incorrectPassword();
//		assertEquals(incorrectPasswordMsg.getText(), fb.INCORRECT_PASSWORD_MSG);
//	}

}
//Invoke wait to load the application page
//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//chromeOptions.addArguments("--headless");