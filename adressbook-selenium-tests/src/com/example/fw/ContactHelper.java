package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactName;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void addNameContact() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactName contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home);
		type(By.name("mobile"), contact.mobiletel);
		type(By.name("work"), contact.worktel);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		// selectByText(By.name("new_group"), group 1);
		type(By.name("byear"), contact.byear);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToContactPage() {
		click(By.linkText("home page"));
	}

	public void selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + 1 + "]"));
	}

	public void modeContactEdit() {
		driver.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();
	}

	public void initContactRemove() {
		driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();
	}

	public void initContactModification(int index) {
		selectContactByIndex(index);
		modeContactEdit();
		initContactEdit();
	}

	public void initContactEdit() {
		driver.findElement(By.name("update")).click();
	}

	public List<ContactName> getContacts() {
		List<ContactName> contacts = new ArrayList<ContactName>();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			ContactName contact = new ContactName(null, null, null, null, null, null, null, null, null, null, null,
					null, null);

			contact.lastname = getLastNameInRow(row);
			if (contact.lastname == null) {
				contact.lastname = "";
			}
			contact.firstname = getFirstNameInRow(row);
			if (contact.firstname == null) {
				contact.firstname = "";
			}			
			contacts.add(contact);
		}
		return contacts;
	}

	public String getFirstNameInRow(WebElement row) {
		return row.findElement(By.xpath("./td[3]")).getText();
	}

	public String getLastNameInRow(WebElement row) {
		return row.findElement(By.xpath("./td[2]")).getText();
	}

	private List<WebElement> getContactRows() {
		return driver.findElements(By.xpath("//tr[@name='entry']"));
	}

}
