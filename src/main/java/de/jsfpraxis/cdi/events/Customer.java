package de.jsfpraxis.cdi.events;

import javax.validation.constraints.NotNull;

public class Customer {

	@NotNull
	private Integer number;

	public Customer() {
	}

	// Getter Setter
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
