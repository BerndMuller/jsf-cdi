package de.jsfpraxis.cdi.producer;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Scopes {
	
	@Inject
	Logger logger;

	@Inject
	Foo foo;
	
	@PostConstruct
	public void init() {
		logger.info("Scopes generated");
	}
}
