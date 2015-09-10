package com.example.tests;

public class ContactName implements Comparable<ContactName> {

	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobiletel;
	public String worktel;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String address2;
	public String phone2;

	public ContactName(String firstname, String lastname, String address, String home, String mobiletel, String worktel,
			String email, String email2, String bday, String bmonth, String byear, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobiletel = mobiletel;
		this.worktel = worktel;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.address2 = address2;
		this.phone2 = phone2;
	}

	@Override
	public String toString() {
		return "ContactName [firstname=" + firstname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactName other = (ContactName) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactName other) {
		if (other.firstname == null) {
			other.firstname = "";
		}
		if (this.firstname == null) {
			this.firstname = "";
		}		
		
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	}

}
