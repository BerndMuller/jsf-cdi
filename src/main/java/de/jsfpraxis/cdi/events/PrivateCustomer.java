package de.jsfpraxis.cdi.events;

public class PrivateCustomer extends Customer {

	private String firstName;
	private String lastName;
	
	public PrivateCustomer() {
	}
	
	// Getter and Setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
