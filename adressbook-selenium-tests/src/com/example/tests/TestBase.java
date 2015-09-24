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

	@DataProvider(name = "randomValidGroupGenerator")
	public Iterator<Object[]> randowValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData().withName(generateRandomString()).withHeader(generateRandomString())
					.withFooter(generateRandomString());
			;
			list.add(new Object[] { group });
		}
		// ....
		return list.iterator();
	}

	@DataProvider(name = "randomValidContactGenerator")
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			ContactName contact = new ContactName().withfirstname(generateRandomString())
					.withlastname(generateRandomString()).withaddress(generateRandomString())
					.withhome(generateRandomString()).withmobiletel(generateRandomString())
					.withworktel(generateRandomString()).withemail(generateRandomString())
					.withemail2(generateRandomString()).withbday(generateRandomDay()).withbmonth(generateRandomMonth())
					.withbyear(generateRandomYear()).withaddress2(generateRandomString())
					.withphone2(generateRandomString());
			list.add(new Object[] { contact });
		}
		// ....
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

	public String generateRandomMonth() {
		Random rnd = new Random();

		String[] months = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		int r = rnd.nextInt(months.length);
		String randomMonth = months[r];

		if (rnd.nextInt(6) == 0) {
			return "-";
		} else {
			return randomMonth;
		}
	}

	public String generateRandomDay() {
		Random rnd = new Random();
		String[] days = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29" };
		int r = rnd.nextInt(days.length);
		String randomDay = days[r];

		if (rnd.nextInt(5) == 0) {
			return "-";
		} else {
			return randomDay;
		}

	}

	public String generateRandomYear() {
		Random rnd = new Random();
		int r = (int) (Math.random() * 2015) + 1;
		String randomYear = String.valueOf(r);

		if (rnd.nextInt(10) == 0) {
			return "";
		} else {
			return randomYear;
		}
	}

}
