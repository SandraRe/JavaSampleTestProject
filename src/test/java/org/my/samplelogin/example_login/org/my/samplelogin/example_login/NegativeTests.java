package org.my.samplelogin.example_login.org.my.samplelogin.example_login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class NegativeTests {

	private WebDriver driver;

	@Test
	public void testSimpleLoginBadCredentials() {

		login(Params.userName, Params.wrongPassword);
		/**
		 * If I had real login details I'd check here for some error message
		 */

		try {
			AssertJUnit.assertFalse(driver.getPageSource().contains(Params.formSumbittedTitle));
			System.out.println("Login failed as it should have, TestSimpleLoginBadCredentials passed ");

		} catch (Exception e) {
			// here I'd use some report generating library such as Extent Reports and write
			// the error and the exception there

			System.out.println("Login succeeded with wrong credentials!");
		}

	}

	@Test
	public void testLoginEmptyCredentials() {
		login("", "");

		try {
			AssertJUnit.assertFalse(driver.getPageSource().contains(Params.formSumbittedTitle));
			System.out.println("Login failed as it should have, TestLoginEmptyCredentials passed ");

		} catch (Exception e) {
			// here I'd use some report generating library such as Extent Reports and write
			// the error and the exception there
			System.out.println("Login succeeded with empty credentials!");
		}

	}

	@Test
	public void testLoginWithUsernameNoPassword() {

		login(Params.userName, "");
		try {
			AssertJUnit.assertFalse(driver.getPageSource().contains(Params.formSumbittedTitle));
			System.out.println("Login failed as it should have, TestLoginWithUsernameNoPassword passed ");

		} catch (Exception e) {
			// here I'd use some report generating library such as Extent Reports and write
			// the error and the exception there

			System.out.println("Login succeeded with empty password!");
		}

	}

	@Test
	public void testLoginWithPasswordNoUsername() {
		login("", Params.password);

		try {
			AssertJUnit.assertFalse(driver.getPageSource().contains(Params.formSumbittedTitle));
			System.out.println("Login failed as it should have, TestLoginWithPasswordNoUsername passed ");

		} catch (Exception e) {
			// here I'd use some report generating library such as Extent Reports and write
			// the error and the exception there

			System.out.println("Login succeeded with empty username!");
		}

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Params.MAX_WAIT_TIME, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {

		driver.close();
		driver.quit();

	}

	private void login(String userName, String password) {

		driver.get(Params.testURL);
		driver.findElement(Params.loginButton).click();
		driver.findElement(Params.usernameInput).sendKeys(userName);
		driver.findElement(Params.passwordInput).sendKeys(password);
		driver.findElement(Params.signInButton).click();

	}

}
