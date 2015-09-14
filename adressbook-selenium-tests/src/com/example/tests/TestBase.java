package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}
	
	@DataProvider(name = "randomValidContactGenerator")
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			ContactName contact = new ContactName(null, null, null, null, null, null, null, null, null, null, null,
					null, null);
			contact.firstname = generateRandowString();
			contact.lastname = generateRandowString();
			list.add(new Object[] { contact });
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

/*	public String generateRandowString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}	*/

}
