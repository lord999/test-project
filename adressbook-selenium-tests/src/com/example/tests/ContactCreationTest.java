package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test
	public void contactNonEmptyCreationTest() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().addNameContact();
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
	}

}
