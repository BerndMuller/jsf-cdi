package de.jsfpraxis.cdi.contexts;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ApplicationBean {

	@Inject
	Logger logger;
	
	@Inject
	RequestBean requestBean;

	public ApplicationBean() {
		Logger.getLogger(ApplicationBean.class.getCanonicalName()).info("Instanz erzeugt mit Hash " + hashCode());
	}
	
	public void someOtherBusinessFunction() {
		requestBean.someBusinessFunction();
	}
	
	@PostConstruct
	private void init() {
		logger.info("PostConstruct mit Hash " + hashCode());
	}
	
	@PreDestroy
	private void preDestroy() {
		logger.info("PreDestroy mit Hash " + hashCode());
	}
	
}
