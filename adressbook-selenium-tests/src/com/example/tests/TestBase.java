package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	// -- dob
	protected void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	// -- dob
	protected void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	// -- dob
	protected void addName() {
		driver.findElement(By.linkText("add new")).click();
	}

	protected void fillGroupForm(GroupName group) {
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys(group.name);
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys(group.header);
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	protected void fillContactForm(GroupName contact) {
		driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
		driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
		driver.findElement(By.name("address")).sendKeys(contact.address);
		driver.findElement(By.name("home")).sendKeys(contact.home);
		driver.findElement(By.name("mobile")).sendKeys(contact.mobiletel);
		driver.findElement(By.name("work")).sendKeys(contact.worktel);
		driver.findElement(By.name("email")).sendKeys(contact.email);
		driver.findElement(By.name("email2")).sendKeys(contact.email2);
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.bday);
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.bmonth);
		driver.findElement(By.name("byear")).sendKeys(contact.byear);
		driver.findElement(By.name("address2")).sendKeys(contact.address2);
		driver.findElement(By.name("phone2")).sendKeys(contact.phone2);
	}

	protected void inityGroupNewCreation() {
		driver.findElement(By.name("new")).click();
	}

	protected void openGroupPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	protected void openMainPage() {
		driver.get(baseUrl + "addressbookv4.1.4/");
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	protected void returnToContactPage() {
		driver.findElement(By.linkText("home page")).click();
	}

	protected void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

}
