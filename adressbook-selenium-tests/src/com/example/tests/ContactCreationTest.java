package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void contactNonEmptyCreationTest(ContactName contact) throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();
		app.getContactHelper().addNameContact();

		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToContactPage();

		// save new state
		List<ContactName> newlist = app.getContactHelper().getContacts();
		oldlist.add(contact);
		Collections.sort(oldlist);
		Collections.sort(newlist);

		// compare state
		assertEquals(newlist, oldlist);
	}

}
