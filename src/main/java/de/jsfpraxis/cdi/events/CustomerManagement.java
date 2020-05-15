package de.jsfpraxis.cdi.events;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.EventMetadata;
import javax.inject.Inject;

public class CustomerManagement {
	
	@Inject
	Logger logger;
	
	@SuppressWarnings("unused")
	private void onCustomerEvent(@Observes Customer customer) {
		// do something meaningful
		logger.info("onCustomerEvent with type: " + customer.getClass().getSimpleName());
		logger.info("customer event for customer number " +  customer.getNumber() );
	}

	@SuppressWarnings("unused")
	private void onCustomerEventOnly(@Observes @Default Customer customer) {
		logger.info("onCustomerEventOnly called");
	}
	
	@SuppressWarnings("unused")
	private void onCustomerCreatedEvent(@Observes @Created Customer customer) {
		logger.info("onCustomerCreatedEvent called");
	}
	
	@SuppressWarnings("unused")
	private void onPrivateCustomerEvent(@Observes PrivateCustomer customer) {
		logger.info("onPrivateCustomerEvent called");
	}
	
	@SuppressWarnings("unused")
	private void onCustomerRemindedEvent(@Observes @Reminded Customer customer) {
		logger.info("onCustomerRemindedEvent called");
	}
	
	@SuppressWarnings("unused")
	private void onCustomerRemindedSecondEvent(@Observes @Reminded("second") Customer customer, EventMetadata eventMetadata) {
		logger.info("onCustomerRemindedSecondEvent called");
		eventMetadata.getQualifiers().forEach(qualifier -> {
			logger.info("qualifier type: " + qualifier.annotationType());
		});
		Bean<?> bean = eventMetadata.getInjectionPoint().getBean();
		logger.info("Event fired from " + bean.getBeanClass().getSimpleName() + " with scope " + bean.getScope().getName());
	}
	
}

