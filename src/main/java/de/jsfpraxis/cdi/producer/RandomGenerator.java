package de.jsfpraxis.cdi.producer;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class RandomGenerator {
	
	private static java.util.Random random = new java.util.Random();
	
	@Inject
	Logger logger;

	public RandomGenerator() {
	}

	@Named("nextRandom")
	@Random
	@Produces
	public /*static*/ Integer next() {
		Logger.getLogger(RandomGenerator.class.getCanonicalName()).info("next() aufgerufen");
		return random.nextInt();
	}

	@Produces 
	public Integer fourtyTwo() {
		return 42;
	}

	
	
	@PostConstruct
	public void init() {
		logger.info("Instanz erzeugt");
	}
	
}
