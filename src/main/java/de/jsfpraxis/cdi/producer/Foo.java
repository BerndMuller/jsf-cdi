package de.jsfpraxis.cdi.producer;

import java.util.logging.Logger;

import javax.enterprise.inject.Vetoed;

@Vetoed
class Foo {

	public Foo() {
		Logger.getLogger(Foo.class.getCanonicalName()).info("Foo generated");
	}
	
}
