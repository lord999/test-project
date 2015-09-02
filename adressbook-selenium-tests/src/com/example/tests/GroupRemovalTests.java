package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() {
		System.out.println("This is deleteSomeGroup  " + app);
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		app.getGroupHelper().deleteGroup(4);
		app.getGroupHelper().returnToGroupPage();
	}

}
