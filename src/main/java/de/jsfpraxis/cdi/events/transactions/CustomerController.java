package de.jsfpraxis.cdi.events.transactions;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("ccTransactional")
@RequestScoped
public class CustomerController {
	
	private Customer customer;
	
	@Inject
	CustomerService customerService;

	public CustomerController() {
		customer = new Customer();
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public void persistThenFireEvent() {
		customerService.persistThenFireEvent(customer);
	}

	public void fireEventThenPersist() {
		customerService.fireEventThenPersist(customer);
	}

	public void persistThenFireEventThenException() {
		try {
			customerService.persistThenFireEventThenException(customer);	
		} catch (RuntimeException e) {
			// nothing
		}
	}
	
}
