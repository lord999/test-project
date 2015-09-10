package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test
	public void contactNonEmptyCreationTest() throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();
		app.getContactHelper().addNameContact();

		// actions
		ContactName contact = new ContactName(null, null, null, null, null, null, null, null, null, null, null, null,
				null);
		contact.firstname = "firstname";
		contact.lastname = "lastname";
		contact.address = "address";
		contact.home = "home";
		contact.mobiletel = "mobiletel";
		contact.worktel = "worktel";
		contact.email = "email";
		contact.email2 = "email2";
		contact.bday = "1";
		contact.bmonth = "May";
		contact.byear = "2000";
		contact.address2 = "address2";
		contact.phone2 = "phone2";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToContactPage();

		// save new state
		List<ContactName> newlist = app.getContactHelper().getContacts();
		oldlist.add(contact);
		Collections.sort(oldlist);
		
		// compare state
		assertEquals(newlist, oldlist);

	}

	@Test
	public void contactEmptyCreationTest() throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();
		app.getContactHelper().addNameContact();

		// actions
		ContactName contact = new ContactName(null, null, null, null, null, null, null, null, null, null, null, null,
				null);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToContactPage();

		// save new state
		List<ContactName> newlist = app.getContactHelper().getContacts();

		oldlist.add(contact);
		Collections.sort(oldlist);

		// compare state

		System.out.println(" newlist = " + newlist);
		System.out.println(" oldlist = " + oldlist);

		assertEquals(newlist, oldlist);

	}

}
