package de.jsfpraxis.cdi.events.transactions;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import javax.transaction.TransactionSynchronizationRegistry;

public class DuringObserver {

	@Inject
	Logger logger;
	
	@Resource(lookup="java:comp/TransactionSynchronizationRegistry") 
	TransactionSynchronizationRegistry txReg;
	
	public DuringObserver() {
	}
	
	public void observedAfterCompletion(@Observes(during = TransactionPhase.AFTER_COMPLETION) Customer customer) {
		logger.info("AFTER_COMPLETION " + txReg.getTransactionStatus());
	}

	public void observedAfterFailure(@Observes(during = TransactionPhase.AFTER_FAILURE) Customer customer) {
		logger.info("AFTER_FAILURE " + txReg.getTransactionStatus());
	}

	public void observedInProgress(@Observes(during = TransactionPhase.IN_PROGRESS) Customer customer) {
		logger.info("IN_PROGRESS " + txReg.getTransactionStatus());
		logger.info("customer Id is " + customer.getId());
	}

	public void observedBeforeCompletion(@Observes(during = TransactionPhase.BEFORE_COMPLETION) Customer customer) {
		logger.info("BEFORE_COMPLETION " + txReg.getTransactionStatus());
	}

	public void observedAfterSuccess(@Observes(during = TransactionPhase.AFTER_SUCCESS) Customer customer) {
		logger.info("AFTER_SUCCESS " + txReg.getTransactionStatus());
		logger.info("customer Id is " + customer.getId());
	}

}
