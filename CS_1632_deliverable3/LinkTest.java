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
 * I want to see the links
 * So I can see the latest news
 * @author Brian Lester
 */

public class LinkTest {

	//static WebDriver driver = new HtmlUnitDriver();
	static WebDriver driver = new FirefoxDriver();
	
	// Start at the hacker news homepage
	@Before
	public void setUp() throws Exception {
		driver.get("https://news.ycombinator.com/");
	}
	@After
	public void tearDown() throws Exception {
		//driver.close();
	}
	
	// Given that I am on the main page
	// When I look at the pages title
	// Then I see the title contains "Hacker News"
	@Test
	public void titleTest() {
		String title = driver.getTitle();
		assertTrue(title.contains("Hacker News"));
	}
	
	// Given that I am on the main page and not logged in
	// When I check the Nav bar
	// Then I see "new" "comments" and "submit" links
	@Test
	public void navigationLinkTest() {
		try {
			driver.findElement(By.linkText("new"));
			driver.findElement(By.linkText("comments"));
			driver.findElement(By.linkText("submit"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that I am on the main page and not logged in
	// When I check the Nav bar
	// Then I should not see "welcome" link
	@Test 
	public void noWelcomeLinkTest() {
		try {
			driver.findElement(By.linkText("welcome"));
			fail();
		} catch (NoSuchElementException e) {
			
		}
	}
	// Given that I am on the main page
	// When I look at the bottom of the page
	// Then I see a more link
	@Test
	public void moreTest() {
		try {
			driver.findElement(By.linkText("More"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that I am on the main page and not logged in
	// When I look at the login link
	// Then it should be there
	@Test
	public void loginLinkTest() {
		try {
			driver.findElement(By.linkText("login"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	// Given that I am on the main page
	// When I look at the links
	// Then there should be some content
	@Test 
	public void contentTest() {
		try {
			driver.findElement(By.className("athing"));
		} catch (NoSuchElementException e) {
			fail();
		}
	}
}
