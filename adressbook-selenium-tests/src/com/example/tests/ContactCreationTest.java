package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void contactNonEmptyCreationTest(ContactName contact) throws Exception {
		app.navigateTo().mainPage();

		// save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();
		app.getContactHelper().addNameContact();

		app.getContactHelper().fillContactForm(contact, CREATION);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToContactPage();

		// save new state
		List<ContactName> newlist = app.getContactHelper().getContacts();
		oldlist.add(contact);
		// Collections.sort(oldlist);
		// Collections.sort(newlist);

		// compare state
		AssertJUnit.assertEquals(newlist, oldlist);
		System.out.println();

	}
}
