package com.task1;

public class MyBean {
	String firstName;
	String lastName;

	public MyBean() {
		
	}

	public MyBean(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "MyBean [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
