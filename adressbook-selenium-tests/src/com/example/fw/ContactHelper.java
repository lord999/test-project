package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactName;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void addNameContact() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactName contact, boolean formType) {
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
		type(By.name("byear"), contact.byear);
		if (formType == CREATION) {
			// selectByText(By.name("new_group"), group 1);
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exists in cintact modification form");
			}
		}

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
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
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
package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactName;
import com.example.utils.SortedListOf;;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = false;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactName> cachedContacts;

	public SortedListOf<ContactName> getContacts() {
		if (cachedContacts == null) {
			rebuildCacheContacts();
		}
		return cachedContacts;
	}

	private void rebuildCacheContacts() {
		cachedContacts = new SortedListOf<ContactName>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			ContactName contact = new ContactName().withfirstname(row.findElement(By.xpath(".//td[3]")).getText())
					.withlastname(row.findElement(By.xpath(".//td[2]")).getText());
			cachedContacts.add(contact);
		}
	}

	public ContactHelper createContact(ContactName contact) {
		manager.navigateTo().mainPage();
		clickOnAddContact();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToContactPage();
		rebuildCacheContacts();
		return this;
	}

	public void modifyContact(int contactId, ContactName contact) {
		getContactId();
		selectContactByIndex(contactId);
		fillContactForm(contact, MODIFICATION);
		submitContactEdit(contactId);
		returnToContactPage();
		rebuildCacheContacts();
	}

	public void deleteContact(int contactId) {
		selectContactByIndex(contactId);
		submitContactDeletion();
		returnToContactPage();
		rebuildCacheContacts();
	}

	// -----------------------------------------------------------------------------------------

	public ContactHelper clickOnAddContact() {
		click(By.linkText("add new"));
		return this;
	}

	public SortedListOf<Integer> getContactId() {
		SortedListOf<Integer> contactId = new SortedListOf<Integer>();
		List<WebElement> checkboxes = driver.findElements(By
				.xpath("//tr[@name=\"entry\"]/td[@class=\"center\"]/input[@type=\"checkbox\"][@name=\"selected[]\"]"));
		for (WebElement checkbox : checkboxes) {
			String idx = checkbox.getAttribute("value");
			int index = Integer.parseInt(idx);
			contactId.add(index);
		}
		return contactId;
	}

	public ContactHelper fillContactForm(ContactName contact, boolean formtype) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome());
		type(By.name("mobile"), contact.getMobiletel());
		type(By.name("work"), contact.getWorktel());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		type(By.name("byear"), contact.getByear());

		if (formtype == CREATION) {
			// selectByText(By.name("new_group"), group 1);
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exists in contact modification form");
			}
		}

		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhone2());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToContactPage() {
		driver.findElement(By.linkText("home page")).click();
		return this;
	}

	public ContactHelper selectContactByIndex(int index) {
		click(By.xpath("//a[@href=\"edit.php?id=" + index + "\"]"));
		return this;
	}

	public ContactHelper modeContactEdit() {
		driver.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();
		return this;
	}

	public String getFirstNameInRow(WebElement row) {
		return row.findElement(By.xpath("./td[2]")).getText();
	}

	public String getLastNameInRow(WebElement row) {
		return row.findElement(By.xpath("./td[3]")).getText();
	}

	private List<WebElement> getContactRows() {
		return driver.findElements(By.xpath("//tr[@name='entry']"));
	}

	public ContactHelper submitContactEdit(int index) {
		driver.findElement(By.name("update")).click();
		cachedContacts = null;
		return this;
	}

	public ContactHelper submitContactDeletion() {
		driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();
		cachedContacts = null;
		return this;
	}

}
