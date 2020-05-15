package de.jsfpraxis.cdi.producer;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

public class FooProducer {
	
	@SessionScoped
	@Produces
	public Foo fooProducer() {
		return new Foo();
	}

}
