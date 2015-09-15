package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTest extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationTestWithValidData(GroupData group) throws Exception {

		// save old save
		SortedListOf<GroupData> oldlist = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper().createGroup(group);

		// save new save
		SortedListOf<GroupData> newlist = app.getGroupHelper().getGroups();

		// compare state
		assertThat(newlist, equalTo(oldlist.withAdded(group)));

	}

}


