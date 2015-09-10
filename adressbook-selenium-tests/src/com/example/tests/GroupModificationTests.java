package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test
	public void modifySomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();

		// save old save
		List<GroupData> oldlist = app.getGroupHelper().getGroups();

		Random rnd = new Random();
		int index = rnd.nextInt(oldlist.size() - 1);

		// actions
		app.getGroupHelper().initGroupModification(index);
		GroupData group = new GroupData(null, null, null);
		group.name = "new name";
		app.getGroupHelper().fillGroupForm(app, this, group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();

		// save new save
		List<GroupData> newlist = app.getGroupHelper().getGroups();
		// compare state
		oldlist.remove(index);
		oldlist.add(group);
		Collections.sort(oldlist);
		assertEquals(newlist, oldlist);

	}

}
