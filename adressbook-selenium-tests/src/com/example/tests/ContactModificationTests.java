package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact0() {
		app.getNavigationHelper().openMainPage();		
		
		//save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();	
		
		// actions
		app.getContactHelper().selectContactByIndex(0);
		app.getContactHelper().modeContactEdit();
		ContactName contact = new ContactName(null, null, null, null, null, null, null, null, null, null, null, null, null);
		contact.firstname = "firstname_00";
		contact.lastname = "lastname_00";
		app.getContactHelper().fillContactForm(contact);		
		//app.getContactHelper().fillContactName(contact);		
		app.getContactHelper().initContactEdit();
		app.getContactHelper().returnToContactPage();
	
		// save new save
		List<ContactName> newlist = app.getContactHelper().getContacts();
		
		// compare state
		oldlist.remove(0);
		oldlist.add(contact);
		Collections.sort(oldlist);		
		assertEquals(newlist, oldlist);
	}	
}
