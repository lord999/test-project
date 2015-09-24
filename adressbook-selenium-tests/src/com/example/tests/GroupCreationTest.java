package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTest extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationTestWithValidData(GroupData group) throws Exception {
		// save old save
		List<GroupData> oldlist = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper().createGroup(group);

		// save new save
		List<GroupData> newlist = app.getGroupHelper().getGroups();

		// compare state
		assertThat(newlist, equalTo(((SortedListOf<GroupData>) oldlist).withAdded(group)));
	}

}
