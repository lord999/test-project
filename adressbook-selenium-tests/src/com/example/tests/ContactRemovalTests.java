package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact() {
		app.navigateTo().mainPage();

		// save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldlist.size());
		if (index > 1) {
			index = index - 1;
		}

		app.getContactHelper().selectContactByIndex(index);
		app.getContactHelper().modeContactEdit();
		app.getContactHelper().initContactRemove();
		app.getContactHelper().returnToContactPage();
		// save new save
		List<ContactName> newlist = app.getContactHelper().getContacts();
		// compare state
		oldlist.remove(index);
		Collections.sort(oldlist);
		Collections.sort(newlist);
		assertEquals(newlist, oldlist);
	}
}
