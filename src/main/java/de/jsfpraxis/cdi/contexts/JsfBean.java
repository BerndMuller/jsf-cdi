package de.jsfpraxis.cdi.contexts;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JsfBean {
	
	String input;

	@Inject
	RequestBean requestBean;
	
	@Inject
	SessionBean sessionBean;
	
	@Inject
	ApplicationBean applicationBean;
	
	@Inject
	Logger logger;
	
	public JsfBean() {
		Logger.getLogger(JsfBean.class.getCanonicalName()).info("Instanz erzeugt mit Hash " + hashCode());
	}
	
	public void someBusinessFunction() {
		requestBean.someBusinessFunction();
		sessionBean.someOtherBusinessFunction();
		applicationBean.someOtherBusinessFunction();
	}
	
	@PostConstruct
	private void init() {
		logger.info("PostConstruct mit Hash " + hashCode());
	}
	
	@PreDestroy
	private void cleanup() {
		logger.info("PreDestroy mit Hash " + hashCode());
	}

	
	// Getter und Setter
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
}
