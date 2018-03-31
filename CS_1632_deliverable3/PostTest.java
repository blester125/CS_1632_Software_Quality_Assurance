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
 * I want to post links
 * So I can share the latest news
 * @author Brian Lester
 */

public class PostTest {

	//static WebDriver driver = new HtmlUnitDriver();
	static WebDriver driver;
	
	// Start at the hacker news homepage
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://news.ycombinator.com/login");
		driver.findElement(By.name("acct")).sendKeys("1632test");
		driver.findElement(By.name("pw")).sendKeys("1632test");
		WebElement element = driver.findElement(By.xpath("/html/body/form[1]/input"));
		element.submit();
	}
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	// Given that I am logged on
	// When I look for for a submit link
	// Then there is a submit link
	@Test
	public void postLinkTest() {
		try {
			driver.findElement(By.linkText("submit"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that you are logged in
	// When I click the submit link
	// Then there should be a title input field
	@Test 
	public void titleEntryTest() {
		try {
			WebElement submitLink = driver.findElement(By.linkText("submit"));
			submitLink.click();
			Thread.sleep(2000);
			driver.findElement(By.name("title"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am logged in
	// When I click the submit link
	// Then there should be a url input field
	@Test 
	public void urlEntryTest() {
		try {
			WebElement submitLink = driver.findElement(By.linkText("submit"));
			submitLink.click();
			Thread.sleep(2000);
			driver.findElement(By.name("url"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am logged in
	// When I click the submit link
	// Then there should be a text input field
	@Test 
	public void textEntryTest() {
		try {
			WebElement submitLink = driver.findElement(By.linkText("submit"));
			submitLink.click();
			Thread.sleep(2000);
			driver.findElement(By.name("text"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am logged in
	// When I click the submit link
	// Then there should be a bookmarklet submission link
	@Test 
	public void bookMarkletTest() {
		try {
			WebElement submitLink = driver.findElement(By.linkText("submit"));
			submitLink.click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("bookmarklet"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am logged in
	// When I click the submit button and enter a title and url and click submit
	// Then The link shall be added to the content list
	@Test 
	public void postTest() {
		try {
			WebElement submitLink = driver.findElement(By.linkText("submit"));
			submitLink.click();
			Thread.sleep(2000);
			driver.findElement(By.name("title")).sendKeys("1632 Test Title");
			driver.findElement(By.name("url")).sendKeys("url");
			// Find button and submit
			WebElement element = driver.findElement(By.xpath("//*[@id=\"hnmain\"]/tbody/tr[3]/td/form/table/tbody/tr[6]/td[2]/input"));
			element.submit();
			driver.findElement(By.linkText("1632 Test Title"));
		} catch (Exception e) {
			fail();
		}
	}
}
