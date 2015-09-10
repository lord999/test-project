package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

	@DataProvider(name = "randomValidGroupGenerator")
	public Iterator<Object[]> randowValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData(null, null, null);
			group.name = generateRandowString();
			group.header = generateRandowString();
			group.footer = generateRandowString();
			list.add(new Object[] { group });
		}
		// ....
		return list.iterator();
	}

	public String generateRandowString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationTestWithValidData(GroupData group) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();

		// save old save
		List<GroupData> oldlist = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper().initGroupNewCreation();
		app.getGroupHelper().fillGroupForm(app, this, group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();

		// save new save
		List<GroupData> newlist = app.getGroupHelper().getGroups();
		// compare state

		oldlist.add(group);
		Collections.sort(oldlist);
		assertEquals(newlist, oldlist);
	}

}
