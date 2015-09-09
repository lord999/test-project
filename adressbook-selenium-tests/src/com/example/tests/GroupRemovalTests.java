package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() {
		System.out.println("This is deleteSomeGroup  " + app);
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		
		//save old save
		List<GroupData>  oldlist = app.getGroupHelper().getGroups();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldlist.size() - 1);
		
		
		//actions
		
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().returnToGroupPage();
		
        //save new save
		List<GroupData>  newlist = app.getGroupHelper().getGroups();		
		//compare state
		//AssertJUnit.assertEquals(newlist.size(), oldlist.size() + 1 );
		
		oldlist.remove(index);
		Collections.sort(oldlist);
		assertEquals(newlist, oldlist);		
	}

}
