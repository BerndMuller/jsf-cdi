package de.jsfpraxis.cdi.events;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PrivateCustomerController implements Serializable {
	
	private PrivateCustomer customer;
	
	@Inject
	Logger logger;
	
	@Inject
	//Event<Customer> customerEvent;
	Event<PrivateCustomer> customerEvent;

	public PrivateCustomerController() {
		customer = new PrivateCustomer();
	}

	public void save()  {
		customerEvent.fire(customer);
		logger.info("some customer event happened");
	}
	
	// Getter and Setter
	public PrivateCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(PrivateCustomer customer) {
		this.customer = customer;
	}

}
