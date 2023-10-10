package com.demo.selenium_assignment1;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Facebook fb = new Facebook();
		fb.driverSetup();
//		fb.login();
		fb.incorrectPassword();
//		fb.closeDriver();
	}
}
