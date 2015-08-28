package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreationTest extends TestBase {
  @Test
  public void groupNonEmptyCreationTest() throws Exception {
	openMainPage();
    openGroupPage();
    inityGroupNewCreation();
    fillGroupForm(new GroupName("group 1", "header 1", "footer 1"));
    submitGroupCreation();
    returnToGroupPage();
  }
  
  @Test
  public void groupEmptyCreationTest() throws Exception {
	openMainPage();
    openGroupPage();
    inityGroupNewCreation();
    GroupName group = new GroupName();
    group.name = "group 1"; 
    group.header = "header 1"; 
    group.footer = "footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }
}

