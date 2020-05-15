package de.jsfpraxis.cdi.producer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RandomController {

	@Inject 
	@Random
	Integer random;

	public RandomController() {
	}

	// Getter und Setter
	public Integer getRandom() {
		return random;
	}
	
}
