package de.jsfpraxis.cdi.contexts;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Beispiel für {@link javax.enterprise.inject.spi.InjectionPoint} 
 * 
 * @author Bernd Müller
 *
 */
public class LoggerProducer {
	
	//private static final Logger logger = Logger.getLogger(LoggerProducer.class.getCanonicalName());
	
	@Produces
    Logger produceLogger(InjectionPoint injectionPoint) {
//    	logger.info("injiziert in: " + injectionPoint.getMember());
//    	logger.info("der Klasse " + injectionPoint.getMember().getDeclaringClass());
//    	logger.info("Annotated: " + injectionPoint.getAnnotated());
//    	logger.info("Bean: " + injectionPoint.getBean());
//    	logger.info("Qualifiers: " + injectionPoint.getQualifiers());
//    	logger.info("Type: " + injectionPoint.getType());
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getCanonicalName());
    }
    
}
