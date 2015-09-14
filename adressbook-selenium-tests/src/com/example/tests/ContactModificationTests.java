package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();

 
		// save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldlist.size() );
		
		if ( index > 1 ) {
			index = index - 1;
		}	

		// actions
		app.getContactHelper().selectContactByIndex(index);
		app.getContactHelper().modeContactEdit();
		ContactName contact = new ContactName(null, null, null, null, null, null, null, null, null, null, null, null,
				null);
		contact.firstname = "firstname_00";
		contact.lastname = "lastname_00";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().initContactEdit();
		app.getContactHelper().returnToContactPage();

		// save new save
		List<ContactName> newlist = app.getContactHelper().getContacts();

		// compare state
		oldlist.remove(index);
		oldlist.add(contact);
		Collections.sort(oldlist);
		Collections.sort(newlist);		
		assertEquals(newlist, oldlist);
	}
}
