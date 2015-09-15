package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")

	public void modifySomeGroup(GroupData group) {

		// save old save
		SortedListOf<GroupData> oldlist = app.getGroupHelper().getGroups();

		Random rnd = new Random();
		int index = rnd.nextInt(oldlist.size() - 1);

		// actions
		app.getGroupHelper().modifyGroup(index, group);

		// save new save
		SortedListOf<GroupData> newlist = app.getGroupHelper().getGroups();
		// compare state
		assertThat(newlist, equalTo(oldlist.without(index).withAdded(group)));

	}

}
