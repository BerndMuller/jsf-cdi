package de.jsfpraxis.cdi.extension;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

/**
 * Beispiel für Bean, die über portable Extension instatiiert wird, ohne verwendet zu werden.
 * 
 * @author Bernd Müller
 *
 */
@Startup
@ApplicationScoped
public class SomeSingletonInstantiatedEagerly {

	@PostConstruct
	public void init() {
		// Log checken, um die Meldung zu sehen
		Logger.getLogger(SomeSingletonInstantiatedEagerly.class.getCanonicalName()).info("created!");
	}
}
