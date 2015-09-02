package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {
	@Test
	public void groupNonEmptyCreationTest() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().initGroupNewCreation();
		GroupData group = new GroupData(null, null, null);
		group.name = "group 1";
		group.header = "header 1";
		group.footer = "footer 1";
		app.getGroupHelper().fillGroupForm(app, this, group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();
	}

	@Test
	public void groupEmptyCreationTest() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().initGroupNewCreation();
		app.getGroupHelper().fillGroupForm(app, this, new GroupData(null, null, null));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();
	}
}
