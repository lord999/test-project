package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	@Test
	public void deleteSomeContact() {

		// save old state
		SortedListOf<Integer> contactIdListold = app.getContactHelper().getContactId();

		Random rnd = new Random();
		int index = rnd.nextInt(contactIdListold.size() - 1);

		System.out.println(" index = " + index);
		int contactId = contactIdListold.get(index);
		app.getContactHelper().deleteContact(contactId);

		// save new save
		SortedListOf<Integer> contactIdListnew = app.getContactHelper().getContactId();

		// compare state
		assertThat(contactIdListnew, equalTo((contactIdListold).without(index)));

	}
}
