package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact() {
		// save old state
		List<ContactName> oldlist = app.getContactHelper().getContacts();

		SortedListOf<Integer> contactIdList = app.getContactHelper().getContactId();

		int[] qqq = new int[contactIdList.size()];

		for (int i = 0; i < contactIdList.size(); i++) {
			int bbb = contactIdList.get(i);
			qqq[i] = bbb;
		}
		int index = (int) (Math.random() * contactIdList.size()) + 1;
		int contactId = contactIdList.get(index - 1);

		ContactName contact = new ContactName();
		// actions
		app.getContactHelper().modifyContact(contactId, contact);

		// save new save
		List<ContactName> newlist = app.getContactHelper().getContacts();

		// compare state
		assertThat(newlist, equalTo(((SortedListOf<ContactName>) oldlist)));
	}
}
