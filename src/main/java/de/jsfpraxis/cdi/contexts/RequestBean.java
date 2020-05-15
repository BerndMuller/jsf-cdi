package de.jsfpraxis.cdi.contexts;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RequestBean {
	
	@Inject
	Logger logger;
	
	public RequestBean() {
		Logger.getLogger(RequestBean.class.getCanonicalName()).info("Instanz erzeugt mit Hash " + hashCode());
		
	}
	
	public void someBusinessFunction() {
		logger.info("'someBusinessFunction()' mit Hash " + hashCode());
	}
	
	@PostConstruct
	private void init() {
		logger.info("PostConstruct mit Hash " + hashCode());
	}
	
	@PreDestroy
	private void cleanup() {
		logger.info("PreDestroy mit Hash " + hashCode());
	}

}
