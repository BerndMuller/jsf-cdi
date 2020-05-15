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
public class CustomerController implements Serializable {
	
	private Customer customer;
	
	@Inject
	Logger logger;
	
	@Inject
	Event<Customer> customerEvent;

	@Inject
	@Created
	Event<Customer> customerCreatedEvent;
	
	@Inject
	@Reminded
	Event<Customer> customerRemindedEvent;

	@Inject
	@Reminded("first")
	Event<Customer> customerRemindedFirstEvent;

	@Inject
	@Reminded("second")
	Event<Customer> customerRemindedSecondEvent;


	public CustomerController() {
		customer = new Customer();
	}

	public void save()  {
		// JPA persist() or similar
		customerEvent.fire(customer);
		logger.info("some customer event happened");
	}

	public void saveCreated()  {
		// JPA persist() or similar
		customerCreatedEvent.fire(customer);
		logger.info("customer created event happened");
	}
	
	public void remind() {
		customerRemindedEvent.fire(customer);
		logger.info("customer reminded event happened");
	}
	
	public void remindSecond() {
		customerRemindedSecondEvent.fire(customer);
		logger.info("customer reminded second time event happened");
	}
	

	
	// Getter and Setter
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
