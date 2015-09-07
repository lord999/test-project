package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test
	public void modifySomeGroup() {
		System.out.println("This is GroupModificationTests  " + app);
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData(null, null, null);
		group.name = "new name";
		// app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().fillGroupForm(app, this, group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();

	}

}
