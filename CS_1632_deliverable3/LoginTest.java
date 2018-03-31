package dev3Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/*
 * As a user
 * I want login
 * So I can interact with the community
 * @author Brian Lester
 */

public class LoginTest {
	static WebDriver driver;
	
	// Start at the hacker news login page
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://news.ycombinator.com/login");
	}
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	// Given that I am on the login page
	// When I go to enter my password
	// Then I see a username text field
	@Test
	public void loginFieldTest() {
		try {
			driver.findElement(By.name("acct"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that I am on the login page
	// When I go to enter my password
	// Then I see a password text field
	@Test
	public void passwordFieldTest() {
		try {
			driver.findElement(By.name("pw"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that I am on the login page
	// When I have forgotten my password
	// Then I see a forgotten password link
	@Test
	public void forgotPasswordTest() {
		try {
			driver.findElement(By.linkText("Forgot your password?"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that I am on the login page and have correct credentials
	// When I enter the credentials
	// Then I should login
	@Test
	public void correctLoginTest() {
		try {
			driver.findElement(By.name("acct")).sendKeys("1632test");
			driver.findElement(By.name("pw")).sendKeys("1632test");
			WebElement element = driver.findElement(By.xpath("/html/body/form[1]/input"));
			element.submit();
			driver.findElement(By.linkText("logout"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that I am on the login page and have correct credentials
	// When I enter the credentials
	// Then I should not login and see a Bad login error
	@Test
	public void incorrectLoginTest() {
		try {
			driver.findElement(By.name("acct")).sendKeys("1632");
			driver.findElement(By.name("pw")).sendKeys("1632");
			WebElement element = driver.findElement(By.xpath("/html/body/form[1]/input"));
			element.submit();
			assertTrue(driver.getPageSource().contains("Bad login."));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that I am on the login page and have correct credentials
	// When I enter the credentials
	// Then I should login and see a welcome link
	@Test
	public void welcomeLinkTest() {
		try {
			driver.findElement(By.name("acct")).sendKeys("1632test");
			driver.findElement(By.name("pw")).sendKeys("1632test");
			WebElement element = driver.findElement(By.xpath("/html/body/form[1]/input"));
			element.submit();
			driver.findElement(By.linkText("welcome"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
}
