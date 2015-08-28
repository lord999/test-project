package com.example.tests;

import org.testng.annotations.Test;



public class GroupCreationTest extends TestBase{
  @Test
  public void groupNonEmptyCreationTest() throws Exception {
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
  
  @Test
  public void groupEmptyCreationTest() throws Exception {
	openMainPage();
    openGroupPage();
    inityGroupNewCreation();
    GroupName group = new GroupName();
    fillGroupForm(new GroupName("", "", ""));
    submitGroupCreation();
    returnToGroupPage();
  }
}

