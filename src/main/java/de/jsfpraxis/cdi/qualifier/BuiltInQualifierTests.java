package de.jsfpraxis.cdi.qualifier;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@Startup
@ApplicationScoped
public class BuiltInQualifierTests {
	
	@Inject
	Logger logger;

	@Inject
	@Any // without @Any no bean is eligible
	Instance<Factorial> beans;
	

	@PostConstruct
	public void init() {
		for (Factorial bean: beans) {
			logger.info("gefunden: " + bean.toString());
		}
	}
}
