package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() {		

		// save old save
		SortedListOf<GroupData> oldlist = app.getGroupHelper().getGroups();

		Random rnd = new Random();
		int index = rnd.nextInt(oldlist.size());

		// actions
		app.getGroupHelper().deleteGroup(index);

		// save new save
		SortedListOf<GroupData> newlist = app.getGroupHelper().getGroups();
		
		// compare state
		assertThat(newlist, equalTo(oldlist.without(index)));

	}

}
