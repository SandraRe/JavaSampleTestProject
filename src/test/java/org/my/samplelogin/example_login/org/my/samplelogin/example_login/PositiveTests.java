package org.my.samplelogin.example_login.org.my.samplelogin.example_login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PositiveTests {

	private WebDriver driver;

	@Test
	public void testSimpleLogin() {
		driver.get(Params.testURL);
		driver.findElement(Params.loginButton).click();
		driver.findElement(Params.usernameInput).sendKeys(Params.userName);
		driver.findElement(Params.passwordInput).sendKeys(Params.password);
		driver.findElement(Params.signInButton).click();
		try {
			AssertJUnit.assertTrue(driver.getPageSource().contains(Params.formSumbittedTitle));
			System.out.println("Login Succeeded, TestSimpleLogin passed");

		} catch (Exception e) {
			// here I'd use some report generating library such as Extent Reports and write
			// the error and the exception there
			System.out.println("Login failed, TestSimpleLogin failed");
		}

	}

	@Test
	public void testLoginAndCheckTitles() {

		driver.get(Params.testURL);
		try {
			AssertJUnit.assertTrue(driver.getPageSource().contains(Params.mainPageTitle));

		} catch (Exception e) {
			// here I'd use some report generating library such as Extent Reports and write
			// the error and the exception there

			System.out.println("Main title is incorrect or missing");
		}
		driver.findElement(Params.loginButton).click();

		try {
			AssertJUnit.assertTrue(driver.getPageSource().contains(Params.userTitle));

		} catch (Exception e) {
			// here I'd use some report generating library such as Extent Reports and write
			// the error and the exception there
			System.out.println("Username title is incorrect or missing");
		}

		try {
			AssertJUnit.assertTrue(driver.getPageSource().contains(Params.passwordTitle));

		} catch (Exception e) {
			// here I'd use some report generating library such as Extent Reports and write
			// the error and the exception there
			System.out.println("Password title is incorrect or missing");
		}

		driver.findElement(Params.usernameInput).sendKeys(Params.userName);
		driver.findElement(Params.passwordInput).sendKeys(Params.password);
		driver.findElement(Params.signInButton).click();
		System.out.println("Login Succeeded, TestLoginAndCheckTitles passed");

	}

	@Test
	public void testRememeberMeChekbox() {

		driver.get(Params.testURL);
		driver.findElement(Params.loginButton).click();

		WebElement checkBoxElement = driver.findElement(Params.rememberMeCheckbox);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", checkBoxElement);
		executor.executeScript("arguments[0].click();", checkBoxElement);

		System.out.println("TestRememeberMeChekbox passed");

	}

	@Test
	public void testCloseAndCancelButtons() {

		driver.get(Params.testURL);
		driver.findElement(Params.loginButton).click();
		WebElement cancelElement = driver.findElement(Params.cancelButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", cancelElement);
		driver.findElement(Params.loginButton).click();
		WebElement closeElement = driver.findElement(Params.closeButton);
		executor.executeScript("arguments[0].click();", closeElement);
		System.out.println("TestCloseAndCancelButtons passed");

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

}
