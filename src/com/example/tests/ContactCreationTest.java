package com.example.tests;

import org.testng.annotations.Test;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;





import org.testng.annotations.Test;


public class ContactCreationTest extends TestBase {

  @Test
  public void contactNonEmptyCreationTest() throws Exception {
	openMainPage();  
	addName();
	GroupName contact = new GroupName();	
	contact.firstname  = "firstname"; 
    contact.lastname   =  "lastname";		
    contact.address    =  "address";
    contact.home       =  "home";
    contact.mobiletel  =  "mobiletel";
    contact.worktel    =  "worktel";
    contact.email      =  "email";
    contact.email2     =  "email2";
    contact.bday       =  "1";
    contact.bmonth     =  "May";
    contact.byear      =  "2000";
    contact.address2   =  "address2";
    contact.phone2     =   "phone2";       
	fillContactForm(contact);
    submitContactCreation();
    returnToContactPage();
  }
	


}

