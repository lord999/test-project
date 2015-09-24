package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (!onMainPage()) {
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return (driver.findElements(By.id("maintable")).size() > 0);
	}

	public void openGroupPage() {
		if (!onGroupPage()) {
			click(By.linkText("groups"));
		}
	}

	private boolean onGroupPage() {
		if (driver.getCurrentUrl().contains("/group.ohp") && driver.findElements(By.name("new")).size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public void gotoAddNewContactPage() {
		if (!onAddNewContactPage()) {
			click(By.linkText("add new"));
		}

	}

	private boolean onAddNewContactPage() {
		return (driver.getCurrentUrl().equals("http://localhost/addressbookv4.1.4/edit.php"));
	}

}
