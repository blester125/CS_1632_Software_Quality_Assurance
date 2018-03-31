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
 * I want to comment
 * So I can share my opinions with others
 * @author Brian Lester
 */

public class CommentsTest {

	//static WebDriver driver = new HtmlUnitDriver();
	static WebDriver driver;
	
	// Start at the hacker news homepage
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://news.ycombinator.com/login");
		driver.findElement(By.name("acct")).sendKeys("1632TestAccount");
		driver.findElement(By.name("pw")).sendKeys("1632TestAccount");
		WebElement element = driver.findElement(By.xpath("/html/body/form[1]/input"));
		element.submit();
	}
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	// Given that I am on the homepage
	// When I look at the nav bar
	// Then there should be a comments link
	@Test
	public void commentLinkTest() {
		try {
			driver.findElement(By.linkText("comments"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that I am on the homepage
	// When I look at an item
	// Then there should be a comment link for that item
	@Test
	public void commentOnLinkTest() {
		try {
			WebElement element = driver.findElement(By.className("subtext"));
			element = element.findElement(By.partialLinkText("comments"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am on the comment page
	// When I want to enter a comment
	// Then there should be a comment input field
	@Test
	public void commentFieldTest() {
		try {
			WebElement element = driver.findElement(By.className("subtext"));
			element = element.findElement(By.partialLinkText("comments"));
			element.click();
			Thread.sleep(2000);
			driver.findElement(By.name("text"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am on the comment page
	// When I enter a comment and click submit
	// Then the comment should be created
	@Test
	public void submitCommentTest() {
		try {
			WebElement element = driver.findElement(By.className("subtext"));
			element = element.findElement(By.partialLinkText("comments"));
			element.click();
			Thread.sleep(2000);
			driver.findElement(By.name("text")).sendKeys("Test");
			element = driver.findElement(By.xpath("//*[@id=\"hnmain\"]/tbody/tr[3]/td/table[1]/tbody/tr[4]/td[2]/form/input[4]"));
			element.submit();
			driver.get("https://news.ycombinator.com/item?id=11204936");
			assertTrue(driver.getPageSource().contains("1 point"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am on the comment page
	// When I want to read the approach to comments
	// Then there should be a approach to commenting link
	@Test
	public void approachLinkTest() {
		try {
			WebElement element = driver.findElement(By.className("subtext"));
			element = element.findElement(By.partialLinkText("comments"));
			element.click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("approach to comments"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am on the comment page
	// When I want to read the guidelines for comments
	// Then there should be a site guidelines link
	@Test
	public void guidelinesTest() {
		try {
			WebElement element = driver.findElement(By.className("subtext"));
			element = element.findElement(By.partialLinkText("comments"));
			element.click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("site guidelines"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am on a comment page
	// When I want to comment on another comment
	// Then there is a reply link
	@Test
	public void replyLinkTest() {
		try {
			WebElement element = driver.findElement(By.className("subtext"));
			element = element.findElement(By.partialLinkText("comments"));
			element.click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("reply"));
		} catch (Exception e) {
			fail();
		}
	}
	
	// Given that I am on a comment page
	// When I click the reply link
	// Then there is a comment entry box
	@Test
	public void replyTest() {
		try {
			WebElement element = driver.findElement(By.className("subtext"));
			element = element.findElement(By.partialLinkText("comments"));
			element.click();
			Thread.sleep(2000);
			WebElement reply = driver.findElement(By.linkText("reply"));
			reply.click();
			Thread.sleep(2000);
			driver.findElement(By.name("text"));
		} catch (Exception e) {
			fail();
		}
	}
}
