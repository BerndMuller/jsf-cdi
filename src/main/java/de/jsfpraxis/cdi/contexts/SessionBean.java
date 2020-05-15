package de.jsfpraxis.cdi.contexts;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@SessionScoped
public class SessionBean implements Serializable {
	
	@Inject
	Logger logger;
	
	@Inject
	RequestBean requestBean;
	
	@Inject
	ExternalContext externalContext;
	
	public SessionBean() {
		Logger logger = Logger.getLogger(SessionBean.class.getCanonicalName());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		logger.info("Instanz erzeugt mit Hash " + hashCode());
		logger.info("Session: " + session.getId());
	}
	
	public void someOtherBusinessFunction() {
		requestBean.someBusinessFunction();
	}
	
	@PostConstruct
	private void init() {
		logger.info("PostConstruct mit Hash " + hashCode());
		HttpSession session = (HttpSession) externalContext.getSession(false);
		logger.info("Session: " + session.getId());
	}
	
	@PreDestroy
	private void preDestroy() {
		logger.info("PreDestroy mit Hash " + hashCode());
	}

}
