package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact0() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().selectContactByIndex(1);
		app.getContactHelper().modeContactEdit();
		ContactName contact = new ContactName(null, null, null, null, null, null, null, null, null, null, null, null,
				null);
		contact.firstname ="firstname_new";
		app.getContactHelper().initContactEdit();
		app.getContactHelper().returnToContactPage();
	}	

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().selectContactByIndex(1);
		app.getContactHelper().modeContactEdit();
		ContactName contact = new ContactName(null, null, null, null, null, null, null, null, null, null, null, null,
				null);
		contact.firstname = null;
		app.getContactHelper().initContactEdit();
		app.getContactHelper().returnToContactPage();
	}

}
