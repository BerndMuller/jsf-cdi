package de.jsfpraxis.cdi.events.transactions;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionSynchronizationRegistry;

@Stateless
public class CustomerService {
	
	@PersistenceContext
	EntityManager em;

	@Inject
	Logger logger;
	
	@Resource(lookup="java:comp/TransactionSynchronizationRegistry") 
	TransactionSynchronizationRegistry txReg;

	@Inject
	Event<Customer> customerEvent;
	
	public void persistThenFireEvent(Customer customer) {
		logger.info("running persistThenFireEvent()");
		logger.info("status " + txReg.getTransactionStatus());
		logger.info("before persist");
		em.persist(customer);
		logger.info("after persist, before fire");
		logger.info("status " + txReg.getTransactionStatus());
		customerEvent.fire(customer);
		logger.info("status " + txReg.getTransactionStatus());
		logger.info("after fire");
	}
	
	public void fireEventThenPersist(Customer customer) {
		logger.info("running fireEventThenPersist()");
		logger.info("before fire");
		customerEvent.fire(customer);
		logger.info("after fire, beforepersist");
		em.persist(customer);
		logger.info("after persist");
	}
	
	public void persistThenFireEventThenException(Customer customer) {
		logger.info("running persistThenFireEventThenException()");
		logger.info("before persist");
		em.persist(customer);
		logger.info("after persist, before fire");
		customerEvent.fire(customer);
		logger.info("after fire, before exception");
		throw new RuntimeException("Exception to rollback transaction");
	}
	

}
