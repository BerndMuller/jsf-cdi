package de.jsfpraxis.cdi.producer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class SpecialNumbers {

	@Named
	@Produces 
	Integer fourtyTwo = 42;

}
