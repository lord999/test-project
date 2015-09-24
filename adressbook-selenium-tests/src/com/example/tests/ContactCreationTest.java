package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void contactNonEmptyCreationTest(ContactName contact) throws Exception {

		// save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();

		app.getContactHelper().createContact(contact);

		// save new state
		List<ContactName> newlist = app.getContactHelper().getContacts();

		// compare state
		assertThat(newlist, equalTo(((SortedListOf<ContactName>) oldlist).withAdded(contact)));

	}

}
