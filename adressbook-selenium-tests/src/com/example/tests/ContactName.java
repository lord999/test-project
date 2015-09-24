package com.example.tests;

public class ContactName implements Comparable<ContactName> {

	private String firstname;
	private String lastname;
	private String address;
	private String home;
	private String mobiletel;
	private String worktel;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String address2;
	private String phone2;

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

	public ContactName() {
	}

	@Override
	public String toString() {
		return "ContactName [firstname=" + firstname + " lastname=" + lastname + "]";

	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		int result = 1;
		// result = prime * result + ((firstname == null) ? 0 :
		// firstname.hashCode());
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
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
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

		if (other.lastname == null) {
			other.lastname = "";
		}
		if (this.lastname == null) {
			this.lastname = "";
		}

		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());

	}

	public ContactName withfirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactName withlastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactName withaddress(String address) {
		this.address = address;
		return this;
	}

	public ContactName withhome(String home) {
		this.home = home;
		return this;
	}

	public ContactName withmobiletel(String mobiletel) {
		this.mobiletel = mobiletel;
		return this;
	}

	public ContactName withworktel(String worktel) {
		this.worktel = worktel;
		return this;
	}

	public ContactName withemail(String email) {
		this.email = email;
		return this;
	}

	public ContactName withemail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactName withbday(String bday) {
		this.bday = bday;
		return this;
	}

	public ContactName withbmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactName withbyear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactName withaddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactName withphone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobiletel() {
		return mobiletel;
	}

	public String getWorktel() {
		return worktel;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}

}
