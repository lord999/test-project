package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<GroupData> cachedGroups;

	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null) {
			rebuildCacheGroups();
		}
		return cachedGroups;
	}

	private void rebuildCacheGroups() {
		cachedGroups = new SortedListOf<GroupData>();
		manager.navigateTo().openGroupPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			if (name == null) {
				name = "";
			}
			cachedGroups.add(new GroupData().withName(name));
		}
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().openGroupPage();
		initGroupNewCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupPage();
		rebuildCacheGroups();
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupPage();
		rebuildCacheGroups();
		return this;
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupPage();
		rebuildCacheGroups();
		return this;
	}

	// --------------------------------------------------------------------------------------------------------------

	public GroupHelper initGroupNewCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
	}

	public GroupHelper returnToGroupPage() {
		click(By.linkText("group page"));
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}

}
