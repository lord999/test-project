package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;


import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();
		app.getContactHelper().selectContactByIndex(0);
		app.getContactHelper().modeContactEdit();
		app.getContactHelper().initContactRemove();
		app.getContactHelper().returnToContactPage();
		// save new save
		List<ContactName> newlist = app.getContactHelper().getContacts();
		// compare state
		oldlist.remove(0);
		Collections.sort(oldlist);
		assertEquals(newlist, oldlist);
	}
}
