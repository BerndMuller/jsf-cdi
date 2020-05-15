package de.jsfpraxis.cdi.contexts;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Beispiel für {@link javax.enterprise.inject.spi.InjectionPoint} 
 * 
 * @author Bernd Müller
 *
 */
@Named
@RequestScoped
public class InjectionPoints {

	@Inject
	Logger logger;
	
	@Override
	public String toString() {
		logger.info("using injected Logger");
		return null;
	}
	
}
